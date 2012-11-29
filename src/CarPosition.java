
public class CarPosition {
	private Point pt;
	private int ori;
	
	public CarPosition(CarPosition cp)
	{
		this.pt = new Point(cp.getPoint().getX(), cp.getPoint().getY());
		this.ori = cp.getOrientation();
	}
	
	public CarPosition(Point pt, int ori)
	{
		this.pt = pt;
		//Orientation must be between 0 and 3
		this.ori = ori % 4;
	}
	
	public Point getPoint()
	{
		return pt;
	}
	
	public int getOrientation()
	{
		return ori;
	}
}
