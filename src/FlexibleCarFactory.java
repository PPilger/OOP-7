public class FlexibleCarFactory implements CarFactory {
	private Point initPos;
	private int initOri;
	private Strategy<FlexibleMove> strategy;
	private int waitms;

	public FlexibleCarFactory(Point initPos, int initOri,
			Strategy<FlexibleMove> strategy, int waitms) {
	}

	@Override
	public void create(DrivingArea area) {
	}
}
