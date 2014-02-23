package edu.ucsb.cs56.projects.games.towers_of_hanoi.utility;

import java.awt.*;
import javax.swing.*;
import java.util.ArrayList;

public class GamePanel extends JPanel {
	private final int BAR_HEIGHT;
	private final int TOWER_WIDTH;
	private final int TOWER_OFFSET;
	
	private ArrayList<ArrayList<Integer>> towers;

	public GamePanel(){
		super();
		TOWER_WIDTH = 80;
		BAR_HEIGHT = 10;
		TOWER_OFFSET = 20;
	}
	
	public void paint(Graphics g){
		if(towers==null){
			g.setColor(Color.RED);
			g.fillRect(50,50,100,100);
		}
		else{
			for(int tower = 1; tower <= towers.size(); tower++){
				g.setColor(Color.RED);
				g.fillRect(100*tower,50,TOWER_WIDTH,TOWER_WIDTH);
				for(int j=towers.get(tower-1).size();j > 0;j--){
					int offset = 100 - 20*((towers.get(tower-1).size()-j)-1);
					int width = 20+ 20*towers.get(tower-1).get(j-1);
					g.setColor(Color.BLUE);
					g.fillRect(tower*(TOWER_WIDTH+TOWER_OFFSET)+((TOWER_WIDTH-width)/2),offset,width,BAR_HEIGHT);
				}
			}
		}
	}

	public void setTowers(ArrayList<ArrayList<Integer>> t){
		towers=t;
	}

}

