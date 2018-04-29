package com.shiyang.raiden.model;

import com.shiyang.raiden.view.GameMain;

import java.awt.*;

public class Hero {

    private int x;
    private int y;

    private int width;
    private int height;

    private int speed;

    public Hero() {
        this.width = 150;
        this.height = 50;
        this.x = (GameMain.VIEW_WIDTH - this.width) / 2;
        this.y = GameMain.VIEW_HEIGHT - this.height;
        this.speed = 10;
    }

    public void forward() {
        y -= speed;
    }

    public void back() {
        y += speed;
    }

    public void left() {
        x -= speed;
    }

    public void right() {
        x += speed;
    }

    public void paint(Graphics g) {
        Color oldColor = g.getColor();
        g.setColor(Color.YELLOW);
        g.fill3DRect(x, y, width, height, true);
        g.setColor(oldColor);
    }
}
