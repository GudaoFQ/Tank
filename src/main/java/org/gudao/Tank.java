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
    public static int  WIDTH = ResourceMgr.tankL.getWidth(),HEIGHT = ResourceMgr.tankL.getHeight();
    private boolean moving = false;
    private TankFrame tankFrame;
    private boolean living = true;

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public Tank(int x, int y, Dir dir, TankFrame tankFrame) {
        super();
        this.x = x;
        this.y = y;
        this.dir = dir;
        this.tankFrame = tankFrame;
    }

    public void paint(Graphics g) {
        // 判断坦克是否活着
        if (!living){
            tankFrame.tankList.remove(this);
        }

        // 坦克图片引入
        switch (dir){
            case LEFT:
                g.drawImage(ResourceMgr.tankL, x, y, null);
                break;
            case RIGHT:
                g.drawImage(ResourceMgr.tankR,x,y,null);
                break;
            case UP:
                g.drawImage(ResourceMgr.tankU,x,y,null);
                break;
            case DOWN:
                g.drawImage(ResourceMgr.tankD,x,y,null);
                break;
        }
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
        int bx = this.x + Tank.WIDTH/2 - Bullet.WIDTH/2;
        int by = this.y + Tank.HEIGHT/2 - Bullet.HEIGHT/2;
        tankFrame.bulletList.add(new Bullet(bx,by,this.dir,tankFrame));
    }

    public void die() {
        this.living = false;
    }
}
