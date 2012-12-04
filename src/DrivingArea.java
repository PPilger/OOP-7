import java.util.ArrayList;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.List;
import java.util.Set;

/**
 * Represents the area where cars drive on. It is used as a ThreadGroup for the
 * cars (Threads).
 * 
 * The class is synchonized.
 * 
 * @author Peter Pilgerstorfer
 */
public class DrivingArea extends ThreadGroup {
	// Stores rows of cells.
	// Every cell contains the Cars currently located on this position.
	// manually synchronized
	private List<List<Set<Car>>> cells;

	// Stores the positions of each car.
	// automatically synchronized (Hashtable)
	private Hashtable<Car, CarPosition> positions = new Hashtable<Car, CarPosition>();

	private int width;
	private int height;

	private int maxMoves;

	public DrivingArea(int width, int height, int maxMoves) {
		super("Cars");
		this.width = width;
		this.height = height;
		this.maxMoves = maxMoves;

		this.cells = new ArrayList<List<Set<Car>>>();
		for (int i = 0; i < height; i++) {
			List<Set<Car>> row = new ArrayList<Set<Car>>();

			for (int j = 0; j < width; j++) {
				row.add(new HashSet<Car>());
			}

			this.cells.add(row);
		}
	}

	private Set<Car> carsAt(Point point) {
		return cells.get(point.getY()).get(point.getX());
	}

	public int getMaxMoves() {
		return maxMoves;
	}

	/**
	 * Sets the specified car to the specified position.
	 * 
	 * If the position is invalid or the car is already on the driving area,
	 * false is returned. Otherwise true is returned.
	 * 
	 * Synchronization: The modified cell in cells is locked during
	 * modification.
	 */
	public boolean add(Car car, CarPosition pos) {
		Point point = pos.getPoint();
		int x = point.getX();
		int y = point.getY();
		Set<Car> set;

		if (x < 0 || x >= width || y < 0 || y >= height) {
			return false;
		}

		if (positions.containsKey(car)) {
			return false;
		}

		set = carsAt(point);

		// lock set during modification
		synchronized (set) {
			set.add(car);
		}

		positions.put(car, pos);

		return true;
	}

	/**
	 * Moves the car with the specified move.
	 * 
	 * The car was added to this DrivingArea before the call to update.
	 * 
	 * Neither car nor move are null.
	 * 
	 * Synchronization: The origin-cell and the target-cell in cells are both
	 * locked during the modifications. The two locks are acquired in a well
	 * defined order to prevent deadlocks. The lower cell is locked before the
	 * greater one using Point.compareTo (compare cell-indices).
	 */
	protected void update(Car car, Move move) throws InterruptedException {
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
	 * Moves car from oldCell to newCell.
	 * 
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
	 * Returns a valid point. A valid point is within the driving area.
	 * 
	 * @return The point as given as param if valid or the next valid point
	 *         otherwise.
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
}