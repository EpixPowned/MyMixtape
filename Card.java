public class Card
{
	public static final String FACES[] = {"ZERO","ACE","TWO","THREE","FOUR",
			"FIVE","SIX","SEVEN","EIGHT","NINE","TEN","JACK","QUEEN","KING"};

	private int suit;
	private int face;

  	//constructors
    public Card(int s, int f)
    {
        suit = s;
        face = f;
    }
    
    //return the blackjack value for the card
    //(2-10 for number cards, 10 for jack/queen/king, 11 for ace
    public int getValue()
    {
    	if (1 < face && face < 11) return face;
    	else if (face >= 11) return 10;
    	else return 11;
    }
  //toString
    public String toString()
    {
    		return " " + face;
    }
  	
 }
 