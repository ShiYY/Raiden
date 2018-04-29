package com.shiyang.raiden.model;

import com.shiyang.raiden.view.GameMain;
import javafx.scene.layout.Background;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.IOException;

public class BackGround {

    private Image img;
    private int y;


    public BackGround() {
        try {
            // BackGround.class.getResourceAsStream(name) 定位到类所在的路径下
            img = ImageIO.read(BackGround.class.getClassLoader().getResourceAsStream("images/bg.gif"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void paint(Graphics g) {
        // BackGround.class.getClassLoader() bin目录
        if (y > GameMain.VIEW_HEIGHT) {
            y = 0;
        }
        y++;
        g.drawImage(img, 0, y - GameMain.VIEW_HEIGHT, GameMain.VIEW_WIDTH, GameMain.VIEW_HEIGHT, null);
        g.drawImage(img, 0, y, GameMain.VIEW_WIDTH, GameMain.VIEW_HEIGHT, null);
    }
}
