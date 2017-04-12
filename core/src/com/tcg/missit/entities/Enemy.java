package com.tcg.missit.entities;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.math.MathUtils;
import com.tcg.missit.Game;

public class Enemy extends Entity {

	private float radians;
	private float speed;
	
	private final float maxSpeed = 10;
	
	public Enemy() {
		super();
		bounds.width = 20;
		bounds.height = 20;
		bounds.y = 20;
		bounds.x = (MathUtils.random(25, Game.SIZE.x - 25));
		speed = 5;
		float degrees;
		
		do {
			degrees = MathUtils.random(20, 160);
		} while(degrees > 85 && degrees < 95);
		
		radians = degrees * MathUtils.degreesToRadians;
		vel.x = MathUtils.cos(radians) * speed;
		vel.y = MathUtils.sin(radians) * speed;
		switch((int)MathUtils.random(1, 5)) {
		case 1: c = Color.RED; break;
		case 2: c = Color.BLUE; break;
		case 3: c = Color.YELLOW; break;
		case 4: c = Color.GREEN; break;
		case 5: c = Color.PURPLE; break;
		}
	}
	
	public void update() {
		
		bounds.x += vel.x;
		bounds.y += vel.y;

		if(bounds.x < 0) {
			bounds.x = 0;
			bounceX();
		}
		if(bounds.x > Game.SIZE.x - bounds.width) {
			bounds.x = Game.SIZE.x - bounds.width;
			bounceX();
		}
		if(bounds.y < 0) {
			bounds.y = 0;
			bounceY();
		}
		if(bounds.y > Game.SIZE.y - bounds.height) {
			bounds.y = Game.SIZE.y - bounds.height;
			bounceY();
		}
	}
	
	private void bounceX() {
		Game.res.getSound("bounce").play();
		vel.x *= -1;
	}
	
	private void bounceY() {
		Game.res.getSound("bounce").play();
		vel.y *= -1;
	}
	
	public void incrementSpeed() {
		
		if(speed < maxSpeed) {
			speed += .25f;
			
			if(vel.x > 0) {
				vel.x += .25f;
			} else {
				vel.x -= .25f;
			}
			
			if(vel.y > 0) {
				vel.y += .25f;
			} else {
				vel.y -= .25f;
			}
		}
		
	}
	
}
