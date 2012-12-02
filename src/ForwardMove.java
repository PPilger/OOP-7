public class ForwardMove implements FastMove {

	@Override
	public CarPosition nextPos(CarPosition pos) {
		int x = pos.getPoint().getX();
		int y = pos.getPoint().getY();
		int ori = pos.getOrientation();

		if (ori == 0) {
			y++;
		} else if (ori == 1) {
			x++;
		} else if (ori == 2) {
			y--;
		} else {
			x--;
		}

		pos = new CarPosition(new Point(x, y), ori);

		return pos;
	}
}
