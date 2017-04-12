package com.tcg.missit;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.controllers.Controllers;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.math.Vector2;
import com.tcg.missit.managers.*;

public class Game extends ApplicationAdapter {
	
	private GameStateManager gsm;
	
	public static Content res;
	
	public static Vector2 SIZE, CENTER;
	
	public static int SCORE, HIGH;
	
	private Save s;
	
	private int fps, frames;
	private float time;
	
	@Override
	public void create () {
		
		int width = Gdx.graphics.getWidth();
		int height = Gdx.graphics.getHeight();
		SIZE = new Vector2();
		CENTER = new Vector2();
		
		SIZE.set(width, height);
		CENTER.set(width * .5f, height * .5f);
		
		res = new Content();
		res.loadBitmapFont("font", "atari full.ttf", "main", 24, Color.BLACK);

		res.loadSound("sound", "bounce.wav", "bounce");
		res.loadSound("sound", "spawn.wav", "spawn");
		
		time = 0;
		fps = 0;
		frames = 0;
		
		SCORE = 0;
		
		try {
			FileInputStream fileIn = new FileInputStream("save.dat");
			ObjectInputStream in = new ObjectInputStream(fileIn);
			s = (Save) in.readObject();
			in.close();
			fileIn.close();
		} catch(Exception e) { 
			e.printStackTrace();
			s = new Save();
			s.setHighScore(0);
		}
		
		HIGH = s.getHighScore();
		
		gsm = new GameStateManager();
		
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
		
		gsm.handleInput();
		gsm.update(dt);
		gsm.draw();
		
		if(MyInput.isPressed(MyInput.ESCAPE)) {
			Gdx.app.exit();
		}
		
		MyInput.update();
	}

	public static String getScore(int score) {
		if(score < 10) {
			return "00000" + score;
		} else if(score < 100) {
			return "0000" + score;
		} else if(score < 1000) {
			return "000" + score;
		} else if(score < 10000) {
			return "00" + score;
		} else if(score < 100000) {
			return "0" + score;
		} else {
			return "" + score;
		}
	}

	@Override
	public void resize(int width, int height) {
		SIZE.set(width, height);
		CENTER.set(width * .5f, height * .5f);
		gsm.resize(Game.SIZE);
	}

	@Override
	public void dispose() {
		gsm.dispose();
		res.removeAll();
		s.setHighScore(HIGH);
		try {
			FileOutputStream fileOut = new FileOutputStream("save.dat");
			ObjectOutputStream out = new ObjectOutputStream(fileOut);
			out.writeObject(s);
			out.close();
			fileOut.close();
		} catch(Exception e) { e.printStackTrace(); }
	}
}
