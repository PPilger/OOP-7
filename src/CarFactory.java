/**
 * A factory that creates Cars on a DrivingArea.
 * 
 * @author gsi-test
 */
public interface CarFactory {

	/**
	 * Returns a new Car on the specified DrivingArea.
	 * 
	 * The car is also added to the specified DrivingArea.
	 */
	public Car create(DrivingArea area);
}
