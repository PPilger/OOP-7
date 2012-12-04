import java.util.ArrayList;
import java.util.List;

public class Autodrom {
	private List<Car> cars = new ArrayList<Car>();
	private DrivingArea area;

	public Autodrom(int width, int height, int maxMoves) {
		this.area = new DrivingArea(width, height, maxMoves);
	}

	/**
	 * Creates one car from the specified factory and adds it to the Autodrom.
	 */
	public void addCar(CarFactory factory) {
		Car car = factory.create(area);
		cars.add(car);
	}

	/**
	 * Starts all cars and blocks until they are finished.
	 */
	public void start() {
		for (Car c : cars) {
			c.start();
		}

		try {
			for (Car c : cars) {
				c.join();
			}

			System.out.println("Runde fertig ;-)");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
