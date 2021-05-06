package org.gudao;

import java.awt.*;

/**
 * @Auther: Gudao
 * @Date: 2021/5/3
 * @Description:
 */
public class Bullet {
    private static final int SPEED = 10;
    private int x,y;
    private Dir dir;
    private static int  WIDTH = 5,HEIGHT = 5;
    private boolean live = true;
    private TankFrame tankFrame;

    public Bullet(int x, int y, Dir dir, TankFrame tankFrame) {
        this.x = x;
        this.y = y;
        this.dir = dir;
        this.tankFrame = tankFrame;
    }

    public void paint(Graphics g) {
        // 移除不在边框中的bullet
        if(!live){
            tankFrame.bulletList.remove(this);
        }

        Color color = g.getColor();
        // 设置子弹颜色
        g.setColor(Color.red);
        // 设置子弹大小与位置
        g.fillOval(x,y,WIDTH,HEIGHT);
        g.setColor(color);
        move();
    }

    /**
     * 子弹移动方法
     */
    private void move() {
        switch (dir) {
            case LEFT:
                x -= SPEED;
                break;
            case RIGHT:
                x += SPEED;
                break;
            case UP:
                y -= SPEED;
                break;
            case DOWN:
                y += SPEED;
                break;
            default:
                break;
        }
        if(x<0 || y<0 || x>TankFrame.GAME_WITH || y>TankFrame.GAME_HEIGHT){
            live = false;
        }
    }
}
