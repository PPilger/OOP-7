import java.util.LinkedList;


public class EightStrategy extends Strategy<FlexibleMove> {
	
	public EightStrategy() {
		this(new LinkedList<FlexibleMove>());
	}
	
	private EightStrategy(LinkedList<FlexibleMove> moves) {
		super(moves);
		
		//setze die moves so:
		// LLL(FL)RRR(FR)
	}
}
