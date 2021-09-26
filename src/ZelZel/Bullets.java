package ZelZel;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Bullets extends Rectangle{
	public int direction = 1;
	public int speed = 8;
	
	public  int frames = 0;
	
	public Bullets(int x, int y, int direction) {
		super(x+16,y+16,10,10); // the x+16 put the bullet in center of player
		this.direction = direction;
	}
	
	
	//update position bullets
	public void tick() {
		x+= speed * direction;
		frames++;
		
		// array list is static now, so if this you can remove bullets that pass limite for not consume more memory
		// this make the game more perfomatic
		if(frames == 60) {
			Player.bullets.remove(this);
			return;
		}
	}
	
	//render
	public void render(Graphics g) {
		g.setColor(Color.blue);
		g.fillOval(x, y, width, height); // paramiter coming from heranc in Rectangle
	}
}
