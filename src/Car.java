public abstract class Car extends Thread {
	private DrivingArea area;
	private int points = 0;
	private CarPosition pos;
	private Strategy<? extends Move> strategy;
	private int waitms;

	// maximum amount of moves
	private int maxPath = Integer.MAX_VALUE;
	private int movedCnt = 0;

	public Car(DrivingArea area, CarPosition pos,
			Strategy<? extends Move> strategy, int waitms) {
		this.area = area;
		this.pos = pos;
		this.strategy = strategy;
		this.waitms = waitms;
	}

	public int getOrientation() {
		return this.pos.getOrientation();
	}

	@Override
	public void run() {

		try {
			while (points < 10 && movedCnt < maxPath) {
				// move car
				Move move = strategy.nextMove();
				Point point = pos.getPoint();
				CarPosition newPos = move.nextPos(pos);
				newPos = new CarPosition(area.fixPos(newPos.getPoint()),
						newPos.getOrientation());
				
				// update its position
				synchronized(area) {
					pos = newPos;
					area.update(this, point, newPos.getPoint());
				}

				movedCnt++;
				wait(waitms);
			}
		} catch (InterruptedException e) {
			System.out.println(this + " finished");
		}
	}

	/**
	 * 
	 * 
	 * @param other
	 *            the car that is hit
	 */
	public void hit(Car other) {
		points++;
		
		if (other.getOrientation() == (getOrientation() + 2) % 4) {
			// frontal crash
			points++;
		} else {
			other.points--;
		}
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Car [ThreadID: ");
		sb.append(this.getId());
		sb.append("; ");
		sb.append(pos);
		sb.append("; MoveCnt: ");
		sb.append(this.movedCnt);
		sb.append("; Points: ");
		sb.append(this.points);
		return sb.toString();
	}
}
