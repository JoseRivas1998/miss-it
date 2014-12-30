package com.tcg.missit.entities;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.utils.Array;
import com.tcg.missit.Game;
import com.tcg.missit.managers.MyInput;

public class Player extends Entity {
	
	private boolean shouldEnd;

	public Player() {
		super();
		bounds.x = Game.CENTER.x - 10;
		bounds.y = Game.CENTER.y - 10;
		bounds.width = 20;
		bounds.height = 20;
		c.set(Color.BLACK);
	}
	
	public void handleInput() {
		if(MyInput.isDown(MyInput.RIGHT)) {
			vel.x = 5;
		} else if (MyInput.isDown(MyInput.LEFT)){
			vel.x = -5;
		}else {
			vel.x = 0;
		}
		if(MyInput.isDown(MyInput.UP)) {
			vel.y = 5;
		} else if (MyInput.isDown(MyInput.DOWN)){
			vel.y = -5;
		}else {
			vel.y = 0;
		}
	}
	
	public void update(Array<Enemy> e) {
		
		bounds.x += vel.x;
		bounds.y += vel.y;

		if(bounds.x < 0) {
			bounds.x = 0;
		}
		if(bounds.x > Game.SIZE.x - bounds.width) {
			bounds.x = Game.SIZE.x - bounds.width;
		}
		if(bounds.y < 0) {
			bounds.y = 0;
		}
		if(bounds.y > Game.SIZE.y - bounds.height) {
			bounds.y = Game.SIZE.y - bounds.height;
		}
		
		for(Enemy en : e) {
			if(collidingWith(en)) {
				shouldEnd = true;
				break;
			} else {
				shouldEnd = false;
			}
		}
		
	}

	public boolean isShouldEnd() {
		return shouldEnd;
	}
	
}
