import java.util.ArrayList;
import java.util.List;

/**
 * A strategy that lets a car drive an eight.
 */
public class EightStrategy extends RepeatedStrategy<FlexibleMove> {

	/**
	 * Creates a new strategy that lets the car drive an eight. The driven eight
	 * has a width of (size+1) and a height of (2*size+3) The car starts along
	 * the bottom line of the eight.
	 */
	public EightStrategy(int size) {
		super(EightStrategy.moves(size));
	}

	private static List<FlexibleMove> moves(int size) {
		List<FlexibleMove> moves = new ArrayList<FlexibleMove>();
		LeftMove left = new LeftMove();
		RightMove right = new RightMove();
		ForwardMove forward = new ForwardMove();

		// first three left turns
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < size; j++) {
				moves.add(forward);
			}
			moves.add(left);
		}

		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < size; j++) {
				moves.add(forward);
			}
			moves.add(right);
		}

		// last left turn
		for (int j = 0; j < size; j++) {
			moves.add(forward);
		}
		moves.add(left);

		return moves;
	}
}
