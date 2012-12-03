import java.util.LinkedList;
import java.util.Queue;

/**
 * Defines a strategy that repeats a set of moves.
 * 
 * @author Peter Pilgerstorfer
 */
public abstract class RepeatedStrategy<P extends Move> implements Strategy<P> {
	private Queue<P> moves;

	/**
	 * Creates a new strategy that returns the specified moves repeatedly.
	 * 
	 * @param moves
	 *            the moves that should be repeated
	 */
	public RepeatedStrategy(LinkedList<P> moves) {
		this.moves = moves;
	}

	/**
	 * Returns the next move according to the strategy.
	 */
	public P nextMove() {
		P next = moves.poll();
		moves.offer(next);

		return next;
	}
}
