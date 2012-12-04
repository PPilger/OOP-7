/**
 * Represents the movement strategy for a car.
 * 
 * @author Peter Pilgerstorfer
 * 
 * @param <P>
 *            specifies the supported moves of the strategy.
 */
public interface Strategy<P extends Move> {

	/**
	 * Returns the next move according to the strategy.
	 */
	public P nextMove();
}
