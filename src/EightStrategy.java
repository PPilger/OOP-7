import java.util.ArrayList;
import java.util.List;

/**
 * A strategy that lets a car drive an eight.
 */
public class EightStrategy extends RepeatedStrategy<FlexibleMove> {

	/**
	 * Creates a new strategy that lets the car drive an eight. The driven eight
	 * has a width of (size+2) and a height of (2*size+3) The car starts along
	 * the bottom line of the eight. The eight will be to the left side of the
	 * starting position.
	 * 
	 * size has to be >=0
	 */
	public EightStrategy(int size) {
		super(EightStrategy.moves(size));
	}

	private static List<FlexibleMove> moves(int size) {
		List<FlexibleMove> moves = new ArrayList<FlexibleMove>();
		LeftMove left = new LeftMove();
		RightMove right = new RightMove();
		ForwardMove forward = new ForwardMove();

		// lower circle (part 1)
		for (int i = 0; i < 2; i++) {
			for (int j = 0; j < size; j++) {
				moves.add(forward);
			}
			moves.add(left);
		}

		// upper circle
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < size; j++) {
				moves.add(forward);
			}
			moves.add(right);
		}

		// lower circle (part 2)
		for (int i = 0; i < 2; i++) {
			for (int j = 0; j < size; j++) {
				moves.add(forward);
			}
			moves.add(left);
		}

		return moves;
	}
}
