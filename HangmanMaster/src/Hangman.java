

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import javax.swing.JPanel;

public class Hangman extends JPanel{


	private static final long serialVersionUID = 1L;
	
	private int putPiece=0;
	
	
	public void setPutPiece(int putPiece) {
		this.putPiece=putPiece;
	}
	
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		
		g2.setColor(Color.WHITE);
		
		if(putPiece>=1)g2.drawLine(50, 299, 150, 299);
		if(putPiece>=2)g2.drawLine(100, 300, 100, 50);
		if(putPiece>=3)g2.drawLine(200, 50, 100, 50);
		if(putPiece>=4)g2.drawLine(200, 100, 200, 50);
		
                
		if(putPiece>=5)g2.drawOval(175, 100, 50, 50);
		if(putPiece>=6)g2.drawLine(200, 200, 200, 150);
		if(putPiece>=7)g2.drawLine(200, 200, 250, 250);
		if(putPiece>=8)g2.drawLine(200, 200, 150, 250);
		if(putPiece>=9)g2.drawLine(150, 150, 200, 175);
		if(putPiece>=10)g2.drawLine(250, 150, 200, 175);

	}

}
