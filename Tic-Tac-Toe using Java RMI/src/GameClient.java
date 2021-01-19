/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Prince Vlad
 */
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.Scanner;

public class GameClient {
	
	Service game;
	Scanner keyboardSc;
	int winner = 0;
	int player = 1;
        String Player1, Player2;

	public GameClient() throws MalformedURLException, RemoteException, NotBoundException{
		game = (Service) Naming.lookup("gameRegistry");
		keyboardSc = new Scanner(System.in);
	}

	public int readPlay() {
		int play;
		do {
                        if(player==0)
                        System.out.println("Player " + Player1);
                        else
                            System.out.println("Player " + Player2);
			System.out.printf(
					"\nplease enter the number of the square "
							+ "where you want to place your %c (or 0 to refresh the board): \n",
					player, (player == 1) ? 'X' : 'O');
			play = keyboardSc.nextInt();
		} while (play > 9 || play < 0);
		return play;
	}

	public void playGame() throws RemoteException{
		int play;
		boolean playAccepted;

                System.out.print( "Enter Your Name Player 1: "); 
                Player1 = keyboardSc.next();
                System.out.print( "Enter Your Name Player 2: "); 
                Player2 = keyboardSc.next();

		do {
			player = ++player % 2;
			do {
				System.out.println(game.currentBoard());
				play = readPlay();
				if (play != 0) {
					playAccepted = game.play(--play / 3, play % 3, player);
					if (!playAccepted)
						System.out.println("Invalid play! Try again.");
				} else
					playAccepted = false;
			} while (!playAccepted);
			winner = game.checkWinner();
		} while (winner == -1);
		System.out.println(game.currentBoard());
	}

	public void congratulate() {
		if (winner == 2)
			System.out.printf("\nHow boring, it is a draw\n");
		else
			System.out.printf("\nCongratulations, player %s, YOU ARE THE WINNER!\n", (winner==0)?Player1:Player2);
	}

	
	/** The program starts running in the main method.
     * @param args */
	public static void main(String[] args) {
		/* TO DO */
		try{
			GameClient g = new GameClient();
			g.playGame();
			g.congratulate();
		}
		catch (MalformedURLException | RemoteException | NotBoundException e){}
	}

}
