public abstract class Car extends Thread {
	private int points = 0;
	private Point pos;
	private int ori;
	private Autodrom.DrivingArea area;
	private Strategy strategy;
	private int waitms;

	public Car(Point initPos, int initOri, Strategy strategy, int waitms) {

	}

	public void set(Autodrom.DrivingArea area) {

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
