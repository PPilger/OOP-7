public class RightMove implements FlexibleMove {

	@Override
	public CarPosition nextPos(CarPosition pos) {
		int ori = pos.getOrientation();

		// rotate orientation
		ori = (ori + 1) % 4;
		
		pos = new CarPosition(pos.getPoint(), ori);

		return pos.move();
	}
}
