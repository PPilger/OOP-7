public class FlexibleCar extends Car {
	public FlexibleCar(Autodrom autodrom, DrivingArea area,
			Strategy<FlexibleMove> strategy, int waitms) {
		super(autodrom, area, strategy, waitms);
	}
}
