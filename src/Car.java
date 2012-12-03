public abstract class Car extends Thread {
	private DrivingArea area;
	private Points points;
	private Strategy<? extends Move> strategy;
	private int waitms;

	// maximum amount of moves
	private int maxPath = 100;
	private int movedCnt = 0;

	public Car(String name, DrivingArea area, Strategy<? extends Move> strategy, int waitms) {
		super(area, name);
		this.area = area;
		this.points = new Points();
		this.strategy = strategy;
		this.waitms = waitms;
	}

	@Override
	public void run() {
		try {
			while (movedCnt < maxPath) {
				Move move = strategy.nextMove();

				area.update(this, move);

				movedCnt++;

				if (movedCnt >= maxPath) {
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
					}
				}

				Thread.sleep(waitms);
			}
		} catch (InterruptedException e) {
			System.out.println(this + " ist fertig.");
		}
	}

	public void hit(int thisOri, Car other, int otherOri)
			throws InterruptedException {
		// assertions due to synchronization for this method
		// if a car wins, it has 10 points (points cannot be reduced)
		// only a single car can reach 10 points

		if (otherOri == (thisOri + 2) % 4) {
			// frontal crash => bonus point for attacker

			System.out.println(this + " trifft " + other + " frontal.");

			this.points.inc();
		} else {
			// non frontal crash => minus point for defender

			System.out.println(this + " trifft " + other);

			other.points.dec();
		}
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(this.getName());
		sb.append(" (");
		sb.append(this.movedCnt);
		sb.append(" moves, ");
		sb.append(this.points);
		sb.append(" points)");
		return sb.toString();
	}

	/**
	 * Represents the points of a car. Points also checks if the point-limit is
	 * reached. In this case all Cars on the DrivingArea are interrupted.
	 * 
	 * This class is synchronized:
	 * 
	 * 1) Only one Thread can manipulate the points at a time.
	 * 
	 * 2) Locks the DrivingArea before an increment to prevent multiple
	 * terminations (e.g. two winners)
	 * 
	 * @author Peter Pilgerstorfer
	 */
	private class Points {
		private int value = 0;

		private synchronized void inc() throws InterruptedException {
			// only one car can increase its points at any time
			synchronized (area) {
				// check for interrupt to prevent multiple program
				// exits, especially more than one winning car
				if (Thread.interrupted()) {
					throw new InterruptedException();
				}

				value++;

				if (value >= 10) {
					System.out.println(this + " hat das Punktelimit erreicht.");

					// stop all cars
					area.interrupt();

					// The current thread is interrupted and will be
					// terminated at the next sleep or interrupt-check
				}
			}
		}

		private synchronized void dec() throws InterruptedException {
			// check for interrupt to prevent a possible manipulation of
			// the winning Car
			if (Thread.interrupted()) {
				throw new InterruptedException();
			}

			value--;
		}
		
		@Override
		public String toString() {
			return Integer.toString(value);
		}
	}
}
