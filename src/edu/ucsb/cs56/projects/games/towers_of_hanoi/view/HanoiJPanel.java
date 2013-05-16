import java.awt.Graphics;
import javax.swing.*;

import java.awt.event.*;
import java.awt.Dimension;
import java.awt.Color;

class HanoiJPanel extends JPanel {
	String from, to;
	int coordFrom, coordTo;
	String numDisks;
	int intNumDisks = 0;
	static boolean firstScreen;

    
    public HanoiJPanel(){
    	setPreferredSize(new Dimension(300,100));
    	setBackground(Color.CYAN);
		ActionListener al = new ActionListener(){
			public void actionPerformed(ActionEvent ae){
				repaint();
			}
		}; // action event for the Timer
		
			numDisks = JOptionPane.showInputDialog("input number of disks (anything over 3 is probably a bad idea)");
			this.intNumDisks = Integer.parseInt(numDisks);
			firstScreen = true;

    	
	}
    
    	
    
    
    public HanoiJPanel(int from, int to){
    	setPreferredSize(new Dimension(300,100));
    	setBackground(Color.CYAN);
		ActionListener al = new ActionListener(){
			public void actionPerformed(ActionEvent ae){
				repaint();
			}
		}; // action event for the Timer
		
		
		setPreferredSize( new Dimension(300,100));
		setBackground(Color.CYAN);
			

		this.coordFrom = from * 100;
		this.coordTo = to * 100;
		repaint();
		System.out.println("2nd constructor");

		
    }
    
    public void paintComponent(Graphics g){
    	super.paintComponent(g);
    	g.setColor(Color.MAGENTA);
    	g.fillRect(100, 250, 10, 250);
    	g.setColor(Color.YELLOW);
    	g.fillRect(245, 250, 10, 250);
    	g.setColor(Color.RED);
    	g.fillRect(390, 250, 10, 250);
    	
    	g.setColor(Color.BLACK);
    	g.drawString("1", 100, 240);
    	g.drawString("2", 245, 240);
    	g.drawString("3", 390, 240);
    	
    	g.setColor(Color.WHITE);
    	if(firstScreen == true){
    		for (int i = 0; i< intNumDisks; i++){
    			g.fillRect(95 -i*5, 450 -(intNumDisks -i)*20 , 20 + i*10, 10);
    		}
    	}
    	else if(firstScreen == false){
    		for(int i = 0; i< intNumDisks; i++){ //stub for testing whether repainted JPanel
    			g.setColor(Color.BLACK);
    			g.fillRect(0, 0 , 300, 300);
    		}
    	}

    	
    }

}

