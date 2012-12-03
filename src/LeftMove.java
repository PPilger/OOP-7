public class LeftMove extends FlexibleMove {

	@Override
	public int nextOri(int currentOri) {
		return (currentOri + 3) % 4;
	}
}
