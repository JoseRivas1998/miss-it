package com.tcg.missit.managers;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Vector2;
import com.tcg.missit.Game;
import com.tcg.missit.MyCamera;
import com.tcg.missit.gamestates.*;

public class GameStateManager {

	private SpriteBatch sb;
	private ShapeRenderer sr;
	
	private GameState gamestate;

	public final int TITLE = 1;
	public final int PLAY = 2;
	
	private MyCamera scoreCam;
	
	public GameStateManager() {
		sb = new SpriteBatch();
		sr = new ShapeRenderer();
		scoreCam = new MyCamera(Game.SIZE, true);
		setState(TITLE);
	}
	
	public void setState(int state) {
		if(gamestate != null) gamestate.dispose();
		if(state == TITLE) {
			gamestate = new TitleState(this);
		}
		if(state == PLAY) {
			gamestate = new PlayState(this);
		}
	}
	
	public void handleInput() {
		gamestate.handleInput();
	}
	
	public void update(float dt) {
		gamestate.update(dt);
	}
	
	public void draw() {
		gamestate.draw(sb, sr);
		
		sb.begin();
		sb.setProjectionMatrix(scoreCam.combined);
		Game.res.getFont("main").draw(sb, "Score: " + Game.getScore(Game.SCORE), 
				(Game.CENTER.x) - (Game.res.getWidth("main", "Score: " + Game.getScore(Game.SCORE)) * .5f),
				Game.res.getHeight("main", "Score: " + Game.getScore(Game.SCORE)));
		Game.res.getFont("main").draw(sb, "High Score: " + Game.getScore(Game.HIGH), 
				(Game.CENTER.x) - (Game.res.getWidth("main", "High Score: " + Game.getScore(Game.HIGH)) * .5f), 
				Game.SIZE.y);
		sb.end();
	}
	
	public void resize(Vector2 size) {
		gamestate.resize(size);
		scoreCam.resize(size, true);
	}
	
	public void dispose() {
		gamestate.dispose();
		sb.dispose();
		sr.dispose();
	}
	
}
