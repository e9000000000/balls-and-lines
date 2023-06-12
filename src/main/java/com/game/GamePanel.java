package com.game;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import javax.swing.JPanel;

public class GamePanel extends JPanel implements Runnable {
    private Game game;
    private Thread mainThread;
    private KeyActions keyActions;

    public GamePanel() {
	game = new Game();
	keyActions = new KeyActions();
	
	this.setPreferredSize(new Dimension(Game.width, Game.height));
	this.setBackground(new Color(12, 15, 200));
	this.setDoubleBuffered(true);
	this.addKeyListener(keyActions);
	this.setFocusable(true);

	startMainThread();
    }

    public void startMainThread() {
	mainThread = new Thread(this);
	mainThread.start();
    }

    public void paintComponent(Graphics g) {
	super.paintComponent(g);

	Graphics2D g2d = (Graphics2D)g;
	g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                          RenderingHints.VALUE_ANTIALIAS_ON);
	game.draw(g2d);
	g2d.dispose();
	
    }

    @Override
    public void run() {
	while (true) {
	    long startTime = System.currentTimeMillis();
	    game.update(keyActions);
	    repaint();
	    long endTime = System.currentTimeMillis();
	    if (endTime - startTime >= Game.frameTime) {
		continue;
	    }

	    long sleepTime = Game.frameTime - (endTime - startTime);
	    try {
		Thread.sleep(sleepTime);
	    } catch (Exception e) {
		break;
	    }
	}
    }

}
