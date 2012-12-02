import java.util.LinkedList;
import java.util.Queue;

/**
 * Stores a List of moves and retrieves one after the other by calling nextMove() 
 * @author gsi-test
 *
 * @param <P> subclass of Move
 */
public abstract class Strategy<P extends Move> {
	private Queue<P> moves;
	
	/**
	 * A Strategy<P extends Move> object stores Moves
	 * @param moves A list of moves which will be returned by calling nextMove() 
	 */
	public Strategy(LinkedList<P> moves) {
		this.moves = moves;
	}
	
	/**
	 * Retrieves one move after the other, out of the list given to constructor
	 * @return the next move stored in the list
	 */
	public P nextMove() {
		P next = moves.poll();
		moves.offer(next);
		
		return next;
	}
}
