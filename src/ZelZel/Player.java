package ZelZel;
import java.awt.Graphics;
import java.util.List;
import java.awt.Rectangle;
import java.util.ArrayList;



public class Player extends Rectangle{
	
	//var de controle
	public boolean right, up, down, left;
	public int spd = 4;
	
	public int curAnimation = 0;
	public int curFrames = 0, targetFrames = 15;
	
	//system for bullets
	public static List<Bullets> bullets = new ArrayList<Bullets>();
	
	public boolean shoot = false;
	
	//the last direction of player
	public int dir = 1;
	
	public Player(int x, int y) {
		super(x, y, 32, 32);
	}

	//TO DO corrigir a orientacao dos movimentos
	public void tick() {
		boolean moved = false;
		
		if(right && Mundo.isFree(x+spd, y)) {
			x+=spd;
			moved = true;
			dir = 1;
		}else if(left && Mundo.isFree(x-spd, y)) {
			x-=spd;
			moved = true;
			dir = -1;
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
		
		if(shoot) {
			shoot =false;
			bullets.add(new Bullets(x,y, dir));
			
		}
		
		
		//update bullets shot
		for(int i = 0; i < bullets.size(); i++) {
			bullets.get(i).tick();
		}
		
	}
	
	public void render(Graphics g) {
		g.drawImage(SprintSheet.player_front[curAnimation], x,y, 32, 32, null );
		
		for(int i = 0; i < bullets.size(); i++) {
			bullets.get(i).render(g);
		}
	}
}
