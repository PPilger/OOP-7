
// Verwende Left und Forward um Code wiederzuverwenden!
public class ForwardLeftMove implements FastMove {
	private ForwardMove forwardMove = new ForwardMove();
	private LeftMove leftMove = new LeftMove();

	@Override
	public CarPosition nextPos(CarPosition cp) {
		CarPosition retPos = cp;
		
		retPos = forwardMove.nextPos(retPos);
		retPos = leftMove.nextPos(retPos);
		
		return retPos;
	}

}
