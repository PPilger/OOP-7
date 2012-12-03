/**
 * Creates new FlexibleCars with given params
 * 
 * @author VHD
 * 
 */
public class FlexibleCarFactory implements CarFactory {
	private CarPosition pos;
	private Strategy<? extends FlexibleMove> strategy;
	private int waitms;

	/**
	 * Creates a new CarFactory with default values: position=(0/0),
	 * orientation=0, strategy=FastRandomStrategy, waitms=20
	 */
	public FlexibleCarFactory() {
		this.pos = new CarPosition(new Point(0, 0), 0);
		this.strategy = new FastRandomStrategy();
		this.waitms = 20;
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

	@Override
	/**
	 * Adds new flexibleCar to the given Driving Area
	 */
	public FlexibleCar create(DrivingArea area) {
		FlexibleCar car = new FlexibleCar(area, strategy, waitms);
		area.add(car, pos);
		
		return car;
	}
}
