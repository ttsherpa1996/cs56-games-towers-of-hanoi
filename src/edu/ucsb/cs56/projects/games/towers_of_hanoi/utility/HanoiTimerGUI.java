package edu.ucsb.cs56.projects.games.towers_of_hanoi.utility;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 Example class of how to use HanoiTimer.  Uses buttons and a 
 JLabel.  ActionListeners call the HanoiTimer's start/restart/stop methods.
*/
public class HanoiTimerGUI {
	
	private HanoiTimer GameTimer;
	private JPanel TimePanel;
	private JLabel TimeDisplay;
	private JFrame frame;
	private JPanel MainTimePanel;
	private JPanel GamePanel;
	
    
    public HanoiTimerGUI() {
	System.out.println("Making JFrame...");
	frame = new JFrame();
	System.out.println("JFrame made, setting close operation...");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        System.out.println("Making JLabels/JPanels...");
	System.out.flush();
	TimeDisplay = new JLabel("0",JLabel.CENTER);
        TimeDisplay.setForeground(Color.black);
        TimeDisplay.setBackground(Color.white);
        TimeDisplay.setOpaque(true);
        TimeDisplay.setFont(new Font("SansSerif", Font.BOLD, 20));
        TimeDisplay.setPreferredSize(new Dimension(100, 50));
		
	MainTimePanel = new JPanel(new BorderLayout());
		
	TimePanel = new JPanel(new BorderLayout());
        TimePanel.add(TimeDisplay, BorderLayout.CENTER);
	System.out.println("Making GameTimer");
	GameTimer = new HanoiTimer(1000);
	GameTimer.SetTimeElapsedText(TimeDisplay);
		
	JButton RestartButton = new JButton("Restart Timer");
	RestartButton.addActionListener(new RestartListener());
		
	JButton StopButton = new JButton("Stop Timer");
	StopButton.addActionListener(new StopListener());
		
	JButton StartButton = new JButton("Start Timer");
	StartButton.addActionListener(new StartListener());
		
	MainTimePanel.add(StopButton, BorderLayout.EAST);
	MainTimePanel.add(RestartButton, BorderLayout.WEST);
	MainTimePanel.add(TimePanel, BorderLayout.NORTH);
	MainTimePanel.add(StartButton, BorderLayout.SOUTH);
	
	JButton testButton = new JButton("GAME GOES HERE");
	GamePanel = new JPanel(new BorderLayout());
	GamePanel.add(testButton);

	frame.add(GamePanel,BorderLayout.SOUTH);	
        frame.add(MainTimePanel,BorderLayout.NORTH);
	frame.pack();
        frame.setVisible(true);
	System.out.println("Starting Timer, GUI should be displaying");	
	GameTimer.start(TimeDisplay);
    }
	
	class StartListener implements ActionListener {
		public void actionPerformed(ActionEvent event){
			GameTimer.start(TimeDisplay);
		}
	}
	
	class RestartListener implements ActionListener {
		public void actionPerformed(ActionEvent event){
			GameTimer.restart(TimeDisplay);
		}
	}
	
	class StopListener implements ActionListener {
		public void actionPerformed(ActionEvent event){
			GameTimer.stop(TimeDisplay);
		}
	}
	
    public static void main (String [] args) {
		
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
				new HanoiTimerGUI();
            }
        });
	}
}
