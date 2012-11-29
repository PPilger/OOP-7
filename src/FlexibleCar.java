public class FlexibleCar extends Car {

	public FlexibleCar(DrivingArea area, CarPosition cp,
			Strategy<FlexibleMove> strategy, int waitms) {
		super(area, cp, strategy, waitms);
	}

}
