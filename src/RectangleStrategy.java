import java.util.LinkedList;

/**
 * A strategy that lets a car go in a rectangle
 * 
 * @author Peter Pilgerstorfer
 */
public class RectangleStrategy extends RepeatedStrategy<FlexibleMove> {

	/**
	 * Creates a new strategy where the car goes in a width x height rectangle.
	 * The car starts along the width-side and turns left in each corner.
	 */
	public RectangleStrategy(int width, int height) {
		super(RectangleStrategy.moves(width, height));
	}

	private static LinkedList<FlexibleMove> moves(int width, int height) {
		LinkedList<FlexibleMove> moves = new LinkedList<FlexibleMove>();
		LeftMove left = new LeftMove();
		ForwardMove forward = new ForwardMove();

		// width-side
		for (int i = 0; i < width; i++) {
			moves.offer(forward);
		}

		moves.offer(left);

		// height-side
		for (int i = 0; i < height; i++) {
			moves.offer(forward);
		}

		moves.offer(left);

		return moves;
	}
}
