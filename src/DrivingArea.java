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
			cs = Collections.synchronizedSet(new LinkedHashSet<Car>());
			cs.add(car);
			positions.put(cp.getPoint(), cs);			
		}
	}
	
	/**
	 * @param oldPos
	 * @param car
	 * @return die Menge der getroffenen Autos oder null, wenn die neue Position
	 *         ausserhalb des gueltigen Bereichs liegt.
	 *         
	 *         result of fixPos musst be enteres as newPos param 
	 */
	public Set<CarUpdate> update(Point oldPos, Point newPos, Car car) {
			
		this.positions.get(oldPos).remove(car);
		Set<Car> tmp = this.positions.get(newPos);
		LinkedHashSet<CarUpdate> hit = new LinkedHashSet<CarUpdate>();
		for(Car c : tmp)
		{
			hit.add(new CarUpdate(c,c.getOrientation()));
		}
		tmp.add(car);
		System.out.println(car);
		return hit;
	}

	/**
	 * Returns a valid Point which is part of this DrivingArea
	 * @param pos Any Point which will be checked whether it's placeable within the area's boundary. 
	 * @return The point as given as param, when it's valid. Else any valid Point next to the boundary will be returned.
	 */
	public Point fixPos(Point pos) {
		int x = pos.getX(), y = pos.getY();
		if( x < 0 || y < 0 || x > this.width || y > this.height)
		{						
			while(x < 0)
			{
				x++;
			}
			
			while(x >= this.width)
			{
				x--;
			}
			
			while(y < 0)
			{
				y++;
			}
			while(y >= this.height)
			{
				y--;
			}
			
			Point secPt = new Point(x, y);
			
			return secPt;
		}
		return pos;
	}
}