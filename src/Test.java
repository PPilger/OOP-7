
public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Autodrom f = new Autodrom(100, 100);
		
		FastCarFactory fcf1 = new FastCarFactory();
		fcf1.setName("FastCar1");
		fcf1.setPos(new CarPosition(new Point(10, 10), 1));
		f.addCar(fcf1);
		
		FastCarFactory fcf2 = new FastCarFactory();
		fcf2.setName("FastCar2");
		fcf2.setPos(new CarPosition(new Point(10, 90), 2));
		fcf2.setStrategy(new CircleStrategy(2));
		f.addCar(fcf2);
		
		FastCarFactory fcf3 = new FastCarFactory();
		fcf3.setName("FastCar3");
		fcf3.setPos(new CarPosition(new Point(90, 90), 3));
		fcf3.setStrategy(new FastRandomStrategy());
		f.addCar(fcf3);
				
		FlexibleCarFactory flcf1 = new FlexibleCarFactory();
		flcf1.setName("FlexibleCar1");
		flcf1.setPos(new CarPosition(new Point(90, 10), 4));
		f.addCar(flcf1);
		
		FlexibleCarFactory flcf2 = new FlexibleCarFactory();
		flcf2.setName("FlexibleCar2");
		flcf2.setPos(new CarPosition(new Point(25, 25), 1));
		flcf2.setStrategy(new EightStrategy(2));
		f.addCar(flcf2);
		
		FlexibleCarFactory flcf3 = new FlexibleCarFactory();
		flcf3.setName("FlexibleCar3");
		flcf3.setPos(new CarPosition(new Point(25, 75), 2));
		flcf3.setStrategy(new RectangleStrategy(10, 25));
		f.addCar(flcf3);
		
		FlexibleCarFactory flcf4 = new FlexibleCarFactory();
		flcf4.setName("FlexibleCar4");
		flcf4.setPos(new CarPosition(new Point(75, 75), 2));
		flcf4.setStrategy(new CircleStrategy(5));
		f.addCar(flcf4);
		
		FlexibleCarFactory flcf5 = new FlexibleCarFactory();
		flcf5.setName("FlexibleCar5");
		flcf5.setPos(new CarPosition(new Point(75, 25), 3));
		flcf5.setStrategy(new RectangleStrategy(10, 40));
		f.addCar(flcf5);
		
		f.start();
	}

}
