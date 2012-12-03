
public abstract class FlexibleMove implements Move {

	public CarPosition nextPos(CarPosition pos) {
		int ori = pos.getOrientation();

		pos = new CarPosition(pos.getPoint(), nextOri(ori));

		return pos.move();
	}

}
