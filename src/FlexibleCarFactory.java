/**
 * Creates new FlexibleCars with given params, which are set in constructor
 * 
 * @author VHD
 * 
 */
public class FlexibleCarFactory implements CarFactory {
	/*
	 * private Point initPos; private int initOri;
	 */
	private CarPosition pos;
	private Strategy<FlexibleMove> strategy;
	private int waitms;

	/**
	 * Set Params of new FlexibleCar which will be added to a given Driving Area
	 * by calling create().
	 * 
	 * @param initPos
	 *            Initial position
	 * @param initOri
	 *            Initial orientation
	 * @param strategy
	 * @param waitms
	 *            Time between position changement
	 */
	/*
	 * public FlexibleCarFactory(Point initPos, int initOri,
	 * Strategy<FlexibleMove> strategy, int waitms) { this.initPos = initPos;
	 * this.initOri = initOri;
	 */
	public FlexibleCarFactory(CarPosition pos, Strategy<FlexibleMove> strategy,
			int waitms) {
		this.pos = pos;
		this.strategy = strategy;
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
