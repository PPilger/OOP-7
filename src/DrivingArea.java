import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class DrivingArea {
	private Map<Point, Set<Car>> map = new HashMap<Point, Set<Car>>();
	private int width;
	private int height;
	
	public DrivingArea(int width, int height) {
		
	}
	
	public void add(Car car) {
		
	}
	
	/**
	 * @param oldPos
	 * @param car
	 * @return die Menge der getroffenen Autos
	 */
	public Set<Car> update(Point oldPos, Car car) {
		return null;
	}
	
	public Point fixedPos(Point pos) {
		return null;
	}
}
