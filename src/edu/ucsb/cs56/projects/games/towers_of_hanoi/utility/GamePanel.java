package edu.ucsb.cs56.projects.games.towers_of_hanoi.utility;

import java.awt.*;
import javax.swing.*;
import java.util.ArrayList;

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
	
	private ArrayList<ArrayList<Integer>> towers;

	public GamePanel(){
		super();
		TOWER_WIDTH = 80;
		DISK_HEIGHT = 10;
		TOWER_OFFSET = 20;
		DISK_OFFSET = 20;
		INITIAL_OFFSET = 50;
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

	public void setTowers(ArrayList<ArrayList<Integer>> t){
		towers=t;
		maxBar=towers.get(0).size()-1;//this assigns maxBar to the # of bars - 1 which is the same as the max # that represents a bar (ie: max possible value returned by towers.get(a).get(b) )
		towerHeight = (maxBar + 1) * 2 * DISK_HEIGHT;
	}
/*
	private int getMax(){
		if(towers==null){
			return 0;
		}
		int max = 0;
		for(int tower = 0; tower < towers.size(); tower ++){
			for(int bar = 0; bar < towers.get(tower).size(); bar++){
				//System.out.println(towers.get(tower).get(bar));
				if(towers.get(tower).get(bar) > max){
					max = towers.get(tower).get(bar);
				}
			}
		}
		return max;
	}*/
	
}

