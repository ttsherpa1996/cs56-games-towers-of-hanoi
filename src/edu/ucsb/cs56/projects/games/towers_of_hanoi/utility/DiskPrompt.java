package edu.ucsb.cs56.projects.games.towers_of_hanoi.utility;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JLabel;

public class DiskPrompt extends JFrame{
        
    private String diskInput;
    private JTextField txt = new JTextField();
    private JLabel label = new JLabel("Number of Disks");
    	
    public DiskPrompt(){
	super("Towers of Hanoi");
	
	JButton playButton = new JButton("Play");
	playButton.addActionListener(new playButtonListener());
	this.add(label, BorderLayout.NORTH);
	this.add(txt);
	//this.add(disksSlider, BorderLayout.NORTH);
	this.add(playButton,BorderLayout.SOUTH);
	this.setPreferredSize(new Dimension(300, 100));
	this.pack();
	this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	this.setVisible(true);
	
	// Focus the text field so the user doesn't have to click it
	EventQueue.invokeLater(new Runnable() {
		@Override
		public void run() {
		    txt.grabFocus();
		    txt.requestFocus();
		}
	    });
    }
    
    public String getString(){
	return diskInput;
    }
    
    private class playButtonListener implements ActionListener{
	
	@Override
	public void actionPerformed(ActionEvent e) {
	    diskInput = txt.getText();
	    System.out.println(diskInput);			
	}	
    }    
}
