package com.tcg.missit.entities;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

public abstract class Entity {

	protected Rectangle bounds;
	protected Vector2 vel;
	protected Color c;
	
	public Entity() {
		bounds = new Rectangle();
		vel = new Vector2();
		c = new Color();
	}
	
	public void draw(ShapeRenderer sr) {
		sr.setColor(c);
		sr.rect(bounds.x, bounds.y, bounds.width, bounds.height);
	}
	
	public boolean collidingWith(Entity e) {
		return bounds.overlaps(e.getBounds());
	}
	
	public Rectangle getBounds() {
		return bounds;
	}
	public void setBounds(Rectangle bounds) {
		this.bounds = bounds;
	}
	
}
