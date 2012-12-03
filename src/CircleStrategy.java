import java.util.LinkedList;

/**
 * A strategy that lets a car drive in a circle.
 */
public class CircleStrategy extends RepeatedStrategy<FastMove> {

	/**
	 * Creates a new strategy where the car drives in a circle counterclockwise.
	 * Between each ForwardLeftMove, size ForwardMoves are done. The car starts
	 * with the ForwardMoves.
	 * 
	 * @param size
	 *            defines the size of the circle (0 ... smallest circle)
	 */
	public CircleStrategy(int size) {
		super(CircleStrategy.moves(size));
	}

	private static LinkedList<FastMove> moves(int size) {
		LinkedList<FastMove> moves = new LinkedList<FastMove>();
		ForwardLeftMove forwardLeft = new ForwardLeftMove();
		ForwardMove forward = new ForwardMove();

		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < size; j++) {
				moves.add(forward);
			}
			moves.add(forwardLeft);
		}

		return moves;
	}
}
