public class FastCar extends Car {
	
	/**
	 * Creates a new Car that can only perform FastMoves.
	 */
	public FastCar(String name, DrivingArea area, Strategy<? extends FastMove> strategy,
			int waitms) {
		super(name, area, strategy, waitms);
	}
}
