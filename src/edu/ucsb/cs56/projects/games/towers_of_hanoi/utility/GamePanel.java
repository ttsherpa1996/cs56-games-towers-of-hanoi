package edu.ucsb.cs56.projects.games.towers_of_hanoi.utility;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import java.util.ArrayList;

import edu.ucsb.cs56.projects.games.towers_of_hanoi.model.TowersOfHanoiState;
import edu.ucsb.cs56.projects.games.towers_of_hanoi.model.TowersOfHanoiState.TowersOfHanoiIllegalMoveException;

public class GamePanel extends JPanel {
	private final int DISK_HEIGHT;
	private final int DISK_OFFSET;
	private final int TOWER_WIDTH;
	private final int TOWER_OFFSET;
	private final int INITIAL_OFFSET;//the offset from the top of the panel
	private final Color TOWER_COLOR = Color.RED;
	private final Color DISK_COLOR = Color.BLUE;
	private int maxBar;
	private int towerHeight=0;
	private int to, from;
	private TowersOfHanoiState state;
	
	private ArrayList<ArrayList<Integer>> towers;

	public GamePanel(){
		super();
		TOWER_WIDTH = 80;
		DISK_HEIGHT = 10;
		TOWER_OFFSET = 20;
		DISK_OFFSET = 20;
		INITIAL_OFFSET = 50;
		for(int tower = 1; tower <= 3; tower ++){//adds 3 buttons for each tower
			JButton temp = new JButton(Integer.toString(tower));
			temp.addActionListener(new TowerButton(tower));
			this.add(temp);
		}
	}
	
	public void paint(Graphics g){
		if(towers==null){
			return;
		}
		else{
			for(int tower = 1; tower <= towers.size(); tower++){
				g.setColor(TOWER_COLOR);
				g.fillRect((TOWER_WIDTH+TOWER_OFFSET)*tower,INITIAL_OFFSET,TOWER_WIDTH,towerHeight);
				for(int j=towers.get(tower-1).size();j > 0;j--){
					int offset =  DISK_OFFSET*((towers.get(tower-1).size()-j)-1);
					int y = (towerHeight + TOWER_OFFSET) - offset;
					int barWidth = TOWER_WIDTH - (TOWER_WIDTH/(maxBar+1))*(maxBar- towers.get(tower-1).get(j-1)); //Basically, this is: (max bar width)-(ratio of width : # of bars)*(biggest bar value - this bar's value).  This makes the bar width scale with # of bars and size of tower
					int x = tower*(TOWER_WIDTH+TOWER_OFFSET)+((TOWER_WIDTH-barWidth)/2);
					//int width = 20+ 20*towers.get(tower-1).get(j-1);
					g.setColor(DISK_COLOR);
					g.fillRect(x,y,barWidth,DISK_HEIGHT);
				}
			}
		}
	}

	public void setState(TowersOfHanoiState s){
		state = s;
		towers=s.getTowers();
		maxBar=towers.get(0).size()-1;//this assigns maxBar to the # of bars - 1 which is the same as the max # that represents a bar (ie: max possible value returned by towers.get(a).get(b) )
		towerHeight = (maxBar + 1) * 2 * DISK_HEIGHT;
	}
	
	private class TowerButton implements ActionListener{
		
		int towerNum;//this is the number that represents the tower
		
		public TowerButton(int towerNum){
			this.towerNum = towerNum;
		}
		
		@Override
		public void actionPerformed(ActionEvent arg0) {
			System.out.println(towerNum + " Pressed");
			if(from == 0){
				from = towerNum;
				return;
			}
			if(to == 0){
				to = towerNum;
				System.out.println("From: " + from + ", To: " + to);
				try {
					state.makeMove(from-1, to-1);
				} catch (TowersOfHanoiIllegalMoveException e) {
					System.out.println("Illegal Move");
					to = 0; from= 0;
				}
				to = 0;  from = 0;
				return;
			}
			to = 0;  from = 0;
			actionPerformed(arg0);
		}
		
	}
}

