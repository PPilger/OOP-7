public class RightMove implements FlexibleMove {

	/**
	 * Returns a new CarPosition containing the right point and the rotated
	 * orientation.
	 * 
	 * @param pos
	 *            the car position; has to be >= 0
	 */
	public CarPosition nextPos(CarPosition pos) {
		Orientation ori = pos.getOrientation();

		ori = ori.rotate(1);

		pos = new CarPosition(pos.getPoint(), ori);

		return pos.move();
	}
}
