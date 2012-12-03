public class RightMove extends FlexibleMove {

	@Override
	public int nextOri(int currentOri) {
		return (currentOri + 1) % 4;
	}
}
