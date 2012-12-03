public abstract class Car extends Thread {
	private DrivingArea area;
	private Points points;
	private Strategy<? extends Move> strategy;
	private int waitms;

	// maximum amount of moves
	private int maxPath = 100;
	private int movedCnt = 0;

	public Car(DrivingArea area, Strategy<? extends Move> strategy, int waitms) {
		super(area, "Car");
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

				area.update(this, move, new OnHit());

				movedCnt++;

				if (movedCnt >= maxPath) {
					synchronized (area) {
						// check for interrupt to prevent multiple program exits
						if (Thread.interrupted()) {
							throw new InterruptedException();
						}

						System.out
								.println(this
										+ " hat das die max. Anzahl an Schritten erreicht.");

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

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Car (ThreadID: ");
		sb.append(this.getId());
		sb.append(", Moves: ");
		sb.append(this.movedCnt);
		sb.append(", Points: ");
		sb.append(this.points);
		sb.append(")");
		return sb.toString();
	}

	private class Points {
		private int value = 0;

		private void inc() {
			value++;
		}

		private void dec() {
			value--;
		}
	}

	public class OnHit {
		private OnHit() {

		}

		public void onHit(Car attacker, int attOri, Car defender, int defOri)
				throws InterruptedException {
			// assertions due to synchronization for this method
			// if a car wins, it has 10 points (points cannot be reduced)
			// only a single car can reach 10 points

			if (defOri == (attOri + 2) % 4) {
				// frontal crash => bonus point for attacker

				// wait if points are being manipulated
				synchronized (attacker.points) {
					// only one car can increase its points at any time
					synchronized (area) {
						// check for interrupt to prevent multiple program
						// exits, especially more than one winning car
						if (Thread.interrupted()) {
							throw new InterruptedException();
						}

						attacker.points.inc();

						if (attacker.points.value >= 10) {

							System.out.println(this
									+ " hat das Punktelimit erreicht.");

							// stop all cars
							area.interrupt();

							// The current thread is interrupted and will be
							// terminated at the next sleep or interrupt-check
						}
					}
				}

				System.out.println(attacker + " trifft " + defender
						+ " frontal.");
			} else {
				// non frontal crash => minus point for defender

				// wait if points are being manipulated
				synchronized (defender.points) {
					// check for interrupt to prevent a possible manipulation of
					// the winning Car
					if (Thread.interrupted()) {
						throw new InterruptedException();
					}

					defender.points.dec();
				}

				System.out.println(attacker + " trifft " + defender);
			}
		}
	}
}
