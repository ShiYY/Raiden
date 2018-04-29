package com.shiyang.raiden.model;

import java.awt.*;
import java.awt.event.KeyEvent;

public class Game {
    private BackGround bg;

    private Hero hero;

    private static final Game game = new Game();

    public static Game getInstance() {
        return game;
    }

    private Game() {
        this.bg = new BackGround();
        this.hero = new Hero();
    }

    public void paint(Graphics g) {
        bg.paint(g);
        hero.paint(g);
    }

    public void notifyHeroKeyPressed(int keyCode) {
        switch (keyCode) {
            case KeyEvent.VK_UP:
                // gp.setTop(gp.getTop() - 10);
                hero.forward();
                break;
            case KeyEvent.VK_DOWN:
                hero.back();
                // gp.setTop(gp.getTop() + 10);
                break;
            case KeyEvent.VK_LEFT:
                hero.left();
                // gp.setLeft(gp.getLeft() - 10);
                break;
            case KeyEvent.VK_RIGHT:
                hero.right();
                // gp.setLeft(gp.getLeft() + 10);
                break;
        }
    }
}
