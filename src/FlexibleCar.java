public class FlexibleCar extends Car {
	
	/**
	 * Creates a new Car that can only perform FlexibleMoves.
	 */
	public FlexibleCar(String name, DrivingArea area,
			Strategy<? extends FlexibleMove> strategy, int waitms) {
		super(name, area, strategy, waitms);
	}
}
