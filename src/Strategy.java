public interface Strategy<P extends Move> {

	/**
	 * Returns the next move according to the strategy.
	 */
	public P nextMove();
}
