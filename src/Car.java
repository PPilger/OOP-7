public abstract class Car extends Thread {
	private DrivingArea area;
	private int points = 0;
	/*private Point pos;
	private int ori;*/
	private CarPosition cp;
	private Strategy<? extends Move> strategy;
	private int waitms;

	//public Car(DrivingArea area, Point initPos, int initOri, Strategy<? extends Move> strategy, int waitms) {
	public Car(DrivingArea area, CarPosition cp, Strategy<? extends Move> strategy, int waitms) {
		this.area = area;
		this.cp = cp;
		this.strategy = strategy;
		this.waitms = waitms;		
	}
	
	@Override
	public void start() {
		
	}

	@Override
	public void run() {
		while(points < 10 && )
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
