package com.tcg.missit.managers;

import java.io.Serializable;

public class Save implements Serializable {
	
	private static final long serialVersionUID = -4010024763834878978L;
	
	private int highScore;

	public int getHighScore() {
		return highScore;
	}

	public void setHighScore(int highScore) {
		this.highScore = highScore;
	}
	
}
