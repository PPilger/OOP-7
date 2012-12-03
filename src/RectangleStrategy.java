import java.util.ArrayList;
import java.util.List;

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

	private static List<FlexibleMove> moves(int width, int height) {
		List<FlexibleMove> moves = new ArrayList<FlexibleMove>();
		LeftMove left = new LeftMove();
		ForwardMove forward = new ForwardMove();

		// width-side
		for (int i = 0; i < width; i++) {
			moves.add(forward);
		}

		moves.add(left);

		// height-side
		for (int i = 0; i < height; i++) {
			moves.add(forward);
		}

		moves.add(left);

		return moves;
	}
}
