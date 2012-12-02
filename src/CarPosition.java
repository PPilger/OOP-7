/**
 * Stores a car's position (2D) and orientation. Orientation is stored clockwise (0 = North, 1 = East, 2 = South, 3 = West)
 * @author gsi-test
 *
 */
public class CarPosition {
	private Point pt;
	private int ori;
	
	/**
	 * copies object
	 * @param cp existing CarPosition must not be NULL
	 */
	public CarPosition(CarPosition cp)
	{
		this.pt = new Point(cp.getPoint().getX(), cp.getPoint().getY());
		this.ori = cp.getOrientation();
	}
	
	/**
	 * creates new object
	 * @param pt Point must not be NULL
	 * @param ori Orientation should be between 0 and 3 (0 = North, 1 = East, 2 = South, 3 = West)
	 */
	public CarPosition(Point pt, int ori)
	{
		this.pt = pt;
		//Orientation must be between 0 and 3
		this.ori = ori % 4;
	}
	
	/**
	 * Returns the Point
	 * @return stored Point
	 */
	public Point getPoint()
	{
		return pt;
	}
	
	/**
	 * Returns the Orientation
	 * @return stored Orientation, Value between 0 and 3 (0 = North, 1 = East, 2 = South, 3 = West)
	 */
	public int getOrientation()
	{
		return ori;
	}
}
