import java.util.Scanner;

public class BlackJack
{
	private Player player;
	private Dealer dealer;

	public BlackJack()
	{
		player = new Player();
		dealer = new Dealer();

	}

	//play a game of blackjack with one player and one dealer
	public void playGame()
	{
		int restart = 1;
		Scanner keyboard = new Scanner(System.in);
		//while (want to play again) {
		while(restart == 1)
		{
			dealer.addCardToHand(dealer.dealCard());
			dealer.addCardToHand(dealer.dealCard());
			player.addCardToHand(dealer.dealCard());
			player.addCardToHand(dealer.dealCard());
			System.out.println(player.toString());

			System.out.println("Your current hand is " + player.getHandValue());
			System.out.println("The dealer's hand is " + dealer.getHandValue());
			System.out.println("Would you like to hit? Press 1 for a hit and 2 to stay.");
			int Answer = keyboard.nextInt();

			while (Answer == 1)
			{
				player.addCardToHand(dealer.dealCard());
				player.getHandValue();
				//ask player hit or stay
				System.out.println("Your current hand is " + player.getHandValue());
				if (player.getHandValue() > 21)
				{
					System.out.println("You BUST!");
					Answer = 2;
				} else {
					System.out.println("Would you like to hit? Press 1 for Yes and 2 for No");
					Answer = keyboard.nextInt();
				}
			}

			System.out.println("The dealer's hand is " + dealer.getHandValue());
			while (dealer.hit())
			{
				//dealer hit or stay
				System.out.println("The dealer hits.");
				dealer.addCardToHand(dealer.dealCard());
				System.out.println("The dealer's hand is " + dealer.getHandValue());
			}

			// check who wins
			if (player.getHandValue() > 21)
			{
				dealer.countWin();
				System.out.println("You currently have " + player.getWinCount() + " wins.");
				System.out.println("The dealer currently has " + dealer.getWinCount() + " wins.");
				System.out.println("You Lost! Would you like to play again?");
				player.resetHand();
				dealer.resetHand();
				System.out.println("Press 1 for Yes and 2 for No");
				restart = keyboard.nextInt();

			} else if (dealer.getHandValue() > 21)
			{
				player.countWin();
				System.out.println("You currently have " + player.getWinCount() + " wins.");
				System.out.println("The dealer currently has " + dealer.getWinCount() + " wins.");
				System.out.println("You Won! Would you like to play again?");
				player.resetHand();
				dealer.resetHand();
				System.out.println("Press 1 for Yes and 2 for No");
				restart = keyboard.nextInt();
			} else if (player.getHandValue() > dealer.getHandValue()) {
				player.countWin();
				System.out.println("You currently have " + player.getWinCount() + " wins.");
				System.out.println("The dealer currently has " + dealer.getWinCount() + " wins.");
				System.out.println("You Won! Would you like to play again?");
				player.resetHand();
				dealer.resetHand();
				System.out.println("Press 1 for Yes and 2 for No");
				restart = keyboard.nextInt();
			} else {
				dealer.countWin();
				System.out.println("You currently have " + player.getWinCount() + " wins.");
				System.out.println("The dealer currently has " + dealer.getWinCount() + " wins.");
				System.out.println("You Lost! Would you like to play again?");
				player.resetHand();
				dealer.resetHand();
				System.out.println("Press 1 for Yes and 2 for No"); 
				restart = keyboard.nextInt();
			}
		}			
		keyboard.close();
	}



	//(only one dealer card is visible)




	//determine a winner
	// if (neither player > 21)
	//comparison
	//update win count
	//play again
	//}






	public static void main(String[] args)
	{
		BlackJack game = new BlackJack();
		game.playGame();
	}
}