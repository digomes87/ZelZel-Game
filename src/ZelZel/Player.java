package ZelZel;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;


public class Player extends Rectangle{
	
	//var de controle
	public boolean right, up, down, left;
	public int spd = 4;
	
	public Player(int x, int y) {
		super(x, y, 32, 32);
	}

	//TO DO corrigir a orientacao dos movimentos
	public void tick() {
		if(right && Mundo.isFree(x+spd, y)) {
			x+=spd;
		}else if(left && Mundo.isFree(x-spd, y)) {
			x-=spd;
		}
		
		if(up && Mundo.isFree(x, y-spd)) {
			y-=spd;
		}else if(down && Mundo.isFree(x, y+spd)) {
			y+=spd;
		}
		
	}
	
	public void render(Graphics g) {
		g.drawImage(SprintSheet.player_front, x,y, 32, 32, null );
	}
}
