public class ForwardRightMove implements FastMove {
	private ForwardMove forwardMove = new ForwardMove();
	private RightMove rightMove = new RightMove();

	/**
	 * Returns a new CarPosition containing the right, forward point and the
	 * right-rotated orientation.
	 * 
	 * @param pos
	 *            the car position; has to be >= 0
	 */
	@Override
	public CarPosition nextPos(CarPosition pos) {
		pos = forwardMove.nextPos(pos);
		pos = rightMove.nextPos(pos);
		return pos;
	}
}
