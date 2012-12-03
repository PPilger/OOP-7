/**
 * Creates new FastCars with given params
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
	 * position=(0/0), orientation=0, strategy=FastRandomStrategy, waitms=10
	 */
	public FastCarFactory() {
		this.name = "FastCar";
		this.pos = new CarPosition(new Point(0, 0), 0);
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

	@Override
	/**
	 * Adds new FastCar to the given Driving Area
	 */
	public FastCar create(DrivingArea area) {
		FastCar car = new FastCar(name, area, strategy, waitms);
		area.add(car, pos);

		return car;
	}
}
