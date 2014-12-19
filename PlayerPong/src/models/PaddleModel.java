/**
 * 
 */
package models;

import java.awt.Color;
import java.awt.Rectangle;
import java.awt.Shape;
import java.awt.geom.Rectangle2D;

/**
 * @author Niels
 *
 */
public class PaddleModel implements Drawable {

	private static final int WIDTH = 100;
	private static final int HEIGHT = 20;
	private static final int SPEED = 10;
	private double x;
	private double y;
	
	private Rectangle spielfeld;
	private Rectangle2D rect;
	
	public PaddleModel(Rectangle spielfeld) {
		this.spielfeld=spielfeld;
		this.x=this.spielfeld.getCenterX() - PaddleModel.WIDTH/2;
		this.y=this.spielfeld.getHeight() - (3* PaddleModel.HEIGHT);
		this.rect = new Rectangle2D.Double(this.x, this.y, PaddleModel.WIDTH, PaddleModel.HEIGHT);
	}
	
	public void moveLeft(){
		if( 0 <= this.x ){
			this.x -= PaddleModel.SPEED;
		}
		this.rect.setFrame(this.x, this.y, PaddleModel.WIDTH, PaddleModel.HEIGHT);
	}
	
	public void moveRight(){
		if(this.x < this.spielfeld.getWidth() - PaddleModel.WIDTH){
			this.x += PaddleModel.SPEED;
		}
		this.rect.setFrame(this.x, this.y, PaddleModel.WIDTH, PaddleModel.HEIGHT);
	}
	
	public Rectangle2D getCollisionFrame(){
		return this.rect;
	}
	/* (non-Javadoc)
	 * @see models.Drawable#getShape()
	 */
	@Override
	public Shape getShape() {
		// TODO Auto-generated method stub
		return this.rect;
	}

	/* (non-Javadoc)
	 * @see models.Drawable#getColor()
	 */
	@Override
	public Color getColor() {
		// TODO Auto-generated method stub
		return Color.GREEN;
	}

}
