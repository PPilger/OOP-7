public class RightMove extends FlexibleMove {

	public CarPosition nextPos(CarPosition pos) {
		int ori = pos.getOrientation();

		ori = (ori + 1) % 4;

		pos = new CarPosition(pos.getPoint(), ori);

		return pos.move();
	}
}
