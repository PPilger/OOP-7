/**
 * Creates new FastCars with given params, which are set in constructor
 * 
 * @author VHD
 * 
 */
public class FastCarFactory implements CarFactory {

	private CarPosition pos;
	private Strategy<FastMove> strategy;
	private int waitms;

	/**
	 * 
	 * Creates a new CarFactory with default values:
	 * position=(0/0), orientation=0, strategy=FastRandomStrategy, waitms=10
	 */
	public FastCarFactory() {
		this.pos = new CarPosition(new Point(0, 0), 0);
		this.strategy = new FastRandomStrategy();
		this.waitms = 10;
	}

	public void setPos(CarPosition pos) {
		this.pos = pos;
	}

	public void setStrategy(Strategy<FastMove> strategy) {
		this.strategy = strategy;
	}

	public void setWaitms(int waitms) {
		this.waitms = waitms;
	}

	@Override
	/**
	 * Adds new FastCar to the given Driving Area
	 */
	public FastCar create(DrivingArea area) {
		FastCar car = new FastCar(area, strategy, waitms);
		area.add(car, pos);

		return car;
	}
}
