public class FlexibleCar extends Car {

	public FlexibleCar(DrivingArea area, Point initPos, int initOri,
			Strategy<FlexibleMove> strategy, int waitms) {
		super(area, initPos, initOri, strategy, waitms);
	}

}
