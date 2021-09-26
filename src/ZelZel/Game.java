package ZelZel;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferStrategy;
import java.util.List;
import java.util.ArrayList;

import javax.swing.JFrame;

public class Game extends Canvas implements Runnable, KeyListener {
	
	public static int WIDTH = 580, HEIGHT = 580;
	public static int SCALE = 3;
	public Player player;
	public Mundo mundo;
	public List<Enemy> enemys = new ArrayList<Enemy>();
	
	

	public Game() {
		this.addKeyListener(this);
		this.setPreferredSize(new Dimension(WIDTH, HEIGHT));
		
		new SprintSheet();
		player = new Player(32,32);
		enemys.add(new Enemy(32,32));
		mundo = new Mundo();
	}
	
	//metodo que chama outros metodos
	public void tick() {
		player.tick();
		for(int i=0; i < enemys.size(); i++) {
			enemys.get(i).tick();
		}
		
	}
	
	public void render() {
		BufferStrategy bs =  this.getBufferStrategy();
		if(bs == null) {
			//otimizacao grafica
			this.createBufferStrategy(3);
			return;
		}
		Graphics g = bs.getDrawGraphics();
		
		g.setColor(new Color(0,135,13));
		g.fillRect(0, 0, WIDTH* SCALE, HEIGHT * SCALE);
		player.render(g);
		
		//render enemy
		for(int i=0; i < enemys.size(); i++) {
			enemys.get(i).render(g);
		}
		
		
		mundo.render(g);
		bs.show();
	}

	public static void main(String[] args) {
		Game game = new Game();
		JFrame frame  = new JFrame();
		
		frame.add(game);
		frame.setTitle("Zelda");
		frame.pack();
		
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		
		
		new Thread(game).start();
		
	}

	@Override
	public void run() {
		while(true) {
			tick();
			render();
			
			try {
				Thread.sleep(1000/60);
			}catch(InterruptedException e) {
				e.printStackTrace();
			}
			
			System.out.println("Loooping Game !");
		}

	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		//Movimentos do jogo, setas ou letras tipicas de jogo
		if(e.getKeyCode() == KeyEvent.VK_RIGHT || e.getKeyCode() == KeyEvent.VK_D) {
			player.right = true;
			
		}else if(e.getKeyCode() == KeyEvent.VK_LEFT || e.getKeyCode() == KeyEvent.VK_A) {
			player.left = true;
			
		}
		
		//key for get bullet shoot
		if(e.getKeyCode() == KeyEvent.VK_Z) {
			player.shoot = true;
		}
		
		if(e.getKeyCode() == KeyEvent.VK_UP || e.getKeyCode() == KeyEvent.VK_W) {
			player.up = true;
		}else if(e.getKeyCode() == KeyEvent.VK_DOWN || e.getKeyCode() == KeyEvent.VK_S) {
			player.down = true;
		}
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		if(e.getKeyCode() == KeyEvent.VK_RIGHT || e.getKeyCode() == KeyEvent.VK_D) {
			player.right = false;
		}else if(e.getKeyCode() == KeyEvent.VK_LEFT || e.getKeyCode() == KeyEvent.VK_A) {
			player.left = false;
		}
		
		if(e.getKeyCode() == KeyEvent.VK_UP || e.getKeyCode() == KeyEvent.VK_W) {
			player.up = false;
		}else if(e.getKeyCode() == KeyEvent.VK_DOWN || e.getKeyCode() == KeyEvent.VK_S) {
			player.down = false;
		}
		
		
	}

}
