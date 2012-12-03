public class FastCar extends Car {
	public FastCar(Autodrom autodrom, DrivingArea area,
			Strategy<FastMove> strategy, int waitms) {
		super(autodrom, area, strategy, waitms);
	}
}
