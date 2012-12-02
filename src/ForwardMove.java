public class ForwardMove implements FastMove {

	@Override
	public CarPosition nextPos(CarPosition pos) {
		return pos.move();
	}
}
