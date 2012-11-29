
public class FlexibleCarFactory implements CarFactory {
	private Point initPos;
	private int initOri;
	private FlexibleStrategy strategy;

	public FlexibleCarFactory(Point initPos, int initOri, FlexibleStrategy strategy) {
	}

	@Override
	public void create(DrivingArea area) {
	}
}
