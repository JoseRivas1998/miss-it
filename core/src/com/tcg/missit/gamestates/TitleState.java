package com.tcg.missit.gamestates;

import com.badlogic.gdx.controllers.Controllers;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Vector2;
import com.tcg.missit.Game;
import com.tcg.missit.MyCamera;
import com.tcg.missit.managers.GameStateManager;
import com.tcg.missit.managers.MyInput;

public class TitleState extends GameState {

	private MyCamera cam;
	
	private String miss, it, press, key;
	
	private float mX, mY, iX, iY, pX, pY, kX, kY;
	
	public TitleState(GameStateManager gsm) {
		super(gsm);
	}

	@Override
	protected void init() {
		
		cam = new MyCamera(Game.SIZE, true);
		
		miss  = "Miss";
		it = "It";
		press = "Press";
		if(Controllers.getControllers().size > 0) {
			key = "Start";
		} else {
			key = "Enter";
		}
		
	}

	@Override
	public void handleInput() {
		if(MyInput.isPressed(MyInput.ENTER)) {
			gsm.setState(gsm.PLAY);
		}
	}

	@Override
	public void update(float dt) {

		mX = Game.CENTER.x - (Game.res.getWidth("main", miss) * .5f);
		mY = (Game.SIZE.y * .6f) + (Game.res.getHeight("main", miss)) + 2;

		iX = Game.CENTER.x - (Game.res.getWidth("main", it) * .5f);
		iY = (Game.SIZE.y * .6f) - 2;

		pX = Game.CENTER.x - (Game.res.getWidth("main", press) * .5f);
		pY = (Game.SIZE.y * .4f) + (Game.res.getHeight("main", press)) + 2;

		kX = Game.CENTER.x - (Game.res.getWidth("main", key) * .5f);
		kY = (Game.SIZE.y * .4f) - 2;
		
	}

	@Override
	public void draw(SpriteBatch sb, ShapeRenderer sr) {

		sb.begin();
		sb.setProjectionMatrix(cam.combined);
		Game.res.getFont("main").draw(sb, miss, mX, mY);
		Game.res.getFont("main").draw(sb, it, iX, iY);
		Game.res.getFont("main").draw(sb, press, pX, pY);
		Game.res.getFont("main").draw(sb, key, kX, kY);
		sb.end();
		
	}

	@Override
	public void resize(Vector2 size) {
		cam.resize(size, true);
	}

	@Override
	public void dispose() {}

}
