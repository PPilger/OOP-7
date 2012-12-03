public class ForwardMove extends FastMove {

	public CarPosition nextPos(CarPosition pos) {
		return pos.move();
	}
}
