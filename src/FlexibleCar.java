public class FlexibleCar extends Car {
	public FlexibleCar(String name, DrivingArea area,
			Strategy<? extends FlexibleMove> strategy, int waitms) {
		super(name, area, strategy, waitms);
	}
}
