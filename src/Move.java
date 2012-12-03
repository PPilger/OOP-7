/**
 * Returns new 3D position of Car, after moving a given one by the specified implemented class
 * @author gsi-test
 *
 */
public interface Move {

	public CarPosition nextPos(CarPosition cp);
	
	public int nextOri(int currentOri);
}
