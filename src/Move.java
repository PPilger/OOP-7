/**
 * Returns new 3D position of Car, after moving a given one by the specified implemented class
 * @author gsi-test
 *
 */
public interface Move {
	/**
	 * Moves a Car
	 * @param cp 3D position before moving
	 * @return 3D postion after moving
	 */
	public CarPosition nextPos(CarPosition cp);
}
