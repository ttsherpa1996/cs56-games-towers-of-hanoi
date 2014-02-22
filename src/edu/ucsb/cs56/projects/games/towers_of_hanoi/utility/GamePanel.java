package edu.ucsb.cs56.projects.games.towers_of_hanoi.utility;

import java.awt.*;
import javax.swing.*;
import java.util.ArrayList;

public class GamePanel extends JPanel {

	private ArrayList<ArrayList<Integer>> towers;

	public GamePanel(){
		super();
	}
	
	public void paint(Graphics g){
		if(towers==null){
			g.setColor(Color.RED);
			g.fillRect(50,50,100,100);
		}
		else{
			for(int i =1; i <= towers.size();i++){
				int towerWidth=80;
				int towerOffset = 20;
				g.setColor(Color.RED);
				g.fillRect(100*i,50,towerWidth,towerWidth);
				for(int j=towers.get(i-1).size();j > 0;j--){
					int offset = 100 - 20*((towers.get(i-1).size()-j)-1);
					int width = 20+ 20*towers.get(i-1).get(j-1);
					int height=10;
					g.setColor(Color.BLUE);
					g.fillRect(i*(towerWidth+towerOffset)+((towerWidth-width)/2),offset,width,height);
				}
			}
		}
	}

	public void setTowers(ArrayList<ArrayList<Integer>> t){
		towers=t;
	}

}

