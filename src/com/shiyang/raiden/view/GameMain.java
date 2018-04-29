package com.shiyang.raiden.view;

import com.shiyang.raiden.model.BackGround;
import com.shiyang.raiden.model.Game;
import com.shiyang.raiden.model.Hero;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class GameMain extends JFrame {
    private static final long serialVersionUID = 1L;
    private JPanel jContentPane = null;
    public static final int VIEW_WIDTH = 800;
    public static final int VIEW_HEIGHT = 600;

//    private Hero hero = new Hero();
//    private Game game = new Game();

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                GameMain thisClass = new GameMain();
                thisClass.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                center(thisClass);// 屏幕居中显示
                thisClass.setVisible(true);
            }
        });
    }

    private static void center(JFrame frame) {
        double width = Toolkit.getDefaultToolkit().getScreenSize().getWidth();
        double height = Toolkit.getDefaultToolkit().getScreenSize().getHeight();
        frame.setLocation((int) (width - frame.getWidth()) / 2, (int) (height - frame.getHeight()) / 2);
    }

    public GameMain() {
        initialize();
    }

    private void initialize() {
        this.setContentPane(getJContentPane());
        this.setTitle("Raiden");
        this.setBounds(new Rectangle(0, 0, VIEW_WIDTH, VIEW_HEIGHT));
        // 键盘按下事件监听
        this.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                // System.out.println(e.getKeyCode()); // 获得按下键的编号
                // GamePanel gp = (GamePanel) GameMain.this.jContentPane;
                Game.getInstance().notifyHeroKeyPressed(e.getKeyCode());
                /** 移到Game中
                switch (e.getKeyCode()) {
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
                } */
                // repaint() -> EDT -> paint()
                // repaint();// 通知画板重新绘制 通知EDT线程调用paint()方法
            }
        });

        // 重画线程
        ScheduledExecutorService ses = Executors.newScheduledThreadPool(1);
        ses.scheduleAtFixedRate(new Runnable() {
            @Override
            public void run() {
                repaint();
            }
        }, 0, 50, TimeUnit.MILLISECONDS);
    }

    private JPanel getJContentPane() {
        if (jContentPane == null) {
            jContentPane = new GamePanel();
            jContentPane.setLayout(null);
        }
        return jContentPane;
    }
}
