/**
 * Represents a Car on a driving area.
 * 
 * @author Peter Pilgerstorfer
 */
public abstract class Car extends Thread {
	// Synchronisation strategy:
	// Every manipulation of score has to be synchronized to prevent
	// manipulating a winning car (score is accessed by multiple cars).

	// Termination strategy:
	// Before a possible termination, lock the DrivingArea (area) and check for
	// interrupts to prevent multiple terminations.
	// Termination is done by interrupting all Cars of the DrivingArea.
	//
	// After interrupting, the Thread must not be stopped explicitly. The
	// interrupt will take effect at the next interrupt check (before the next
	// manipulation) or after the end of the move (at sleep).
	// Reason: if the car wins, the move is counted as finished.

	private DrivingArea area;
	private Score score;
	private Strategy<? extends Move> strategy;
	private int waitms;
	private int movedCnt = 0; // number of completed moves so far

	public Car(String name, DrivingArea area,
			Strategy<? extends Move> strategy, int waitms) {
		super(area, name);
		this.area = area;
		this.score = new Score();
		this.strategy = strategy;
		this.waitms = waitms;
	}

	@Override
	public void run() {
		try {
			// The Thread runs until it is interrupted.
			for (;;) {
				Move move = strategy.nextMove();

				area.update(this, move);

				movedCnt++;

				if (movedCnt >= area.getMaxMoves()) {

					// follow the termination strategy:
					synchronized (area) {

						// check for interrupt to prevent multiple program exits
						if (Thread.interrupted()) {
							throw new InterruptedException();
						}

						System.out
								.println(this
										+ " hat die max. Anzahl an Schritten erreicht.");

						// stop all cars
						area.interrupt();

						// no termination due to termination strategy
					}
				}

				Thread.sleep(waitms);
			}
		} catch (InterruptedException e) {
			System.out.println(this + " ist fertig.");
		}
	}

	public void hit(Orientation thisOri, Car other, Orientation otherOri)
			throws InterruptedException {

		if (otherOri == thisOri.rotate(2)) { // frontal crash
			// frontalHit manipulates this.score
			synchronized (this.score) {
				frontalHit(other);
			}
		} else {
			// normalHit manipulates both scores

			// lock the two score objects in a well defined order to prevent
			// deadlocks
			if (this.getId() < other.getId()) {
				synchronized (this.score) {
					synchronized (other.score) {
						normalHit(other);
					}
				}
			} else {
				synchronized (other.score) {
					synchronized (this.score) {
						normalHit(other);
					}
				}
			}
		}
	}

	/**
	 * Has to be called with a lock on the score of this car
	 */
	private void frontalHit(Car other) throws InterruptedException {

		// follow the termination strategy:
		// (the car might win this game by incrementing the score)
		synchronized (area) {

			// check for interrupt to prevent multiple program exits
			if (Thread.interrupted()) {
				throw new InterruptedException();
			}

			System.out.println(this + " trifft " + other + " frontal.");

			// 1 Point + 1 Bonuspoint for the attacker
			this.score.inc(2);
		}
	}

	/**
	 * Has to be called with a lock on the score of this and the other car
	 */
	private void normalHit(Car other) throws InterruptedException {

		// follow the termination strategy:
		// (the car might win this game by incrementing the score)
		synchronized (area) {

			// check for interrupt to prevent multiple program exits
			// and to prevent a possible manipulation of the winning Car
			if (Thread.interrupted()) {
				throw new InterruptedException();
			}

			System.out.println(this + " trifft " + other);

			// 1 Point for the attacker, -1 Point for the defender
			other.score.dec(1);
			this.score.inc(1);
		}
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(this.getName());
		sb.append(" (");
		sb.append(this.movedCnt);
		sb.append(" moves, ");
		sb.append(this.score);
		sb.append(" points)");
		return sb.toString();
	}

	/**
	 * Represents the points of a car. Points also checks if the point-limit is
	 * reached. In this case all Cars on the DrivingArea are interrupted.
	 * 
	 * This class is not synchronized.
	 * 
	 * @author Peter Pilgerstorfer
	 */
	private class Score {
		private int value = 0;

		/**
		 * Has to be called with a lock on this score.
		 * 
		 * This method terminates the game if the score-limit is reached. As a
		 * result, the termination strategy has to be applied for calling this
		 * method.
		 */
		private void inc(int amount) {
			value += amount;

			if (value >= 10) {

				System.out.println(Car.this + " hat das Punktelimit erreicht.");

				// stop all cars
				area.interrupt();

				// no termination due to termination strategy
			}
		}

		/**
		 * Has to be called with a lock on this score
		 */
		private void dec(int amount) {
			value -= amount;

			if (value < 0) {
				value = 0;
			}
		}

		@Override
		public String toString() {
			return Integer.toString(value);
		}
	}
}
