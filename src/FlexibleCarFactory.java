/**
 * Creates new FlexibleCars with given params, which are set in constructor
 * @author VHD
 *
 */
public class FlexibleCarFactory implements CarFactory {
	/*private Point initPos;
	private int initOri;*/
	private CarPosition cp;
	private Strategy<FlexibleMove> strategy;
	private int waitms;

	/**
	 * Set Params of new FlexibleCar which will be added to a given Driving Area by calling create().
	 * @param initPos Initial position
	 * @param initOri Initial orientation
	 * @param strategy
	 * @param waitms Time between position changement
	 */
/*	public FlexibleCarFactory(Point initPos, int initOri,
			Strategy<FlexibleMove> strategy, int waitms) {
		this.initPos = initPos;
		this.initOri = initOri;*/
	public FlexibleCarFactory(CarPosition cp,
			Strategy<FlexibleMove> strategy, int waitms) {
		this.cp = cp;
		this.strategy = strategy;
		this.waitms = waitms;
	}

	@Override
	/**
	 * Adds new flexibleCar to the given Driving Area
	 */
	public void create(DrivingArea area) {
		area.add(new FlexibleCar(area,cp, strategy, waitms), cp.getPoint());
	}
}
