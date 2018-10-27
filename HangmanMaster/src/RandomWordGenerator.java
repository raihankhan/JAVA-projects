

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.JOptionPane;

public class RandomWordGenerator {
	
	
	private File file;
	private Scanner fileReader;
	private ArrayList<String> listOfWords;
	
	
	public RandomWordGenerator(String fileName) {
		try {
			file = new File(fileName);
			fileReader = new Scanner(file);
		}catch(FileNotFoundException ex) {
			JOptionPane.showMessageDialog(null, "File not found");
			return;
		}
		listOfWords = new ArrayList<String>();
	}
        
	private void generateList() {
		while(fileReader.hasNextLine()) {
			String line = fileReader.nextLine();
			listOfWords.add(line);
		}
        }
        
	public String generateRandomWord() {
		generateList();
		return listOfWords.get((int)(Math.random() * listOfWords.size()));
	}
}
