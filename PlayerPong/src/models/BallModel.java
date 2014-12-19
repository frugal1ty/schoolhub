package models;

import gui.PaddleGame;

import java.awt.Color;
import java.awt.Rectangle;
import java.awt.Shape;
import java.awt.geom.Ellipse2D;

public class BallModel implements Drawable {

	private final Rectangle spielfeld;
	private final PaddleModel paddle;
	private final PaddleGame game;
	private Ellipse2D ball;
	private static final int SPEED = 2;
	private static final int RADIUS = 25;
	private double x;
	private double y;
	private double dx = BallModel.SPEED;
	private double dy = -BallModel.SPEED;

	public BallModel(Rectangle spielfeld, PaddleModel paddle, PaddleGame game){
		this.spielfeld=spielfeld;
		this.paddle=paddle;
		this.game=game;
		this.x=this.spielfeld.getCenterX() - BallModel.RADIUS/2;
		this.y=this.spielfeld.getCenterY() - BallModel.RADIUS/2;
		this.ball = new Ellipse2D.Double(this.x, this.y, BallModel.RADIUS, BallModel.RADIUS);
	}
	
	public void move(){
		this.x += this.dx;
		//Kollision: Seitenwände
		if(!( 0 <= this.x ) || !(this.x < this.spielfeld.getWidth() - BallModel.RADIUS)){
			this.dx = -this.dx;
		}
		
		this.y += this.dy;
		
		//Kollision: Obere Wand
		if(!( 0 <= this.y)){
			this.dy = BallModel.SPEED;
		}
		
		//Kollision: Schläger
		if(this.ball.intersects(this.paddle.getCollisionFrame())){
			this.dy = -BallModel.SPEED;
		}
		//Kollision: untere Wand -> Spiel zu Ende
		if(this.y > this.spielfeld.getHeight()){
			game.stopGame();
		}
		
		//Der Ball wird mit veränderten X und Y Koordinaten neu erzeugt
		this.ball.setFrame(this.x, this.y, BallModel.RADIUS, BallModel.RADIUS);
	}
	@Override
	public Shape getShape() {
		this.move();
		return this.ball;
	}

	@Override
	public Color getColor() {
		return Color.RED;
	}
}