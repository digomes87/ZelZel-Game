package ZelZel;
import java.awt.Graphics;
import java.util.List;
import java.awt.Rectangle;
import java.util.ArrayList;



public class Enemy extends Rectangle{
	
	//var de controle
	public int right=1, up=0, down=0, left=0;
	public int spd = 4;
	
	public int curAnimation = 0;
	public int curFrames = 0, targetFrames = 15;
	
	//system for bullets
	public static List<Bullets> bullets = new ArrayList<Bullets>();
	
	public boolean shoot = false;
	
	//the last direction of player
	public int dir = 1;
	
	public Enemy(int x, int y) {
		super(x, y, 32, 32);
	}

	//TO DO corrigir a orientacao dos movimentos
	public void tick() {
		boolean moved = false;
		
		if(right == 1) {
			x++;
		}
		
		if(moved) {
			// This code bellow is for change sprintSheet and make the moviment
			curFrames++;
			if(curFrames == targetFrames) {
				curFrames = 0;
				curAnimation++;
				if(curAnimation == SprintSheet.enemy_front.length) {
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
		g.drawImage(SprintSheet.enemy_front[curAnimation], x,y, 32, 32, null );
		
		for(int i = 0; i < bullets.size(); i++) {
			bullets.get(i).render(g);
		}
	}
}
