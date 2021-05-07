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
    public static int  WIDTH = ResourceMgr.bulletD.getWidth(),HEIGHT = ResourceMgr.bulletD.getHeight();
    private boolean living = true;
    private TankFrame tankFrame;

    public Bullet(int x, int y, Dir dir, TankFrame tankFrame) {
        this.x = x;
        this.y = y;
        this.dir = dir;
        this.tankFrame = tankFrame;
    }

    public void paint(Graphics g) {
        // 移除不在边框中的bullet
        if(!living){
            tankFrame.bulletList.remove(this);
        }

        // 子弹图片引入
        switch (dir){
            case LEFT:
                g.drawImage(ResourceMgr.bulletL, x, y, null);
                break;
            case RIGHT:
                g.drawImage(ResourceMgr.bulletR,x,y,null);
                break;
            case UP:
                g.drawImage(ResourceMgr.bulletU,x,y,null);
                break;
            case DOWN:
                g.drawImage(ResourceMgr.bulletD,x,y,null);
                break;
        }
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
            living = false;
        }
    }

    public void collideWith(Tank tank) {
        Rectangle rectangle1 = new Rectangle(this.x,this.y,WIDTH,HEIGHT);
        Rectangle rectangle2 = new Rectangle(tank.getX(),tank.getY(),Tank.WIDTH,Tank.HEIGHT);
        if (rectangle1.intersects(rectangle2)){
            tank.die();
            this.die();
        }
    }

    private void die() {
        this.living = false;
    }
}
