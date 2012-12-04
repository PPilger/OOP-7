public class ForwardLeftMove implements FastMove {
	private ForwardMove forwardMove = new ForwardMove();
	private LeftMove leftMove = new LeftMove();

	/**
	 * Returns a new CarPosition containing the left, forward point and the
	 * left-rotated orientation.
	 * 
	 * @param pos
	 *            the car position; has to be >= 0
	 */
	@Override
	public CarPosition nextPos(CarPosition pos) {
		pos = forwardMove.nextPos(pos);
		pos = leftMove.nextPos(pos);
		return pos;
	}
}
