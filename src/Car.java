public abstract class Car extends Thread {
	private int points;
	private Point pos;
	private int ori;
	private DrivingArea area;
	private Strategy strategy;
	private int waitms;

	public Car(int points, Point initPos, int initOri, DrivingArea area,
			Strategy strategy, int waitms) {

	}

	@Override
	public void run() {

	}

	/**
	 * Erhoeht die Punkte um 1 bzw. 2 bei einem frontalen Aufprall. Reduziert
	 * die Punkte des anderen, wenn dieser von hinten getroffen wird.
	 */
	public void hit(Car other) {

	}

	@Override
	public String toString() {
		return null;
	}
}
