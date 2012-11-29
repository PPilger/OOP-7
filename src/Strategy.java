import java.util.LinkedList;
import java.util.Queue;


public abstract class Strategy<P extends Move> {
	private Queue<P> moves;
	
	public Strategy(LinkedList<P> moves) {
		this.moves = moves;
	}
	
	public P nextMove() {
		P next = moves.poll();
		moves.offer(next);
		
		return next;
	}
}
