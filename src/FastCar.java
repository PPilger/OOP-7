public class FastCar extends Car {
	public FastCar(DrivingArea area, Strategy<? extends FastMove> strategy,
			int waitms) {
		super(area, strategy, waitms);
	}
}
