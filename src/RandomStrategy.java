import java.util.LinkedList;

public class RandomStrategy extends Strategy<FastMove> {

	public RandomStrategy() {
		this(new LinkedList<FastMove>());
	}

	public RandomStrategy(LinkedList<FastMove> list) {
		super(list);

		// fuelle die liste mit zufaelligen moves (Map<Integer, FastMove>
		// vermutlich hilfreich)
	}
}
