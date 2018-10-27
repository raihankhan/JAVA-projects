/* HangmanGUI is a class that will simulate the Hangman game through
 * a graphical user interface.
 * 
 * @author Brian Aguilar
 * @version 1.0
 * @since 2018-15-2
 * 
 */
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class HangmanGUI extends JFrame{
	
	private static final long serialVersionUID = 1L;
	private JPanel gamePanel;
	private Hangman hangManDrawer;
	private JButton guessButton;
	private JLabel word;
	private JTextField letter;
	private JMenuBar menubar;
	private JMenu file;
	private JMenuItem newGame;
	private boolean gameStarted;
	private WordGuesser game;
	
	
	public HangmanGUI() {
		setTitle("Hangman");
		gameStarted=false;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(true);
		setSize(650,500);
		setLocationRelativeTo(null);
		setMenu();
		setup();
		setVisible(true);
	}
        
	private void setMenu() {
		menubar = new JMenuBar();
		setJMenuBar(menubar);
		menubar.setBackground(Color.BLACK);
		
		file = new JMenu("Options");
		menubar.add(file);
		file.setForeground(Color.WHITE);
		
		newGame = new JMenuItem("Start New Game");
		file.add(newGame);
	
		/*
		 * When the user clicks on the Start New Game button in the menu,
		 * a new random word will be produced and the game will start.
		 */
		newGame.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				game = new WordGuesser(new RandomWordGenerator("words.txt").generateRandomWord());
				gameStarted=true;
				hangManDrawer.setPutPiece(0);
				hangManDrawer.repaint();
				word.setText(game.gameUpdate());
				letter.enable(true);
				letter.setText("");
			}
		});
	}//setMenu
	
	/*
	 * A helper function that sets up the components of the game
	 * such as text input and buttons.
	 */
	@SuppressWarnings("deprecation")
	private void setup() {
		
		setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		GridBagConstraints d = new GridBagConstraints();
		Insets in = new Insets(50,50,50,50);
		
		this.getContentPane().setBackground(Color.BLACK);
		
		gamePanel = new JPanel();
		gamePanel.setLayout(new GridBagLayout());	
		gamePanel.setBackground(Color.BLACK);

		
		
		word = new JLabel("<html><center>Welcome to Hangman.<br>To start playing, click Start New Game<center></html>");
		c.gridwidth=1;
		c.weightx=1;
		c.weighty=.8;
		c.gridx=0;
		c.gridy=1;
		word.setForeground(Color.WHITE);
		word.setBorder(new EmptyBorder(50,50,50,50));
		gamePanel.add(word,c);
		
		
		letter = new JTextField(1);
		c.gridx=0;
		c.gridy=2;
		letter.enable(false);
		gamePanel.add(letter,c);
		
		
		guessButton = new JButton("Guess");
		c.gridx=0;
		c.gridy=3;
		c.insets=in;
		gamePanel.add(guessButton,c);

		d.gridx=0;
		d.gridy=0;
		d.weightx=.01;
		d.weighty=.2;
		add(gamePanel,d);
		
		hangManDrawer = new Hangman();
		d.gridx=1;
	    d.gridy=0;
		hangManDrawer.setBackground(Color.BLACK);
		hangManDrawer.setPreferredSize(new Dimension(300,300));
		add(hangManDrawer,d);

		/*
		 * When the user clicks on this button, it will set their guess
		 * and the game will start updating whether they are right or wrong.
		 */
		guessButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!gameStarted)return;
				try {
					game.setGuess(letter.getText().charAt(0));
				}catch (StringIndexOutOfBoundsException ex) {
					JOptionPane.showMessageDialog(null,"Please enter in a guess.");
					return;
				}catch(IllegalArgumentException ee) {
					JOptionPane.showMessageDialog(null, "Please enter in a letter.");
					return;
				}
				game.checkGuess(game.getGuess());
				game.checkGame();
				hangManDrawer.setPutPiece(game.getWrongLetters());
				hangManDrawer.repaint();
				
				if(game.getWrongLetters()==10 || game.getAllLettersGuessed()) {						
					word.setText(game.displayResults());
					gameStarted=false;
					letter.enable(false);
					return;
				}
				word.setText(game.gameUpdate());
			}
		});//ActionListener
	
		/*
		 * When the user hits the ENTER key when their mouse is clicked on the text input, 
		 * it will set their guess and the game will start updating whether they are right 
		 * or wrong.
		 */
		letter.addKeyListener(new KeyListener() {

			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub
				int key = e.getKeyCode();
				if(key== KeyEvent.VK_ENTER) {
					if(!gameStarted)return;

					try {
						game.setGuess(letter.getText().charAt(0));
					}catch (StringIndexOutOfBoundsException ex) {
						JOptionPane.showMessageDialog(null,"Please enter in a guess.");
						return;
					}catch(IllegalArgumentException ee) {
						JOptionPane.showMessageDialog(null, "Please enter in a letter.");
						return;
					}
					
					game.checkGuess(game.getGuess());
					game.checkGame();
					hangManDrawer.setPutPiece(game.getWrongLetters());
					hangManDrawer.repaint();
					
					if(game.getWrongLetters()==10 || game.getAllLettersGuessed()) {						
						word.setText(game.displayResults());
						gameStarted=false;
						letter.enable(false);
						return;
					}
					word.setText(game.gameUpdate());
				}
			}

			@Override
			public void keyReleased(KeyEvent arg0) {}
			@Override
			public void keyTyped(KeyEvent arg0) {}
			
		});//KeyListener
	}//setUp
}
