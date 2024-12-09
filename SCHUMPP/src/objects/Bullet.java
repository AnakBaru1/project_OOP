package objects;

import update.Updateable;
import update.Updater;

import render.Renderable;
import render.Renderer;

import core.Window;
import core.FPS;
import core.Sound;

import java.awt.image.BufferedImage;

import java.io.IOException;
import java.io.File;

import javax.imageio.ImageIO;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

public class Bullet implements Updateable, Renderable {
	private static double width = 50;
	private static double height = 70;
	private double x;
	private double y;
	
	private final int layer = 1;
	
	private static BufferedImage bullet;
	
	private static double speed = 500;
	
	public Bullet(double x, double y) throws IOException {
		this.x = x - (getWidth() / 2);
		this.y = y - (getHeight() / 2);
		
		bullet = ImageIO.read(new File("res/Bullet.png"));
		
		Renderer.addRenderableObject(this);
		Updater.addUpdateableObject(this);
	}

	@Override
	public int getLayer() {
		return layer;
	}

	@Override
	public double getX() {
		return x;
	}

	@Override
	public double getY() {
		return y;
	}

	@Override
	public double getWidth() {
		return width;
	}

	@Override
	public double getHeight() {
		return height;
	}

	@Override
	public BufferedImage getBufferedImage() {
		return bullet;
	}

	@Override
	public void update() throws IOException, UnsupportedAudioFileException, LineUnavailableException {
		y -= speed * FPS.getDeltaTime();
		
		if(y <= -getHeight()) {
			Updater.removeUpdateableObject(this);
			Renderer.removeRenderableObject(this);
		}
		
		Updateable collidingObject = isCollding(this, "enemyspaceship");
		if(collidingObject != null) {
			Updater.removeUpdateableObject(this);
			Renderer.removeRenderableObject(this);
			
			Updater.removeUpdateableObject(collidingObject);
			Renderer.removeRenderableObject(collidingObject.getRenderable());
			
			Sound.playSound("res/EnemyDeath.wav");
		}
		
	}

	@Override
	public String getID() {
		return "bullet";
	}

	@Override
	public Renderable getRenderable() {
		return this;
	}

	@Override
	public boolean drawCollisionBox() {
		return true;
	}
	
	
}
