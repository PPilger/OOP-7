public class ForwardRightMove implements FastMove {
	private ForwardMove forwardMove = new ForwardMove();
	private RightMove rightMove = new RightMove();

	@Override
	public CarPosition nextPos(CarPosition pos) {
		pos = forwardMove.nextPos(pos);
		pos = rightMove.nextPos(pos);

		return pos;
	}

}
