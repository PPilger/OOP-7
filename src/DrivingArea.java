import java.util.*;

public class DrivingArea {
	private Map<Point, Set<Car>> positions = new HashMap<Point, Set<Car>>();
	private int width;
	private int height;

	public DrivingArea(int width, int height) {
		this.width = width;
		this.height = height;
	}

	public synchronized void add(Car car, Point point) {
		Set<Car> set;

		if (positions.containsKey(point)) {
			set = positions.get(point);
		} else {
			set = new HashSet<Car>();
			positions.put(point, set);
		}
		set.add(car);
	}

	/**
	 * @param car
	 * @param oldPos
	 * @return die Menge der getroffenen Autos oder null, wenn die neue Position
	 *         ausserhalb des gueltigen Bereichs liegt.
	 * 
	 *         result of fixPos musst be enteres as newPos param
	 */
	public synchronized void update(Car car, Point oldPos, Point newPos) {
		Set<Car> tmp;

		// delete old entry
		tmp = positions.get(oldPos);

		tmp.remove(car);

		if (tmp.isEmpty()) {
			positions.remove(oldPos);
		}

		// insert new entry
		if (positions.containsKey(newPos)) {
			tmp = positions.get(newPos);
		} else {
			tmp = new HashSet<Car>();
			positions.put(newPos, tmp);
		}

		for (Car other : tmp) {
			car.hit(other);
		}

		tmp.add(car);
	}

	/**
	 * Returns a valid Point which is part of this DrivingArea
	 * 
	 * @param pos
	 *            Any Point which will be checked whether it's placeable within
	 *            the area's boundary.
	 * @return The point as given as param, when it's valid. Else any valid
	 *         Point next to the boundary will be returned.
	 */
	public Point fixPos(Point pos) {
		int x = pos.getX(), y = pos.getY();
		if (x < 0 || y < 0 || x > this.width || y > this.height) {
			while (x < 0) {
				x++;
			}

			while (x >= this.width) {
				x--;
			}

			while (y < 0) {
				y++;
			}
			while (y >= this.height) {
				y--;
			}

			Point secPt = new Point(x, y);

			return secPt;
		}
		return pos;
	}
}