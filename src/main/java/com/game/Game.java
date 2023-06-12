package com.game;

import java.awt.Color;
import java.awt.Graphics2D;

public class Game extends Node {
    static final int width = 640;
    static final int height = 480;
    static final int frameTime = 16;

    private Cursor c;
    private Ball b;

    public Game() {
	super();

	c = new Cursor((double)width / 2d, (double)height / 2d);
	b = new Ball();
    }

    public void update(KeyActions ka) {
	c.update(ka);
	b.update(ka);
    }

    public void draw(Graphics2D g) {
	c.draw(g);
	b.draw(g);
    }
}
