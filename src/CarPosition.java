/**
 * Stores a car's position (2D) and orientation. Orientation is stored clockwise
 * (0 = North, 1 = East, 2 = South, 3 = West)
 * 
 * @author gsi-test
 * 
 */
public class CarPosition {
	private Point point;
	private int ori;

	/**
	 * Copy constructor (deep copy)
	 * 
	 * @param pos
	 *            original CarPosition must not be NULL
	 */
	public CarPosition(CarPosition pos) {
		this.point = new Point(pos.getPoint().getX(), pos.getPoint().getY());
		this.ori = pos.getOrientation();
	}

	/**
	 * @param pt
	 *            Point must not be NULL
	 * @param ori
	 *            Orientation should be between 0 and 3 (0 = North, 1 = East, 2
	 *            = South, 3 = West)
	 */
	public CarPosition(Point pt, int ori) {
		this.point = pt;
		// Orientation must be between 0 and 3
		this.ori = ori % 4;
	}

	public Point getPoint() {
		return point;
	}

	/**
	 * Returns the Orientation
	 * 
	 * @return stored Orientation, Value from 0 to 3 (0 = North, 1 = East, 2 =
	 *         South, 3 = West)
	 */
	public int getOrientation() {
		return ori;
	}

	/**
	 * Returns the next position of the car (moving in the direction specified
	 * by the orientation).
	 */
	public CarPosition move() {
		Point point = this.point.move(this.ori);

		return new CarPosition(point, this.ori);
	}

	@Override
	public String toString() {
		return point + ", ori: " + ori;
	}
}
