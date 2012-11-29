import java.util.LinkedList;

/**
 * Laesst ein Auto zufaellig Kurven machen.
 */
public class RandomStrategy extends Strategy<FastMove> {

	/**
	 * Erstellt eine zufall-basierte Strategie. Dabei werden size Moves
	 * zufaellig erzeugt und wiederholt durchgefuehrt.
	 */
	public RandomStrategy(int size) {
		this(new LinkedList<FastMove>(), size);
	}

	private RandomStrategy(LinkedList<FastMove> list, int size) {
		super(list);

		// fuelle die liste mit zufaelligen moves (size stück)
		// Map<Integer, FastMove> vermutlich hilfreich
	}
}
