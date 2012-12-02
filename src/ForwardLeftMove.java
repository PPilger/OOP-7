
// Verwende Left und Forward um Code wiederzuverwenden!
public class ForwardLeftMove implements FastMove {

	@Override
	public CarPosition nextPos(CarPosition cp) {
		ForwardMove fmv = new ForwardMove();
		LeftMove lmv = new LeftMove();
		CarPosition retPos = cp;
		
		retPos = fmv.nextPos(retPos);
		retPos = lmv.nextPos(retPos);
		
		return retPos;
	}

}
