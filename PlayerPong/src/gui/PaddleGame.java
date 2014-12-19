package gui;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.swing.JFrame;

import models.BallModel;
import models.Drawable;
import models.PaddleModel;
import controllers.PaddleMover;

public class PaddleGame {

	private boolean running = true;
	private final JFrame frame;
	
	public PaddleGame() {
		this.frame = new JFrame("Pong");
		
		this.frame.setSize(640,480);
		this.frame.setResizable(false);
		
		List<Drawable> drawables = new ArrayList<>();
		
		PaddleModel pm = new PaddleModel(this.frame.getBounds());
		
		drawables.add(new BallModel(this.frame.getBounds(), pm, this));
		drawables.add(pm);
		this.frame.add(new GamePanel(drawables));
		this.frame.addKeyListener(new PaddleMover(pm));
		
		this.frame.setLocationRelativeTo(null);
		this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
	
	public void runGame(){
		//Das setVisible wurde aus dem Konstruktor hierher bewegt, damit das Fenster erst zu sehen wenn es mit dem Spiel losgeht.
		this.frame.setVisible(true);
		
		while(running){
			this.frame.repaint();
			
			try {
				TimeUnit.MILLISECONDS.sleep(15);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
		}
	}
	
	public void stopGame(){
		this.running=false;
		this.frame.setTitle("Game Over!");
	}
}