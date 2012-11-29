public class FastCar extends Car {

	public FastCar(DrivingArea area, Point initPos, int initOri,
			Strategy<FastMove> strategy, int waitms) {
		super(area, initPos, initOri, strategy, waitms);
	}

}
