import java.util.ArrayList;
import java.util.Hashtable;

public class Board {
	private final int END = 100;
	private int ladderCount;
	private int snakeCount;

	private Hashtable<Integer, Integer> snakeNum;
	private Hashtable<Integer, Integer> ladderNum;

	private ArrayList<Player> players;
	private Player winner;

	public Board() {
		ladderCount = 0;
		snakeCount = 0;
		snakeNum = new Hashtable<Integer, Integer>();
		ladderNum = new Hashtable<Integer, Integer>();
		players = new ArrayList<Player>();
		winner = null;
	}

	public void addLadder(int i, int j) {
		if (ladderCount >= 7)
			System.out.println("ladder cannot be added");
		else {
			if (i < j) {
				ladderCount++;
				ladderNum.put(i, j);
			}
		}
	}

	public void addSnake(int i, int j) {
		if (snakeCount >= 7)
			System.out.println("snake cannot be added");
		else {
			if (i > j) {
				snakeCount++;
				snakeNum.put(i, j);
			}
		}
	}

	public void addPlayer(Player p1) {
		players.add(p1);
	}

	public boolean startGame() {
		if (players.size() < 2 && ladderCount < 5 && snakeCount < 5) 
			return false;
		boolean playerScore = true;
		while (playerScore)
			for (int i = 0; i < players.size(); i++) {
				int rollCount = Dice.roll();
				Player temp = players.get(i);

				if (temp.getScore() + rollCount <= 100)
					temp.setScore(temp.getScore() + rollCount);

				if (ladderNum.containsKey(temp.getScore()))
					temp.setScore(ladderNum.get(temp.getScore()));

				if (snakeNum.containsKey(temp.getScore()))
					temp.setScore(snakeNum.get(temp.getScore()));

				if (temp.getScore() == END) {
					playerScore = false;
					winner = temp;
					break;
				}
			}
		return true;
	}

	public Player getWinner() {
		return winner;
	}

}
