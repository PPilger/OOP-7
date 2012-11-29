public class FastCar extends Car {

	public FastCar(DrivingArea area, CarPosition cp,
			Strategy<FastMove> strategy, int waitms) {
		super(area, cp, strategy, waitms);
	}

}
