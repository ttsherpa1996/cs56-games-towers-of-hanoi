package edu.ucsb.cs56.projects.games.towers_of_hanoi.view;
import java.awt.Color;
import java.awt.Graphics;
import javax.swing.*;

import java.awt.event.*;

class SwingHanoiJFrame extends JFrame{
	
	static int intFrom, intTo;
	static String from, to;
	static boolean init, stillGaming;
	static JPanel container = new JPanel();
	static SwingHanoiJFrame f = new SwingHanoiJFrame();

	
    public SwingHanoiJFrame() {

        super("Towers of Hanoi");
        setSize(500,500);
        setLocation(10,200);
        setBackground(Color.WHITE);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        

 
    	
    }


    public static void main(String[] args) {

	init = true;
	stillGaming= true;




		container.setLayout(new BoxLayout(container, BoxLayout.Y_AXIS));
		
		class ActionListener2 implements ActionListener {
			public void actionPerformed(ActionEvent e) {

					from = JOptionPane.showInputDialog("Which column do you want to move from?");
					to = JOptionPane.showInputDialog("move to where?");
					
					intFrom = Integer.parseInt(from);
					intTo = Integer.parseInt(to);
					init = false;
					
					JPanel hanoi = new HanoiJPanel(intFrom, intTo);
					container.add(hanoi);

					

				}
		}

		if(init == true){
			JPanel hanoi = new HanoiJPanel();
			container.add(hanoi);

			JButton makeMove = new JButton("make a move");
			makeMove.addActionListener(new ActionListener2());



		
						

				container.add(makeMove);


				init = false;

		}
		
		f.add(container);
		f.setSize(500,500);
		f.setVisible(true);


	//JPanel tile = new TileJPanel();
	
			

	}

    
    
}
