import java.util.LinkedList;

/**
 * Laesst ein Auto in einem Achter fahren.
 */
public class EightStrategy extends Strategy<FlexibleMove> {
	
	/**
	 * Erstellt eine Achter fahr Strategie.
	 */
	public EightStrategy() {
		this(new LinkedList<FlexibleMove>());
	}
	
	private EightStrategy(LinkedList<FlexibleMove> moves) {
		super(moves);
		int size = 3;
		LeftMove flm = new LeftMove();
		RightMove frm = new RightMove();
		ForwardMove fwd = new ForwardMove();
		
		//first three left turns
		for(int i = 0; i < 3; i++)
		{
			for(int j = 0; j < size; j++)
			{
				moves.add(fwd);
			}
			moves.add(flm);
		}
		
		for(int i = 0; i < 4; i++)
		{
			for(int j = 0; j < size; j++)
			{
				moves.add(fwd);
			}
			moves.add(frm);
		}
		
		//last left turn
		for(int j = 0; j < size; j++)
		{
			moves.add(fwd);
		}
		moves.add(flm);
		
		//setze die moves so:
		// LLL(FL)RRR(FR)
	}
}
