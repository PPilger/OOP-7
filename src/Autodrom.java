import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;


public class Autodrom {
	private Map<Point, Set<Car>> positions = new HashMap<Point, Set<Car>>();
	private List<Car> cars = new ArrayList<Car>();
	private int width;
	private int height;
	
	public Autodrom(int width, int height) {
	}
	
	public void add(Car car) {
		
	}
	
	public void start() {
		
	}
	
	public class DrivingArea {

		private DrivingArea() {
			
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
}
