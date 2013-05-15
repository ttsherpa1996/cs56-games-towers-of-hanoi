package edu.ucsb.cs56.projects.games.towers_of_hanoi.view;

import java.awt.Graphics;
import javax.swing.*;
import java.awt.event.*;
import java.awt.Dimension;
import java.awt.Color;

class HanoiJPanel extends JPanel {
	public int from, to;
	public int coordFrom, coordTo;
    
    public HanoiJPanel(){
    	setPreferredSize(new Dimension(300,100));
    	setBackground(Color.CYAN);
		ActionListener al = new ActionListener(){
			public void actionPerformed(ActionEvent ae){
				repaint();
			}
		}; // action event for the Timer

    }
    
    public HanoiJPanel(int from, int to){
    	setPreferredSize( new Dimension(300,100));
    	setBackground(Color.CYAN);
    	coordFrom = from*50;
    	coordTo = to*50;
    	
    	
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
    	g.fillRect(this.coordTo, 450, 100, 20);

    	
    }

}
