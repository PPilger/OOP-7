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
		
		//setze die moves so:
		// LLL(FL)RRR(FR)
	}
}
