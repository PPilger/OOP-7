/**
 * A CarFactory to create FastCars on a DrivingArea.
 * 
 * @author VHD
 * 
 */
public class FastCarFactory implements CarFactory {
	private String name;
	private CarPosition pos;
	private Strategy<? extends FastMove> strategy;
	private int waitms;

	/**
	 * Creates a new CarFactory with default values: name="FastCar",
	 * position=(0/0), orientation=North, strategy=FastRandomStrategy, waitms=10
	 */
	public FastCarFactory() {
		this.name = "FastCar";
		this.pos = new CarPosition(new Point(0, 0), Orientation.North);
		this.strategy = new FastRandomStrategy();
		this.waitms = 10;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setPos(CarPosition pos) {
		this.pos = pos;
	}

	public void setStrategy(Strategy<? extends FastMove> strategy) {
		this.strategy = strategy;
	}

	public void setWaitms(int waitms) {
		this.waitms = waitms;
	}

	/**
	 * Returns a new FastCar with the current values (name, strategy, waitms) on
	 * the specified DrivingArea.
	 * 
	 * The car is also added to the specified DrivingArea at the current
	 * position.
	 */
	@Override
	public FastCar create(DrivingArea area) {
		FastCar car = new FastCar(name, area, strategy, waitms);
		area.add(car, pos);

		return car;
	}
}
