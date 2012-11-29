import java.util.*;

public class DrivingArea {
	private Map<Point, Set<Car>> positions = new HashMap<Point, Set<Car>>();
	private int width;
	private int height;

	public DrivingArea(int width, int height) {
		this.width = width;
		this.height = height;
	}
	
	public void add(Car car, CarPosition cp) {
		Set<Car> cs;
		if((cs = positions.get(cp.getPoint())) != null)
		{
			cs.add(car);
		}
		else
		{
			cs = Collections.synchronizedSet(new TreeSet<Car>());
			cs.add(car);
			positions.put(cp.getPoint(), cs);			
		}
	}
	
	/**
	 * @param oldPos
	 * @param car
	 * @return die Menge der getroffenen Autos oder null, wenn die neue Position
	 *         ausserhalb des gueltigen Bereichs liegt.
	 */
	public Set<Car> update(Point oldPos, Car car) {
		return null;
	}

	public Point fixPos(Point pos) {
		return null;
	}
}