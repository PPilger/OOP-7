public class ForwardLeftMove extends FastMove {
	private ForwardMove forwardMove = new ForwardMove();
	private LeftMove leftMove = new LeftMove();

	@Override
	public CarPosition nextPos(CarPosition pos) {
		pos = forwardMove.nextPos(pos);
		pos = leftMove.nextPos(pos);
		return pos;
	}
}
