package edu.ucsb.cs56.projects.games.towers_of_hanoi.view;
import java.awt.Color;
import java.awt.Graphics;
import javax.swing.*;
import java.awt.event.*;

class SwingHanoiJFrame extends JFrame implements ActionListener{
	

	
    public SwingHanoiJFrame() {
        setTitle("Towers of Hanoi");
        setSize(500,500);
        setLocation(10,200);
        setBackground(Color.WHITE);
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    
    }
    public void setLayout(){
    	JFrame f = new SwingHanoiJFrame();
    	JPanel container = new JPanel();
    	container.setLayout(new BoxLayout(container, BoxLayout.Y_AXIS));
    	JPanel hanoi = new HanoiJPanel();
    	JPanel tile = new TileJPanel();
    	JButton makeMove = new JButton("make a move");
    	makeMove.addActionListener(this);

    	container.add(hanoi);
    	container.add(makeMove);
    	f.add(container);
    	f.setVisible(true);

    }

    public void actionPerformed(ActionEvent e) {
    JFrame frame = new JFrame("make a play");
	String from = JOptionPane.showInputDialog(frame, "Which column do you want to move from?");
	String to = JOptionPane.showInputDialog(frame, "move to where?");
	int intFrom = Integer.parseInt(from);
	int intTo = Integer.parseInt(to);
	JPanel hanoi = new HanoiJPanel(intFrom, intTo);
	hanoi.repaint();

	}

    public static void main(String[] args) {
	SwingHanoiJFrame h = new SwingHanoiJFrame();
	h.setLayout();
    }
}
