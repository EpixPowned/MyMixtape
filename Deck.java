public class Deck
{
//instance variables
private Card[] cards;
private int topCardIndex = 51;

//constructor
public Deck()
{
cards = new Card[52];

int i = 0;

for(int s = 0;s < 4;s++)
{
for(int v = 1;v <= 13; v++)
{
cards[i] = new Card(s,v);
i++;
}
}
}

public void shuffle()
{
//mix up cards
for(int i=0;i < 52;i++)
{
int rand1 = (int)(Math.random() * cards.length);
int rand2 = (int)(Math.random() * cards.length);

Card tmp = cards[rand1];
cards[rand1] = cards[rand2];
cards[rand2] = tmp;
}
}
//return how many cards remain undealt
public int numCardsLeft()
{
return topCardIndex;
}

//"deals" a Card from the stack
public Card nextCard()
{
Card next = cards[topCardIndex];
topCardIndex--;
return next;
}
public String toString()
{
String out = "";

for(int i = 0;i < cards.length;i++)
{
out = out + cards[i] + "\n";
}

return out;
}
}