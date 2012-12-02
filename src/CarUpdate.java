/**
 * Stores a reference to a Car and a given Orientation which could differ from the associated car's one
 * @author gsi-test
 *
 */
public class CarUpdate {

	private final Car c;
	private final int ori;
	
	/**
	 * 
	 * @param c refered Car
	 * @param ori Orientation
	 */
	public CarUpdate(Car c,int ori )
	{
		this.c = c;
		this.ori = ori;
	}
	
	/**
	 * 
	 * @return Car
	 */
	public Car getCar(){return c;}
	
	/**
	 * 
	 * @return Orientation
	 */
	public int getorientation(){return ori;}
}
