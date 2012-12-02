import com.sun.org.apache.bcel.internal.generic.CPInstruction;
import com.sun.org.apache.bcel.internal.generic.Visitor;


public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Autodrom f = new Autodrom(100, 100);
		FastCarFactory fcf = new FastCarFactory(new CarPosition(new Point(50, 50), 0),new CircleStrategy(5),5);
		FlexibleCarFactory flcf = new FlexibleCarFactory(new CarPosition(new Point(50, 51), 2), new EightStrategy(), 3);
		f.addCar(flcf);
		f.addCar(fcf);
		f.start();
	}

}
