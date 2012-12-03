import java.util.ArrayList;
import java.util.Random;

/**
 * A strategy that creates random moves.
 */
public class FastRandomStrategy implements Strategy<FastMove> {
	private ArrayList<FastMove> possibleMoves;
	private Random random;

	public FastRandomStrategy() {
		possibleMoves = new ArrayList<FastMove>();
		possibleMoves.add(new ForwardLeftMove());
		possibleMoves.add(new ForwardMove());
		possibleMoves.add(new ForwardRightMove());

		random = new Random();
	}

	@Override
	public FastMove nextMove() {
		int randKey = random.nextInt(possibleMoves.size());
		return possibleMoves.get(randKey);
	}
}
