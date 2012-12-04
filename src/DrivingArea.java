import java.util.*;

public class DrivingArea extends ThreadGroup {
	private List<List<Set<Car>>> cells;
	private Map<Car, CarPosition> positions = new Hashtable<Car, CarPosition>(); // synchronized
	private int width;
	private int height;
	private int maxMoves;

	public DrivingArea(int width, int height, int maxMoves) {
		super("Cars");
		this.width = width;
		this.height = height;
		this.maxMoves = maxMoves;

		cells = new ArrayList<List<Set<Car>>>();
		for (int i = 0; i < height; i++) {
			List<Set<Car>> row = new ArrayList<Set<Car>>();

			for (int j = 0; j < width; j++) {
				row.add(new HashSet<Car>());
			}

			cells.add(row);
		}
	}

	private Set<Car> carsAt(Point point) {
		return cells.get(point.getY()).get(point.getX());
	}

	public int getMaxMoves() {
		return maxMoves;
	}

	public boolean add(Car car, CarPosition pos) {
		Set<Car> set;
		Point point = pos.getPoint();
		int x = point.getX();
		int y = point.getY();

		if (x < 0 || x >= width || y < 0 || y >= height) {
			return false;
		}

		if (positions.containsKey(pos)) {
			return false;
		}

		set = carsAt(point);

		synchronized (set) {
			set.add(car);
		}

		// positions is synchronized
		positions.put(car, pos);

		return true;
	}

	public void update(Car car, Move move) throws InterruptedException {
		CarPosition oldPos = positions.get(car);
		CarPosition newPos = move.nextPos(oldPos);
		Point oldPoint = oldPos.getPoint();
		Point newPoint = newPos.getPoint();

		newPoint = fixPoint(newPoint);
		newPos = new CarPosition(newPoint, newPos.getOrientation());

		Set<Car> oldCell = carsAt(oldPoint);
		Set<Car> newCell = carsAt(newPoint);

		// lock the smaller cell first to prevent deadlocks
		if (oldPoint.compareTo(newPoint) < 0) {
			synchronized (oldCell) {
				synchronized (newCell) {
					update(oldCell, newCell, car, newPos);
				}
			}
		} else {
			synchronized (newCell) {
				synchronized (oldCell) {
					update(oldCell, newCell, car, newPos);
				}
			}
		}

		positions.put(car, newPos);
	}

	/**
	 * oldCell and newCell have to be locked by a synchronized statement.
	 */
	private void update(Set<Car> oldCell, Set<Car> newCell, Car car,
			CarPosition newPos) throws InterruptedException {
		oldCell.remove(car);

		for (Car other : newCell) {
			CarPosition otherPos = positions.get(other);
			car.hit(newPos.getOrientation(), other, otherPos.getOrientation());
		}

		newCell.add(car);
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
	private Point fixPoint(Point pos) {
		int x = pos.getX();
		int y = pos.getY();

		x = Math.max(x, 0);
		x = Math.min(x, width - 1);

		y = Math.max(y, 0);
		y = Math.min(y, height - 1);

		return new Point(x, y);
	}

	public String toString() {
		// return positions.toString();
		StringBuilder sb = new StringBuilder();
		Iterator<Car> iter = positions.keySet().iterator();

		if (iter.hasNext()) {
			Car car = iter.next();
			Point p = positions.get(car).getPoint();

			sb.append(car.getName() + ": " + p);
		}

		while (iter.hasNext()) {
			Car car = iter.next();
			Point p = positions.get(car).getPoint();

			sb.append(", " + car.getName() + ": " + p);
		}

		return sb.toString();
	}
}