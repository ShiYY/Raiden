package com.shiyang.raiden.view;

import com.shiyang.raiden.model.BackGround;
import com.shiyang.raiden.model.Game;
import com.shiyang.raiden.model.Hero;

import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel {

//    private Game game;

//    public GamePanel(Game game) {
//        this.game = game;
//    }

    //    private Hero hero;
//    private BackGround bg = new BackGround();

//    public GamePanel(Hero hero) {
//        this.hero = hero;
//    }

    /**
     * left and top 都是战斗机的属性,不应该放在GamePanel里面
     * 应该单独抽取一个Hero类, 这里存放一个Hero引用
     */
    //    private int left = (GameMain.VIEW_WIDTH - 150) / 2;
//    private int top = GameMain.VIEW_HEIGHT - 50;
//
//    public int getLeft() {
//        return left;
//    }
//
//    public void setLeft(int left) {
//        this.left = left;
//    }
//
//    public int getTop() {
//        return top;
//    }
//
//    public void setTop(int top) {
//        this.top = top;
//    }

    /**
     * paint研究的是窗体,我们应该画到内容面板上,不应在窗体上画
     *
     * @param g
     */
    @Override
    public void paint(Graphics g) {
        Game.getInstance().paint(g);
//        bg.paint(g); // 先画谁,谁在最下面
//        hero.paint(g);
        // System.out.println(this.getHeight());// 获取JPanel的高度
        // 这样画就相当于画到了窗体上
//        Color oldColor = g.getColor();// 记录画笔原始颜色
//        g.setColor(Color.yellow);// 画笔赋值新颜色
//        left = (this.getWidth() - 150) / 2;
//        top = (this.getHeight() - 50);// 600是整个窗体的高度(边框和JPanel高度)
//        g.fill3DRect(left, top, 150, 50, true);
//        g.setColor(oldColor);// 重置画笔原始颜色

        // TODO 减少view和model层面的耦合度 如Hero,BackGround的引用 即抽取出Game类,用来游戏的管理和维护
    }
}
