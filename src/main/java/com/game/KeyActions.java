package com.game;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import java.util.HashMap;

public class KeyActions implements KeyListener {
    private HashMap<Integer, String> keyToAction;
    public HashMap<String, Boolean> actions;
    public boolean up, down, left, right;

    public KeyActions() {
	super();

	keyToAction = new HashMap<Integer, String>();
	keyToAction.put(KeyEvent.VK_LEFT, "left");
	keyToAction.put(KeyEvent.VK_RIGHT, "right");
	keyToAction.put(KeyEvent.VK_UP, "up");
	keyToAction.put(KeyEvent.VK_DOWN, "down");

	actions = new HashMap<String, Boolean>();
	for (int code : keyToAction.keySet()) {
	    actions.put(keyToAction.get(code), false);
	}
	
    }

    public boolean isPressed(String key) {
	return actions.get(key);
    }

    private void updateIsPressed(KeyEvent e, boolean isPressed) {
	int code = e.getKeyCode();
	if (keyToAction.containsKey(code)) {
	    actions.put(keyToAction.get(code), isPressed);
	}
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
	updateIsPressed(e, true);
    }

    @Override
    public void keyReleased(KeyEvent e) {
	updateIsPressed(e, false);
    }
}
