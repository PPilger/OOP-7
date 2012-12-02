
// Verwende Left und Forward um Code wiederzuverwenden!
public class ForwardRightMove implements FastMove {

	@Override
	public CarPosition nextPos(CarPosition cp) {
		ForwardMove fmv = new ForwardMove();
		RightMove rmv = new RightMove();
		CarPosition retPos = cp;
		
		retPos = fmv.nextPos(retPos);
		retPos = rmv.nextPos(retPos);
		
		return retPos;
	}


}
