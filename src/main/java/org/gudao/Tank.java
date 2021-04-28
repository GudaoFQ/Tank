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
    private static final int SPEED = 10;
    private boolean moving = false;

    public Tank(int x, int y, Dir dir) {
        super();
        this.x = x;
        this.y = y;
        this.dir = dir;
    }

    public void paint(Graphics g) {
        g.fillRect(x,y,50,50);
        move();
    }

    /**
     * 坦克移动方法
     */
    private void move() {
        //
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
}
