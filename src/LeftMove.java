
public class LeftMove implements FlexibleMove {

	@Override
	public CarPosition nextPos(CarPosition cp) {
		int x = cp.getPoint().getX(), y = cp.getPoint().getY(), ori = cp.getOrientation();
		Point retPt;
		switch(ori)
		{
		case 0:
			x--;
			break;
		case 1:
			y++;
			break;
		case 2:
			x++;;
			break;
		case 3:
			y--;
			break;
		default:
						
		}
		
		//rotate orientation
		ori = (ori + 3) % 4;
		
		retPt = new Point(x, y);
		
		return new CarPosition(retPt, ori);
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
