public abstract class Car extends Thread {
	private DrivingArea area;
	private int points = 0;
	/*private Point pos;
	private int ori;*/
	private CarPosition cp;
	private Strategy<? extends Move> strategy;
	private int waitms;
	//maximum amount of moves
	private int maxPath = Integer.MAX_VALUE;
	private int movedCnt = 0;

	//public Car(DrivingArea area, Point initPos, int initOri, Strategy<? extends Move> strategy, int waitms) {
	public Car(DrivingArea area, CarPosition cp, Strategy<? extends Move> strategy, int waitms) {
		this.area = area;
		this.cp = cp;
		this.strategy = strategy;
		this.waitms = waitms;		
	}
	
	public int getOrientation()
	{return this.cp.getOrientation();}

	@Override
	public void run() {

		try {
		while(points < 10 && movedCnt < maxPath)
		{
			//move car
			Move mv;
			mv = strategy.nextMove();		
			Point oldPt = this.cp.getPoint();
			CarPosition nextPos = mv.nextPos(cp);
			nextPos = new CarPosition(area.fixPos(nextPos.getPoint()), nextPos.getOrientation());
			//update its position
			this.cp = nextPos;
			
			for(CarUpdate cu : this.area.update(oldPt, nextPos.getPoint(), this))
			{
				//frontal crash
				if(cu.getorientation() == (this.getOrientation() + 2) % 4)
				{
					this.points++;
				}
				else
				{
					cu.getCar().hit(this);
				}
			}
			
			
			
			movedCnt++;
			wait(waitms);			
		}
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}

	/**
	 * Decreases points of this car by one
	 * @param other the car by which this one was hit
	 */
	public void hit(Car other) {
		this.points--;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Car [ThreadID: ");
		sb.append(this.getId());
		sb.append("; ");
		sb.append(cp);
		sb.append("; MoveCnt: ");
		sb.append(this.movedCnt);
		sb.append("; Points: ");
		sb.append(this.points);
		return sb.toString();
	}
}
