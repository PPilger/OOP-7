public class FlexibleCar extends Car {
	public FlexibleCar(DrivingArea area,
			Strategy<FlexibleMove> strategy, int waitms) {
		super(area, strategy, waitms);
	}
}
