
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
		fcf.setPos(new CarPosition(new Point(10, 10), 1));
		fcf.setStrategy(new E(5));
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
		flcf.setPos(new CarPosition(new Point(20, 10), 4));
		f.addCar(flcf);
		
		flcf.setName("FlexibleCar2");
		flcf.setPos(new CarPosition(new Point(13, 14), 1));
		flcf.setStrategy(new EightStrategy(2));
		f.addCar(flcf);
		
		flcf.setName("FlexibleCar3");
		flcf.setPos(new CarPosition(new Point(12, 4), 2));
		flcf.setStrategy(new RectangleStrategy(10, 25));
		f.addCar(flcf);
		
		flcf.setName("FlexibleCar4");
		flcf.setPos(new CarPosition(new Point(1, 20), 2));
		flcf.setStrategy(new CircleStrategy(5));
		f.addCar(flcf);
		
		flcf.setName("FlexibleCar5");
		flcf.setPos(new CarPosition(new Point(14, 14), 3));
		flcf.setStrategy(new RectangleStrategy(10, 40));
		f.addCar(flcf);
		
		flcf.setName("FlexibleCar6");
		flcf.setPos(new CarPosition(new Point(4, 1), 1));
		f.addCar(flcf);
		
		f.start();
	}
	
	public static void test2() {
		Autodrom f = new Autodrom(7, 7);
		
		FastCarFactory fcf = new FastCarFactory();
		
		fcf.setName("Alexander");
		fcf.setPos(new CarPosition(new Point(5, 5), 2));
		fcf.setStrategy(new CircleStrategy(3));
		f.addCar(fcf);
		
		fcf.setName("Peter");
		fcf.setPos(new CarPosition(new Point(6, 6), 0));
		fcf.setStrategy(new FastRandomStrategy());
		f.addCar(fcf);
		
		FlexibleCarFactory flcf = new FlexibleCarFactory();
		
		flcf.setName("Christian");
		flcf.setPos(new CarPosition(new Point(4, 4), 1));
		flcf.setStrategy(new EightStrategy(3));
		f.addCar(flcf);
		
		f.start();
	}
	
	public static void test3() {
		Autodrom f = new Autodrom(9, 9);
		
		FastCarFactory fcf = new FastCarFactory();
		
		fcf.setName("Johannes");
		fcf.setPos(new CarPosition(new Point(5, 5), 2));
		fcf.setStrategy(new CircleStrategy(3));
		f.addCar(fcf);
		
		fcf.setName("Alexandra");
		fcf.setPos(new CarPosition(new Point(2, 3), 2));
		fcf.setStrategy(new CircleStrategy(1));
		f.addCar(fcf);
		
		fcf.setName("Peter");
		fcf.setPos(new CarPosition(new Point(6, 6), 0));
		fcf.setStrategy(new FastRandomStrategy());
		f.addCar(fcf);
		
		fcf.setName("Michael");
		fcf.setPos(new CarPosition(new Point(8, 8), 3));
		fcf.setStrategy(new FastRandomStrategy());
		f.addCar(fcf);
		
		fcf.setName("Sabrina");
		fcf.setPos(new CarPosition(new Point(3, 1), 1));
		fcf.setStrategy(new FastRandomStrategy());
		f.addCar(fcf);
		
		FlexibleCarFactory flcf = new FlexibleCarFactory();
		
		flcf.setName("Alexander");
		flcf.setPos(new CarPosition(new Point(4, 4), 1));
		flcf.setStrategy(new EightStrategy(3));
		f.addCar(flcf);
		
		flcf.setName("Julia");
		flcf.setPos(new CarPosition(new Point(1, 4), 2));
		flcf.setStrategy(new RectangleStrategy(2, 3));
		f.addCar(flcf);
		
		flcf.setName("Daniel");
		flcf.setPos(new CarPosition(new Point(2, 6), 1));
		f.addCar(flcf);
		
		flcf.setName("Maximilian");
		flcf.setPos(new CarPosition(new Point(8, 7), 0));
		f.addCar(flcf);
		
		f.start();
	}
	
}
