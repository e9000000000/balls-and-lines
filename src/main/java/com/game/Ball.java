package com.game;

import java.awt.Color;
import java.awt.Graphics2D;

public class Ball extends Node {
    int r;
    boolean isAlive;
    double g;
    double air;
    double dx;
    double dy;
    
    public Ball() {
	super();
	r = 30;
	x = 100d;
	y = 100d;
	g = 0.1;
	air = 0.995;
	dx = 3d;
	dy = 0d;
	isAlive = true;
	
    }

    public void update(KeyActions ka) {
	if (!isAlive) {
	    return;
	}

	dy += g;

	dy *= air;
	dx *= air;
	
	x += dx;
	y += dy;

	if (x > 1000 || y > 1000 || x < -1000 || y < -1000) {
	    isAlive = false;
	}
    }

    public void draw(Graphics2D g) {
	g.setColor(color);
	g.fillOval((int)x - r, (int)y - r, r*2, r*2);
    }
}
