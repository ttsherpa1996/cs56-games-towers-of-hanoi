package edu.ucsb.cs56.projects.games.towers_of_hanoi.utility;

import javax.swing.*;

import edu.ucsb.cs56.projects.games.towers_of_hanoi.model.TowersOfHanoiState;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

/**
 * Example class of how to use HanoiTimer.  Uses buttons and a 
 * JLabel.  ActionListeners call the HanoiTimer's start/restart/stop methods.
*/
public class HanoiTimerGUI {
	
	private HanoiTimer GameTimer;
	private JPanel TimePanel;
	private JLabel TimeDisplay;
	private JFrame frame;
	private JPanel MainTimePanel;
	
	
	public HanoiTimerGUI() {
		frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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
		GameTimer = new HanoiTimer();
		GameTimer.setLabel(TimeDisplay);
		GameTimer.SetTimeElapsedText();
		
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
		
		frame.add(MainTimePanel,BorderLayout.NORTH);
		frame.pack();
		frame.setVisible(true);
		GameTimer.start();
	}
	
	class StartListener implements ActionListener {
		public void actionPerformed(ActionEvent event){
			GameTimer.start();
		}
	}
	
	class RestartListener implements ActionListener {
		public void actionPerformed(ActionEvent event){
			GameTimer.restart();
		}
	}
	
	class StopListener implements ActionListener {
		public void actionPerformed(ActionEvent event){
			GameTimer.stop();
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
