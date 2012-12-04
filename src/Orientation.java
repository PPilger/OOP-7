public enum Orientation {
	North(0, 0, 1), East(1, 1, 0), South(2, 0, -1), West(3, -1, 0);

	private int value;
	private int dx;
	private int dy;

	private Orientation(int value, int dx, int dy) {
		this.value = value;
		this.dx = dx;
		this.dy = dy;
	}

	public int dx() {
		return dx;
	}

	public int dy() {
		return dy;
	}

	/**
	 * Rotates the orientation by 90*amount degrees clockwise.
	 */
	public Orientation rotate(int amount) {
		int newValue = (value + amount) % 4;

		if (newValue == 0) {
			return North;
		} else if (newValue == 1) {
			return East;
		} else if (newValue == 2) {
			return South;
		} else {
			return West;
		}
	}
}
