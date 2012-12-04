/**
 * Represents a move of a car.
 * 
 * @author gsi-test
 * 
 */
public interface Move {

	/**
	 * Returns a new CarPosition containing the new point and orientation.
	 * 
	 * @param pos
	 *            the car position; has to be >= 0
	 */
	public CarPosition nextPos(CarPosition pos);
}
