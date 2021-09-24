package ZelZel;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Blocos extends  Rectangle{
	
	public Blocos(int x, int y) {
		super(x,y, 32, 32);
	}
	
	public void render(Graphics g) {
		g.drawImage(SprintSheet.tileWall, x, y, 32,32, null);
	}
}
