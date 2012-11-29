import java.util.LinkedList;

/**
 * Laesst ein Auto im Kreis fahren.
 */
public class CircleStrategy extends Strategy<FastMove> {
	/**
	 * Erstellt eine im Kreis fahr Strategie. Wenn size 0 ist, faert das Auto
	 * den kleinst moeglichen Kreis (immer ForwardLeftMove). Sonst werden size
	 * ForwardMoves vor jedem Richtungswechsel durchgefuehrt.
	 */
	public CircleStrategy(int size) {
		this(new LinkedList<FastMove>(), size);
	}

	private CircleStrategy(LinkedList<FastMove> list, int size) {
		super(list);

		//setze die moves so:
		// (FL)FF...F (#F = size)
	}
}
