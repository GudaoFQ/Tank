package org.gudao;

import java.awt.*;

/**
 * @Auther: Gudao
 * @Date: 2021/4/28
 * @Description:
 */
public class Tank {
    private int x,y;
    private Dir dir = Dir.DOWN;
    private static final int SPEED = 5;
    private boolean moving = false;
    private TankFrame tankFrame;

    public Tank(int x, int y, Dir dir, TankFrame tankFrame) {
        super();
        this.x = x;
        this.y = y;
        this.dir = dir;
        this.tankFrame = tankFrame;
    }

    public void paint(Graphics g) {
        // 老颜色保存
        Color color = g.getColor();
        g.setColor(Color.cyan);
        // 画坦克
        g.fillRect(x,y,50,50);
        // 重新设置老的颜色
        g.setColor(color);
        move();
    }

    /**
     * 坦克移动方法
     */
    private void move() {
        if(!moving){
            return;
        }
        switch (dir){
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
    }


    /**
     * 坦克方向设置
     *
     * @param dir dir
     */
    public void setDir(Dir dir) {
        this.dir = dir;
    }

    /**
     * 坦克是移动设置
     *
     * @param moving 移动
     */
    public void setMoving(boolean moving) {
        this.moving = moving;
    }

    public void fire() {
        tankFrame.bullet = new Bullet(this.x,this.y,this.dir);
    }
}
