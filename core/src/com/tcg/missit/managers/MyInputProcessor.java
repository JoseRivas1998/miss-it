package com.tcg.missit.managers;

import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.Input.Keys;

public class MyInputProcessor extends InputAdapter {

	@Override
	public boolean keyDown(int keycode) {
		if(keycode == Keys.UP || keycode == Keys.W) {
			MyInput.setKey(MyInput.UP, true);
		}
		if(keycode == Keys.DOWN || keycode == Keys.S) {
			MyInput.setKey(MyInput.DOWN, true);
		}
		if(keycode == Keys.LEFT || keycode == Keys.A) {
			MyInput.setKey(MyInput.LEFT, true);
		}
		if(keycode == Keys.RIGHT || keycode == Keys.D) {
			MyInput.setKey(MyInput.RIGHT, true);
		}
		if(keycode == Keys.ENTER) {
			MyInput.setKey(MyInput.ENTER, true);
		}
		if(keycode == Keys.ESCAPE) {
			MyInput.setKey(MyInput.ESCAPE, true);
		}
		MyInput.setKey(MyInput.ANY, true);
		return true;
	}

	@Override
	public boolean keyUp(int keycode) {
		if(keycode == Keys.UP || keycode == Keys.W) {
			MyInput.setKey(MyInput.UP, false);
		}
		if(keycode == Keys.DOWN || keycode == Keys.S) {
			MyInput.setKey(MyInput.DOWN, false);
		}
		if(keycode == Keys.LEFT || keycode == Keys.A) {
			MyInput.setKey(MyInput.LEFT, false);
		}
		if(keycode == Keys.RIGHT || keycode == Keys.D) {
			MyInput.setKey(MyInput.RIGHT, false);
		}
		if(keycode == Keys.ENTER) {
			MyInput.setKey(MyInput.ENTER, false);
		}
		if(keycode == Keys.ESCAPE) {
			MyInput.setKey(MyInput.ESCAPE, false);
		}
		MyInput.setKey(MyInput.ANY, false);
		return true;
	}

}
