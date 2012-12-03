/**
 * Should add an existing car to a DrivingArea
 * @author gsi-test
 *
 */
public interface CarFactory {
	
	/**
	 * Should add a car to the given DrivingArea
	 * @param area on which the given Car should drive
	 */
	public Car create(DrivingArea area);
}
