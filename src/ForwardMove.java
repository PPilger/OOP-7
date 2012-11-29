
public class ForwardMove implements FastMove {

	@Override
	public CarPosition nextPos(CarPosition cp) {
		int x = cp.getPoint().getX(), y = cp.getPoint().getY();
		Point retPt;
		switch(cp.getOrientation())
		{
		case 0:
			y++;
			break;
		case 1:
			x++;
			break;
		case 2:
			y--;
			break;
		case 3:
			x--;
			break;
		default:
						
		}
		retPt = new Point(x, y);
		
		return new CarPosition(retPt, cp.getOrientation());
	}

	/*@Override
	public Point nextPos(Point pos, int ori) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int nextOri(int ori) {
		// TODO Auto-generated method stub
		return 0;
	}*/

}
