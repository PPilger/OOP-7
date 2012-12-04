public class RightMove extends FlexibleMove {

	public CarPosition nextPos(CarPosition pos) {
		Orientation ori = pos.getOrientation();

		ori = ori.rotate(1);

		pos = new CarPosition(pos.getPoint(), ori);

		return pos.move();
	}
}
