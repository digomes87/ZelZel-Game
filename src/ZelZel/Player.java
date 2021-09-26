package ZelZel;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;


public class Player extends Rectangle{
	
	//var de controle
	public boolean right, up, down, left;
	public int spd = 4;
	
	public int curAnimation = 0;
	public int curFrames = 0, targetFrames = 15;
	
	public Player(int x, int y) {
		super(x, y, 32, 32);
	}

	//TO DO corrigir a orientacao dos movimentos
	public void tick() {
		boolean moved = false;
		
		if(right && Mundo.isFree(x+spd, y)) {
			x+=spd;
			moved = true;
		}else if(left && Mundo.isFree(x-spd, y)) {
			x-=spd;
			moved = true;
		}
		
		if(up && Mundo.isFree(x, y-spd)) {
			y-=spd;
			moved = true;
			
		}else if(down && Mundo.isFree(x, y+spd)) {
			y+=spd;
			moved = true;
		}
		
		if(moved) {
			// This code bellow is for change sprintSheet and make the moviment
			curFrames++;
			if(curFrames == targetFrames) {
				curFrames = 0;
				curAnimation++;
				if(curAnimation == SprintSheet.player_front.length) {
					curAnimation = 0;
				}
			}
		}
		
	}
	
	public void render(Graphics g) {
		g.drawImage(SprintSheet.player_front[curAnimation], x,y, 32, 32, null );
	}
}
