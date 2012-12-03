
public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Autodrom f = new Autodrom(100, 100);
		
		FastCarFactory fcf = new FastCarFactory();
		
		fcf.setName("FastCar1");
		fcf.setPos(new CarPosition(new Point(10, 10), 1));
		f.addCar(fcf);
		
		fcf.setName("FastCar2");
		fcf.setPos(new CarPosition(new Point(10, 12), 2));
		fcf.setStrategy(new CircleStrategy(2));
		f.addCar(fcf);
		
		fcf.setName("FastCar3");
		fcf.setPos(new CarPosition(new Point(9, 9), 3));
		fcf.setStrategy(new FastRandomStrategy());
		f.addCar(fcf);
				
		fcf.setName("FastCar4");
		fcf.setPos(new CarPosition(new Point(11,11),3));
		f.addCar(fcf);
		
		FlexibleCarFactory flcf = new FlexibleCarFactory();
		
		flcf.setName("FlexibleCar1");
		flcf.setPos(new CarPosition(new Point(90, 10), 4));
		f.addCar(flcf);
		
		flcf.setName("FlexibleCar2");
		flcf.setPos(new CarPosition(new Point(25, 25), 1));
		flcf.setStrategy(new EightStrategy(2));
		f.addCar(flcf);
		
		flcf.setName("FlexibleCar3");
		flcf.setPos(new CarPosition(new Point(25, 75), 2));
		flcf.setStrategy(new RectangleStrategy(10, 25));
		f.addCar(flcf);
		
		flcf.setName("FlexibleCar4");
		flcf.setPos(new CarPosition(new Point(75, 75), 2));
		flcf.setStrategy(new CircleStrategy(5));
		f.addCar(flcf);
		
		flcf.setName("FlexibleCar5");
		flcf.setPos(new CarPosition(new Point(75, 25), 3));
		flcf.setStrategy(new RectangleStrategy(10, 40));
		f.addCar(flcf);
		
		flcf.setName("FlexibleCar6");
		flcf.setPos(new CarPosition(new Point(90, 11), 1));
		f.addCar(flcf);
		
		f.start();
	}

}