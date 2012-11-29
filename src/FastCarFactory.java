public class FastCarFactory implements CarFactory {
	private Point initPos;
	private int initOri;
	private Strategy<FastMove> strategy;
	private int waitms;

	public FastCarFactory(Point initPos, int initOri,
			Strategy<FastMove> strategy, int waitms) {
	}

	@Override
	public void create(DrivingArea area) {
	}
}
