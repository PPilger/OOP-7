/**
 * Stores a car's position and orientation.
 * 
 * @author gsi-test
 */
public class CarPosition {
	private Point point;
	private Orientation ori;

	/**
	 * Copy constructor (deep copy)
	 * 
	 * @param original
	 *            must not be NULL
	 */
	public CarPosition(CarPosition original) {
		this.point = new Point(original.getPoint().getX(), original.getPoint()
				.getY());
		this.ori = original.getOrientation();
	}

	/**
	 * @param point
	 *            must not be null
	 * @param ori
	 *            must not be null
	 */
	public CarPosition(Point point, Orientation ori) {
		this.point = point;
		this.ori = ori;
	}

	public Point getPoint() {
		return point;
	}

	public Orientation getOrientation() {
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
