package com.game;

import java.awt.Color;
import java.awt.Graphics2D;

public class Node {
    Color color;
    double x;
    double y;

    public Node() {
	x = 0d;
	y = 0d;
	color = new Color(255, 255, 255);
    }

    public void update(KeyActions ka) {}

    public void draw(Graphics2D g) {}
}
