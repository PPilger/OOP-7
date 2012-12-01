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
	public Set<CarUpdate> update(Point oldPos, Point newPos, Car car) {
		int x = newPos.getX(), y = newPos.getY();
		if( x < 0 || y < 0 || x > this.width || y > this.height)
		{
			Point secPt = fixPos(newPos);
			//this.update(oldPos, secPt, car);
			return new TreeSet<CarUpdate>();
		}//TODO
		
		this.positions.get(oldPos).remove(car);
		Set<Car> tmp = this.positions.get(newPos);
		TreeSet<CarUpdate> hit = new TreeSet<CarUpdate>();
		for(Car c : tmp)
		{
			hit.add(new CarUpdate(c,c.getOrientation()));
		}
		tmp.add(car);
		return hit;
	}

	public Point fixPos(Point pos) {
		return null;
	}
}