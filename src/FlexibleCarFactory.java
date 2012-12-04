/**
 * A CarFactory to create FlexibleCars on a DrivingArea.
 * 
 * @author VHD
 */
public class FlexibleCarFactory implements CarFactory {
	private String name;
	private CarPosition pos;
	private Strategy<? extends FlexibleMove> strategy;
	private int waitms;

	/**
	 * Creates a new CarFactory with default values: name="FlexibleCar",
	 * position=(0/0), orientation=North, strategy=FastRandomStrategy, waitms=20
	 */
	public FlexibleCarFactory() {
		this.name = "FlexibleCar";
		this.pos = new CarPosition(new Point(0, 0), Orientation.North);
		this.strategy = new FastRandomStrategy();
		this.waitms = 20;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setPos(CarPosition pos) {
		this.pos = pos;
	}

	public void setStrategy(Strategy<? extends FlexibleMove> strategy) {
		this.strategy = strategy;
	}

	public void setWaitms(int waitms) {
		this.waitms = waitms;
	}

	/**
	 * Returns a new FlexibleCar with the current values (name, strategy,
	 * waitms) on the specified DrivingArea.
	 * 
	 * The car is also added to the specified DrivingArea at the current
	 * position.
	 */
	@Override
	public FlexibleCar create(DrivingArea area) {
		FlexibleCar car = new FlexibleCar(name, area, strategy, waitms);
		area.add(car, pos);

		return car;
	}
}
