package com.tcg.missit.gamestates;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Vector2;
import com.tcg.missit.Game;
import com.tcg.missit.MyCamera;
import com.tcg.missit.managers.GameStateManager;

public class TitleState extends GameState {

	private MyCamera cam;
	
	String miss, it, press;
	
	public TitleState(GameStateManager gsm) {
		super(gsm);
	}

	@Override
	protected void init() {
		
		cam = new MyCamera(Game.SIZE, true);
		
	}

	@Override
	public void handleInput() {

	}

	@Override
	public void update(float dt) {

	}

	@Override
	public void draw(SpriteBatch sb, ShapeRenderer sr) {

	}

	@Override
	public void resize(Vector2 size) {
		cam.resize(size, true);
	}

	@Override
	public void dispose() {

	}

}
