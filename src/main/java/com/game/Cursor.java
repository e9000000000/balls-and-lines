package com.game;

import java.awt.Color;
import java.awt.Graphics2D;

public class Cursor extends Node {
    int r;
    double speed;
    public Cursor(double _x, double _y) {
	super();
	x = _x;
	y = _y;
	r = 3;
	speed = 3d;
    }

    public void update(KeyActions ka) {
	if (ka.isPressed("left")) {
	    x -= speed;
	}
	if (ka.isPressed("right")) {
	    x += speed;
	}
	if (ka.isPressed("up")) {
	    y -= speed;
	}
	if (ka.isPressed("down")) {
	    y += speed;
	}

    }

    public void draw(Graphics2D g) {
	g.setColor(color);
	g.fillOval((int)x - r, (int)y - r, r*2, r*2);
    }
}
