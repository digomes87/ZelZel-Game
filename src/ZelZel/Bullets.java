package ZelZel;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Bullets extends Rectangle{
	public int direction = 1;
	public int speed = 8;
	
	public Bullets(int x, int y, int direction) {
		super(x,y,20,20);
		this.direction = direction;
	}
	
	
	//update position bullets
	public void tick() {
		x+= speed * direction;
	}
	
	//render
	public void render(Graphics g) {
		g.setColor(Color.red);
		g.fillRect(x, y, width, height); // paramiter coming from heranc in Rectangle
	}
}
