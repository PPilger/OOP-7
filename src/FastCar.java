public class FastCar extends Car {
	public FastCar(String name, DrivingArea area, Strategy<? extends FastMove> strategy,
			int waitms) {
		super(name, area, strategy, waitms);
	}
}
