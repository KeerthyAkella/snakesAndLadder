import java.util.Random;

public class Dice {

	/*
    This method simulates the behavior of a dice.
    On roll it gives a random number between 1 and 6 (inclusive).
	 */
	final static Random rand = new Random();
	public static int roll() {
		return rand.nextInt(6) + 1;
	}

}