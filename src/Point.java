public class Point implements Comparable<Point> {
	private int x;
	private int y;

	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public Point move(int ori) {
		if (ori == 0) {
			return new Point(x, y + 1);
		} else if (ori == 1) {
			return new Point(x + 1, y);
		} else if (ori == 2) {
			return new Point(x, y - 1);
		} else {
			return new Point(x - 1, y);
		}
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + x;
		result = prime * result + y;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Point other = (Point) obj;
		if (x != other.x)
			return false;
		if (y != other.y)
			return false;
		return true;
	}

	@Override
	public int compareTo(Point o) {
		if (y < o.y) {
			return -1;
		} else if (y > o.y) {
			return 1;
		} else if (x < o.x) {
			return -1;
		} else if (x > o.x) {
			return 1;
		} else {
			return 0;
		}
	}

	@Override
	public String toString() {
		return "(" + x + "/" + y + ")";
	}
}
