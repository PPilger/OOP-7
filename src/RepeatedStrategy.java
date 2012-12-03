import java.util.List;

/**
 * Defines a strategy that repeats a set of moves.
 * 
 * @author Peter Pilgerstorfer
 */
public abstract class RepeatedStrategy<P extends Move> implements Strategy<P> {
	private List<P> moves;
	private int pos = 0;

	/**
	 * Creates a new strategy that returns the specified moves repeatedly.
	 * 
	 * @param moves
	 *            the moves that should be repeated
	 */
	public RepeatedStrategy(List<P> moves) {
		this.moves = moves;
	}

	/**
	 * Returns the next move according to the strategy.
	 */
	public P nextMove() {
		pos = (pos + 1) % moves.size();
		return moves.get(pos);
	}
}
