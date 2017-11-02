import java.util.Arrays;

public class Player
{
	private Card[] hand;
	private int nextIndex;
	private int winCount;

	//constructor(s)
	public Player()
	{
		hand = new Card[11];
		nextIndex = 0;
		winCount = 0;
	}
	//add temp to this player's hand
	public  void addCardToHand( Card temp )
	{
		hand[nextIndex]= temp;
		nextIndex++;
	}

	//"discard" the Player's hand when a new round begins
	public  void resetHand( )
	{
		hand = new Card[hand.length];
		nextIndex = 0;
	}

	//increment the player's win count
	public void countWin()
	{

		winCount = winCount + 1; 
	}

	//return this player's win count
	public int getWinCount()
	{
		return winCount; 
	}

	//return the number of cards in hand
	public int getHandSize()
	{
		return nextIndex;
	}

	//compute the value of
	public int getHandValue()
	{
		int total = 0;
		int aces = 0;

		for(int j = 0;j < nextIndex;j++) {
			if (hand[j].getValue() == 11) aces++;
			total = hand[j].getValue() + total ; 
		}
		while (total > 21 && aces > 0) {
			total = total - 10;
			aces--;
		}
		return total;
	}

	public String toString()
	{
		return "hand = " + Arrays.toString(hand) + " \n-  # wins " + winCount;
	}
}