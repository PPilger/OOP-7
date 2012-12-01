
public class CarUpdate {

	private final Car c;
	private final int ori;
	
	public CarUpdate(Car c,int ori )
	{
		this.c = c;
		this.ori = ori;
	}
	
	public Car getCar(){return c;}
	public int getorientation(){return ori;}
}
