public class LeftMove implements FlexibleMove {
	private ForwardMove forwardMove = new ForwardMove();

	@Override
	public CarPosition nextPos(CarPosition pos) {
		int ori = pos.getOrientation();

		// rotate orientation
		ori = (ori + 3) % 4;

		pos = new CarPosition(pos.getPoint(), ori);

		return forwardMove.nextPos(pos);
	}
}
