import java.util.ArrayList;
import java.util.List;

/**
 * Stellt ein Autodrom dar. 
 */
public class Autodrom {
	private List<Car> cars = new ArrayList<Car>();
	private DrivingArea area;

	public Autodrom(int width, int height) {
		this.area = new DrivingArea(width, height);
	}

	public void addCar(CarFactory factory) {
		factory.create(area);
	}

	/**
	 * Blockiert bis die Runde beendet wurde.
	 */
	public void start() {
		
	}
}
