public class ForwardMove implements FastMove {

	/**
	 * Returns a new CarPosition containing the next point and same orientation.
	 * 
	 * @param pos
	 *            the car position; has to be >= 0
	 */
	public CarPosition nextPos(CarPosition pos) {
		return pos.move();
	}
}
