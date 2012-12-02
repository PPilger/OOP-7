import java.util.*;

import com.sun.org.apache.xalan.internal.xsltc.compiler.util.Util;
/**
 * Stellt ein Autodrom dar. 
 */
public class Autodrom extends Thread{
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
	public void run() {
		
		
		for(Car c: cars)
		{
			c.start();
		}
		
		boolean finished = false;
		
			
		while(!finished)
		{
			
			
			finished = true;
			for(Car c : cars)
			{
				if(c.isAlive())
				{
					finished = false;
					break;
				}
			}
		}
		
		System.out.print("RUnde Ferti ;-)");
		
	}
}
