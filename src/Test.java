
public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		//test1();
		//test2();
		test3();
		 
	}
	
	public static void test1() {
		Autodrom f = new Autodrom(40, 40);
		
		FastCarFactory fcf = new FastCarFactory();
		
		fcf.setName("FastCar1");
		fcf.setPos(new CarPosition(new Point(10, 10), Orientation.East));
		f.addCar(fcf);
		
		fcf.setName("FastCar2");
		fcf.setPos(new CarPosition(new Point(10, 12), Orientation.South));
		fcf.setStrategy(new CircleStrategy(2));
		f.addCar(fcf);
		
		fcf.setName("FastCar3");
		fcf.setPos(new CarPosition(new Point(9, 9), Orientation.West));
		fcf.setStrategy(new FastRandomStrategy());
		f.addCar(fcf);
				
		fcf.setName("FastCar4");
		fcf.setPos(new CarPosition(new Point(11,11),Orientation.West));
		f.addCar(fcf);
		
		FlexibleCarFactory flcf = new FlexibleCarFactory();
		
		flcf.setName("FlexibleCar1");
		flcf.setPos(new CarPosition(new Point(20, 10), Orientation.North));
		f.addCar(flcf);
		
		flcf.setName("FlexibleCar2");
		flcf.setPos(new CarPosition(new Point(13, 14), Orientation.East));
		flcf.setStrategy(new EightStrategy(2));
		f.addCar(flcf);
		
		flcf.setName("FlexibleCar3");
		flcf.setPos(new CarPosition(new Point(12, 4), Orientation.South));
		flcf.setStrategy(new RectangleStrategy(10, 25));
		f.addCar(flcf);
		
		flcf.setName("FlexibleCar4");
		flcf.setPos(new CarPosition(new Point(1, 20), Orientation.South));
		flcf.setStrategy(new CircleStrategy(5));
		f.addCar(flcf);
		
		flcf.setName("FlexibleCar5");
		flcf.setPos(new CarPosition(new Point(14, 14), Orientation.West));
		flcf.setStrategy(new RectangleStrategy(10, 40));
		f.addCar(flcf);
		
		flcf.setName("FlexibleCar6");
		flcf.setPos(new CarPosition(new Point(4, 1), Orientation.East));
		f.addCar(flcf);
		
		f.start();
	}
	
	public static void test2() {
		Autodrom f = new Autodrom(7, 7);
		
		FastCarFactory fcf = new FastCarFactory();
		
		fcf.setName("Alexander");
		fcf.setPos(new CarPosition(new Point(5, 5), Orientation.South));
		fcf.setStrategy(new CircleStrategy(3));
		f.addCar(fcf);
		
		fcf.setName("Peter");
		fcf.setPos(new CarPosition(new Point(6, 6), Orientation.North));
		fcf.setStrategy(new FastRandomStrategy());
		f.addCar(fcf);
		
		FlexibleCarFactory flcf = new FlexibleCarFactory();
		
		flcf.setName("Christian");
		flcf.setPos(new CarPosition(new Point(4, 4), Orientation.East));
		flcf.setStrategy(new EightStrategy(3));
		f.addCar(flcf);
		
		f.start();
	}
	
	public static void test3() {
		Autodrom f = new Autodrom(9, 9);
		
		FastCarFactory fcf = new FastCarFactory();
		
		fcf.setName("Johannes");
		fcf.setPos(new CarPosition(new Point(5, 5), Orientation.South));
		fcf.setStrategy(new CircleStrategy(3));
		f.addCar(fcf);
		
		fcf.setName("Alexandra");
		fcf.setPos(new CarPosition(new Point(2, 3), Orientation.South));
		fcf.setStrategy(new CircleStrategy(1));
		f.addCar(fcf);
		
		fcf.setName("Peter");
		fcf.setPos(new CarPosition(new Point(6, 6), Orientation.North));
		fcf.setStrategy(new FastRandomStrategy());
		f.addCar(fcf);
		
		fcf.setName("Michael");
		fcf.setPos(new CarPosition(new Point(8, 8), Orientation.West));
		fcf.setStrategy(new FastRandomStrategy());
		f.addCar(fcf);
		
		fcf.setName("Sabrina");
		fcf.setPos(new CarPosition(new Point(3, 1), Orientation.East));
		fcf.setStrategy(new FastRandomStrategy());
		f.addCar(fcf);
		
		FlexibleCarFactory flcf = new FlexibleCarFactory();
		
		flcf.setName("Alexander");
		flcf.setPos(new CarPosition(new Point(4, 4), Orientation.East));
		flcf.setStrategy(new EightStrategy(3));
		f.addCar(flcf);
		
		flcf.setName("Julia");
		flcf.setPos(new CarPosition(new Point(1, 4), Orientation.South));
		flcf.setStrategy(new RectangleStrategy(2, 3));
		f.addCar(flcf);
		
		flcf.setName("Daniel");
		flcf.setPos(new CarPosition(new Point(2, 6), Orientation.East));
		f.addCar(flcf);
		
		flcf.setName("Maximilian");
		flcf.setPos(new CarPosition(new Point(8, 7), Orientation.North));
		f.addCar(flcf);
		
		f.start();
	}
	
}
