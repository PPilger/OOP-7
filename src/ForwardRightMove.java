
// Verwende Left und Forward um Code wiederzuverwenden!
public class ForwardRightMove implements FastMove {
	private ForwardMove forwardMove = new ForwardMove();
	private RightMove rightMove = new RightMove();

	@Override
	public CarPosition nextPos(CarPosition cp) {
		CarPosition retPos = cp;
		
		retPos = forwardMove.nextPos(retPos);
		retPos = rightMove.nextPos(retPos);
		
		return retPos;
	}


}
