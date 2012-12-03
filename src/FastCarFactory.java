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
	 * Set Params of new FastCar which will be added to a given Driving Area by
	 * calling create().
	 * 
	 * @param initPos
	 *            Initial position
	 * @param initOri
	 *            Initial orientation
	 * @param strategy
	 * @param waitms
	 *            Time between position changement
	 */
	public FastCarFactory(CarPosition pos, Strategy<FastMove> strategy,
			int waitms) {
		this.pos = pos;
		this.strategy = strategy;
		this.waitms = waitms;
	}

	@Override
	/**
	 * Adds new FastCar to the given Driving Area
	 */
	public FastCar create(Autodrom autodrom, DrivingArea area) {
		FastCar car = new FastCar(autodrom, area, strategy, waitms);
		area.add(car, pos);

		return car;
	}
}
