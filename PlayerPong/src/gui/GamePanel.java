/**
 * 
 */
package gui;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.List;

import javax.swing.JPanel;

import models.Drawable;

/**
 * @author Niels
 *
 */
public class GamePanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private List<Drawable> drawables;
	
	public GamePanel(List<Drawable> li){
		this.drawables=li;
	}

	@Override
	protected void paintComponent(Graphics arg0) {
		super.paintComponent(arg0);
		this.doPainting((Graphics2D) arg0);
	}

	private void doPainting(Graphics2D g2d){
		this.setForeground(Color.BLACK);
		g2d.fillRect(0, 0, this.getWidth(), this.getHeight());
		for(Drawable d: this.drawables){
			g2d.setColor(d.getColor());
			g2d.fill(d.getShape());
		}
	}	
}