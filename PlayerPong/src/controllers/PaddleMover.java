package controllers;

import java.awt.Toolkit;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import models.PaddleModel;

public class PaddleMover extends KeyAdapter {

	private final PaddleModel model;
	
	public PaddleMover(PaddleModel model) {
		this.model=model;
	}
	
	public void keyPressed(KeyEvent k){
		super.keyPressed(k);
		
		if(k.getKeyCode() == KeyEvent.VK_LEFT){
			this.model.moveLeft();
			//Toolkit.getDefaultToolkit().beep();
		}
		if(k.getKeyCode() == KeyEvent.VK_RIGHT){
			this.model.moveRight();
			//Toolkit.getDefaultToolkit().beep();
		}
	}
}