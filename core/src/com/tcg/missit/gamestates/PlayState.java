package com.tcg.missit.gamestates;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Array;
import com.tcg.missit.Game;
import com.tcg.missit.MyCamera;
import com.tcg.missit.entities.*;
import com.tcg.missit.managers.GameStateManager;

public class PlayState extends GameState {

	private MyCamera cam;
	
	private Player p;
	
	private Array<Enemy> e;
	
	private float time, eTime, eTimer;
	
	public PlayState(GameStateManager gsm) {
		super(gsm);
	}

	@Override
	protected void init() {
		cam = new MyCamera(Game.SIZE, true);
		
		Game.SCORE = 0;
		
		p = new Player();

		e = new Array<Enemy>();
		
		eTimer = 1;
		eTime = 0;
		time = 0;
		
	}

	@Override
	public void handleInput() {
		p.handleInput();
	}

	@Override
	public void update(float dt) {
		
		eTime += dt;
		time += dt;
		if(eTime >= eTimer) {
			eTimer *= 2;
			eTime = 0;
			if(e.size > 0) {
				Game.res.getSound("spawn").play();
			}
			e.add(new Enemy());
		}
		if(time >= 1) {
			time = 0;
			Game.SCORE++;
			for(Enemy e : e) {
				e.incrementSpeed();
			}
		}
		
		for(Enemy e : e) {
			e.update();
		}
		p.update(e);
		
		if(Game.SCORE > Game.HIGH) {
			Game.HIGH = Game.SCORE;
		}
		
		if(p.isShouldEnd()) {
			gsm.setState(gsm.TITLE);
		}

	}

	@Override
	public void draw(SpriteBatch sb, ShapeRenderer sr) {

		sr.begin(ShapeType.Filled);
		sr.setProjectionMatrix(cam.combined);
		for(Enemy e : e) {
			e.draw(sr);
		}
		p.draw(sr);
		sr.end();

	}

	@Override
	public void resize(Vector2 size) {
		cam.resize(size, true);

	}

	@Override
	public void dispose() {
		// TODO Auto-generated method stub

	}

}
