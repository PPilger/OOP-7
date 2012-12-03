import java.util.ArrayList;
import java.util.List;

/**
 * Stellt ein Autodrom dar.
 */
public class Autodrom extends ThreadGroup {
	private List<Car> cars = new ArrayList<Car>();
	private DrivingArea area;

	public Autodrom(int width, int height) {
		super("Cars");
		this.area = new DrivingArea(width, height);
	}

	public void addCar(CarFactory factory) {
		Car car = factory.create(this, area);
		cars.add(car);
	}

	/**
	 * Blockiert bis die Runde beendet wurde.
	 */
	public void start() {
		
		for (Car c : cars) {
			c.start();
		}

		try {
			for (Car c : cars) {
				c.join();
			}

			System.out.print("Runde Fertig ;-)");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		// boolean finished = false;
		//
		// while (!finished) {
		//
		// finished = true;
		// for (Car c : cars) {
		// if (c.isAlive()) {
		// finished = false;
		// break;
		// }
		// }
		// }

		// System.out.print("Runde Fertig ;-)");
	}
}
