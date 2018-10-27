
import java.util.Hashtable;
public class WordGuesser {
	
	
	private String word;
	private Hashtable <Character,Boolean> wordCharacters;
	private int wrongLetters;
	private boolean allLettersGuessed;
	private char guess;
	
		public WordGuesser() {
		word=null;
		wordCharacters=null;
		wrongLetters=0;
		guess='\0';
	}
                
	public WordGuesser(String word) {
		super();
		this.word=word;
		wordCharacters = new Hashtable<Character,Boolean>();
		setHashtable();
	}
        
	
	public void setGuess(char guess){
		if(!(guess>= 'a' && guess <='z')) throw new IllegalArgumentException();
		this.guess=guess;
	}
        
	private void setHashtable() {
		for(int i=0;i<word.length();++i) {
			if(word.charAt(i)==' ')continue;
				wordCharacters.put(word.charAt(i), false);
		}
	}
        
	public char getGuess() {
		return guess;
	}
        
        
	public int getWrongLetters() {
		return wrongLetters;
	}
        
        
	public boolean getAllLettersGuessed() {
		return allLettersGuessed;
	}
        
        
	public String gameUpdate() {
		String gameUpdater="<html><center>";
		gameUpdater+="You are guessing: ";
		
		for(int i=0;i<word.length();++i) {
			if(word.charAt(i)==' ')gameUpdater+=" ";
			else if(!wordCharacters.get(word.charAt(i)) )gameUpdater+="_";
			else gameUpdater+=""+word.charAt(i);
		}
		
		gameUpdater+="<br>You have guessed ("+wrongLetters+") wrong letters <br>";
		gameUpdater+="Guess a letter: </center></html>";
		return gameUpdater;
	}
        
        
	public void checkGuess(char letter) {
		boolean isFound=false;
		for(int i=0;i<wordCharacters.size();++i) {
			if(wordCharacters.containsKey(letter)) {
				wordCharacters.put(letter, true);
				isFound=true;
			}
		}
		if(isFound)return;
		++wrongLetters;
	}
        
        
        
	public void checkGame() {
		if(wrongLetters == 10) {
			return;
		}
		allLettersGuessed=true;
		for(int i=0;i<wordCharacters.size();i++) {
			if(wordCharacters.contains(false))allLettersGuessed=false;
		}
	}
        
        
	public String displayResults() {
		String resultDisplayer="<html>";
		if(allLettersGuessed) {
			resultDisplayer+="<center>You win<br>";
			resultDisplayer+="You have guessed '"+word+"' correctly</center></html>";
		}else {
			resultDisplayer+="<center>Sorry, You lost!<br>";
			resultDisplayer+="The correct guess was '" +word+"'</center></html>";
		}
		return resultDisplayer;
	}
        
        
	

}
