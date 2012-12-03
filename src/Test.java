
public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Autodrom f = new Autodrom(100, 100);
		FastCarFactory fcf = new FastCarFactory();
		FlexibleCarFactory flcf = new FlexibleCarFactory();
		f.addCar(flcf);
		f.addCar(fcf);
		f.start();
	}

}
