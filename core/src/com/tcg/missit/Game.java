package com.tcg.missit;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.controllers.Controllers;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.math.Vector2;
import com.tcg.missit.managers.*;

public class Game extends ApplicationAdapter {
	
	private GameStateManager gsm;
	
	public static Content res;
	
	public static Vector2 SIZE, CENTER;
	
	public static int SCORE, HIGH;
	
	private int fps, frames;
	private float time;
	
	@Override
	public void create () {
		
		time = 0;
		fps = 0;
		frames = 0;
		
		Gdx.input.setInputProcessor(new MyInputProcessor());
		Controllers.addListener(new MyControllerProcessor());
	}

	@Override
	public void render () {
		Gdx.gl.glClearColor((200f / 255f), (200f / 255f), (200f / 255f), 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		
		float dt = Gdx.graphics.getDeltaTime();
		time += dt;
		frames++;
		if(time > 1) {
			fps = frames;
			frames = 0;
			time = 0;
		}
		Gdx.graphics.setTitle("Miss It! | " + fps + " fps");
		
		if(MyInput.isPressed(MyInput.ESCAPE)) {
			Gdx.app.exit();
		}
		
		MyInput.update();
	}
}
