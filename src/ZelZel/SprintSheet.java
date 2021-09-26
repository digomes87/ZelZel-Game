package ZelZel;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;


public class SprintSheet {
	public static BufferedImage spritesheet;
	public static BufferedImage[] player_front;
	public static BufferedImage[] enemy_front;
	public static BufferedImage tileWall;
	
	public SprintSheet() {
		try {
			spritesheet = ImageIO.read(getClass().getResource("/spritesheet.png"));
		}catch(IOException e) {
			e.printStackTrace();
		}
		
		player_front = new BufferedImage[2];
		enemy_front = new BufferedImage[2];
		
		player_front[0] = SprintSheet.getSprinte(0, 11, 16, 16);
		player_front[1] = SprintSheet.getSprinte(16, 11, 16, 16);
		
		enemy_front[0] = SprintSheet.getSprinte(280, 281, 16, 16);
		enemy_front[1] = SprintSheet.getSprinte(339+16,20, 16, 16);
		
		tileWall = SprintSheet.getSprinte(301, 238, 14, 14);
	}
	
	public static BufferedImage getSprinte(int x, int y , int width, int height) {
		return spritesheet.getSubimage(x, y, width, height);
	}

}


