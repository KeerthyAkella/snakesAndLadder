
public class Player {
	
	private String playerName;
	private int score = 0;
	
	public Player(String playerName) {
		this.playerName = playerName;
		this.score = 0;
	}
	
	public String getName()	{
	    return playerName;
	}
	
	public void setName(String playerName)	{
	     this.playerName = playerName;
	}
	
	public int getScore()	{
	    return score;
	}
	
	public void setScore(int score)	{
	     this.score = score;
	}

	@Override
	public String toString() {
		return "Player [playerName=" + playerName + ", score=" + score + "]";
	}
	
}
