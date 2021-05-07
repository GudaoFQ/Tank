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
        tankFrame.bulletList.add(new Bullet(this.x,this.y,this.dir,tankFrame));
    }
}
