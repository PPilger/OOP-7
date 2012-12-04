public class Test {

	public static void main(String[] args) {
		test1();
		test2();
		test3();
	}

	public static void test1() {
		Autodrom f = new Autodrom(40, 40, 100);
		FastCarFactory fastCarFac = new FastCarFactory();
		FlexibleCarFactory flexCarFac = new FlexibleCarFactory();

		System.out
				.println("\n\nTeste 40x40 Feld mit 10 Autos und max. 100 Schritten.\n");

		fastCarFac.setName("FastCar1");
		fastCarFac.setPos(new CarPosition(new Point(10, 10), Orientation.East));
		fastCarFac.setWaitms(8);
		f.addCar(fastCarFac);

		fastCarFac.setName("FastCar2");
		fastCarFac.setPos(new CarPosition(new Point(10, 12), Orientation.South));
		fastCarFac.setStrategy(new CircleStrategy(2));
		fastCarFac.setWaitms(12);
		f.addCar(fastCarFac);

		fastCarFac.setName("FastCar3");
		fastCarFac.setPos(new CarPosition(new Point(9, 9), Orientation.West));
		fastCarFac.setStrategy(new FastRandomStrategy());
		fastCarFac.setWaitms(10);
		f.addCar(fastCarFac);

		fastCarFac.setName("FastCar4");
		fastCarFac.setPos(new CarPosition(new Point(11, 11), Orientation.West));
		fastCarFac.setWaitms(13);
		f.addCar(fastCarFac);


		flexCarFac.setName("FlexibleCar1");
		flexCarFac.setPos(new CarPosition(new Point(20, 10), Orientation.North));
		flexCarFac.setWaitms(20);
		f.addCar(flexCarFac);

		flexCarFac.setName("FlexibleCar2");
		flexCarFac.setPos(new CarPosition(new Point(13, 14), Orientation.East));
		flexCarFac.setStrategy(new EightStrategy(2));
		flexCarFac.setWaitms(25);
		f.addCar(flexCarFac);

		flexCarFac.setName("FlexibleCar3");
		flexCarFac.setPos(new CarPosition(new Point(12, 4), Orientation.South));
		flexCarFac.setStrategy(new RectangleStrategy(10, 25));
		flexCarFac.setWaitms(22);
		f.addCar(flexCarFac);

		flexCarFac.setName("FlexibleCar4");
		flexCarFac.setPos(new CarPosition(new Point(1, 20), Orientation.South));
		flexCarFac.setStrategy(new CircleStrategy(5));
		flexCarFac.setWaitms(21);
		f.addCar(flexCarFac);

		flexCarFac.setName("FlexibleCar5");
		flexCarFac.setPos(new CarPosition(new Point(14, 14), Orientation.West));
		flexCarFac.setStrategy(new RectangleStrategy(10, 40));
		flexCarFac.setWaitms(24);
		f.addCar(flexCarFac);

		flexCarFac.setName("FlexibleCar6");
		flexCarFac.setPos(new CarPosition(new Point(4, 1), Orientation.East));
		flexCarFac.setWaitms(30);
		f.addCar(flexCarFac);

		f.start();
	}

	public static void test2() {
		Autodrom f = new Autodrom(7, 7, 200);
		FastCarFactory fastCarFac = new FastCarFactory();
		FlexibleCarFactory flexCarFac = new FlexibleCarFactory();

		System.out
				.println("\n\nTeste 7x7 Feld mit 3 Autos und max. 200 Schritten.\n");

		fastCarFac.setName("Alexander");
		fastCarFac.setPos(new CarPosition(new Point(5, 5), Orientation.South));
		fastCarFac.setStrategy(new CircleStrategy(2));
		fastCarFac.setWaitms(12);
		f.addCar(fastCarFac);

		fastCarFac.setName("Peter");
		fastCarFac.setPos(new CarPosition(new Point(6, 6), Orientation.North));
		fastCarFac.setStrategy(new FastRandomStrategy());
		fastCarFac.setWaitms(8);
		f.addCar(fastCarFac);
		

		flexCarFac.setName("Christian");
		flexCarFac.setPos(new CarPosition(new Point(4, 4), Orientation.East));
		flexCarFac.setStrategy(new EightStrategy(1));
		flexCarFac.setWaitms(25);
		f.addCar(flexCarFac);

		f.start();
	}

	public static void test3() {
		Autodrom f = new Autodrom(9, 9, 80);
		FastCarFactory fastCarFac = new FastCarFactory();
		FlexibleCarFactory flexCarFac = new FlexibleCarFactory();

		System.out
				.println("\n\nTeste 9x9 Feld mit 9 Autos und max. 80 Schritten.\n");

		fastCarFac.setName("Johannes");
		fastCarFac.setPos(new CarPosition(new Point(5, 5), Orientation.South));
		fastCarFac.setStrategy(new CircleStrategy(3));
		fastCarFac.setWaitms(8);
		f.addCar(fastCarFac);

		fastCarFac.setName("Alexandra");
		fastCarFac.setPos(new CarPosition(new Point(2, 3), Orientation.South));
		fastCarFac.setStrategy(new CircleStrategy(1));
		fastCarFac.setWaitms(10);
		f.addCar(fastCarFac);

		fastCarFac.setName("Peter");
		fastCarFac.setPos(new CarPosition(new Point(6, 6), Orientation.North));
		fastCarFac.setStrategy(new FastRandomStrategy());
		fastCarFac.setWaitms(14);
		f.addCar(fastCarFac);

		fastCarFac.setName("Michael");
		fastCarFac.setPos(new CarPosition(new Point(8, 8), Orientation.West));
		fastCarFac.setStrategy(new FastRandomStrategy());
		fastCarFac.setWaitms(12);
		f.addCar(fastCarFac);

		fastCarFac.setName("Sabrina");
		fastCarFac.setPos(new CarPosition(new Point(3, 1), Orientation.East));
		fastCarFac.setStrategy(new FastRandomStrategy());
		fastCarFac.setWaitms(9);
		f.addCar(fastCarFac);
		

		flexCarFac.setName("Alexander");
		flexCarFac.setPos(new CarPosition(new Point(4, 4), Orientation.East));
		flexCarFac.setStrategy(new EightStrategy(3));
		flexCarFac.setWaitms(22);
		f.addCar(flexCarFac);

		flexCarFac.setName("Julia");
		flexCarFac.setPos(new CarPosition(new Point(1, 4), Orientation.South));
		flexCarFac.setStrategy(new RectangleStrategy(2, 3));
		flexCarFac.setWaitms(19);
		f.addCar(flexCarFac);

		flexCarFac.setName("Daniel");
		flexCarFac.setPos(new CarPosition(new Point(2, 6), Orientation.East));
		flexCarFac.setWaitms(24);
		f.addCar(flexCarFac);

		flexCarFac.setName("Maximilian");
		flexCarFac.setPos(new CarPosition(new Point(8, 7), Orientation.North));
		flexCarFac.setWaitms(25);
		f.addCar(flexCarFac);

		f.start();
	}

}
