// compile command for emacs: cd C:/Users/e/code/j17/ballines && gradle build
package com.game;

import javax.swing.JFrame;

class Main {
    public static void main(String[] args) {
	JFrame window = new JFrame();
	window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	window.setResizable(false);
	window.setTitle("balls and lines");

	GamePanel gamePanel = new GamePanel();
	window.add(gamePanel);

	window.pack();

	window.setLocationRelativeTo(null);
	window.setVisible(true);
    }
}
