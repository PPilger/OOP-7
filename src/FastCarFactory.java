/**
 * Creates new FastCars with given params, which are set in constructor
 * @author VHD
 *
 */
public class FastCarFactory implements CarFactory {

	private CarPosition cp;
	private Strategy<FastMove> strategy;
	private int waitms;

	/**
	 * Set Params of new FastCar which will be added to a given Driving Area by calling create().
	 * @param initPos Initial position
	 * @param initOri Initial orientation
	 * @param strategy
	 * @param waitms Time between position changement
	 */
	public FastCarFactory(CarPosition cp,
			Strategy<FastMove> strategy, int waitms) {
		this.cp = cp;
		this.strategy = strategy;
		this.waitms = waitms;
	}

	@Override
	/**
	 * Adds new FastCar to the given Driving Area
	 */
	public void create(DrivingArea area) {
		area.add(new FastCar(area, cp, strategy, waitms), cp);
		}
	}
