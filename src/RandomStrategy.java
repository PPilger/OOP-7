import java.util.LinkedList;
import java.util.Map;
import java.util.Random;
import java.util.TreeMap;

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
		Map<Integer, FastMove> myMp = new TreeMap<Integer, FastMove>();
		myMp.put(new Integer(0), new ForwardLeftMove());
		myMp.put(new Integer(1), new ForwardMove());
		myMp.put(new Integer(2), new ForwardRightMove());
		
		for(int i = 0; i < size; i++)
		{
			Random rnd = new Random();
			list.add(myMp.get(rnd.nextInt(3)));
		}
	}
}
