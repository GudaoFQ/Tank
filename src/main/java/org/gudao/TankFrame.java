package org.gudao;

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.List;

/**
 * @Auther: Gudao
 * @Date: 2021/4/27
 * @Description:
 */
public class TankFrame extends Frame {
    Tank tank = new Tank(200,500,Dir.DOWN,this, Group.GOOD);
    List<Bullet> bulletList = new ArrayList<>();
    List<Tank> tankList = new ArrayList<>();
    static final int GAME_WITH = 800, GAME_HEIGHT = 600;

    public TankFrame() throws HeadlessException {
        // 设置窗口大小
        setSize(GAME_WITH,GAME_HEIGHT);
        // 设置是否能再次改变大小
        setResizable(false);
        // 设置标题
        setTitle("Gudao");
        // 设置可见
        setVisible(true);

        // 设置窗口可关闭：设置windows的监听类
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });

        // 添加自定义键盘监听事件
        this.addKeyListener(new MyKeyListener());
    }

    Image offScreenImage = null;

    /**
     * 双缓冲解决界面闪烁问题
     *
     * @param g g
     */
    @Override
    public void update(Graphics g) {
        if(null == offScreenImage){
            offScreenImage = this.createImage(GAME_WITH,GAME_HEIGHT);
        }
        Graphics graphics = offScreenImage.getGraphics();
        Color color = graphics.getColor();
        graphics.setColor(Color.BLACK);
        graphics.fillRect(0,0,GAME_WITH,GAME_HEIGHT);
        graphics.setColor(color);
        paint(graphics);
         g.drawImage(offScreenImage,0,0,null);
    }

    /**
     * 窗口变化就会被执行
     *
     * 每次刷新，哪个方向为true，那就一直增加那个方向对应的xy的值
     *
     * @param g g
     */
    @Override
    public void paint(Graphics g) {
        Color color = g.getColor();
        g.setColor(Color.WHITE);
        g.drawString("子弹数量："+bulletList.size(),10,50);
        g.drawString("敌方数量："+tankList.size(),10,70);
        g.setColor(color);
        tank.paint(g);
        for (int i = 0; i < bulletList.size(); i++) {
            bulletList.get(i).paint(g);
        }
        // 画敌人坦克
        for (int i = 0; i < tankList.size(); i++) {
            tankList.get(i).paint(g);
        }

        // 碰撞检测
        for (int i = 0; i < bulletList.size(); i++) {
            for (int j = 0; j < tankList.size(); j++) {
                bulletList.get(i).collideWith(tankList.get(j));
            }

        }
    }


    /**
     * @Auther: Gudao
     * @Date: 2021/04/27
     * @Description: 自定义键盘监听事件
     */
    class MyKeyListener extends KeyAdapter{

        boolean bL = false;
        boolean bR = false;
        boolean bU = false;
        boolean bD = false;

        /**
         * 键盘按下执行
         *
         * @param e e
         */
        @Override
        public void keyPressed(KeyEvent e) {
            int keyCode = e.getKeyCode();
            switch (keyCode){
                case KeyEvent.VK_LEFT:
                    bL = true;
                    break;
                case KeyEvent.VK_RIGHT:
                    bR = true;
                    break;
                case KeyEvent.VK_UP:
                    bU = true;
                    break;
                case KeyEvent.VK_DOWN:
                    bD = true;
                    break;
                default:
                    break;
            }
            setMainTankDir();
        }


        /**
         * 设置坦克方向
         */
        private void setMainTankDir() {
            // 如果任何按键都没有触动就是停止
            if(!bL && !bR && !bD && !bU) tank.setMoving(false);
            else tank.setMoving(true);

            if(bL) tank.setDir(Dir.LEFT);

            if(bR) tank.setDir(Dir.RIGHT);
            if(bU) tank.setDir(Dir.UP);
            if(bD) tank.setDir(Dir.DOWN);
        }

        /**
         * 键盘抬起执行
         *
         * @param e e
         */
        @Override
        public void keyReleased(KeyEvent e) {
            int keyCode = e.getKeyCode();
            switch (keyCode){
                case KeyEvent.VK_LEFT:
                    bL = false;
                    break;
                case KeyEvent.VK_RIGHT:
                    bR = false;
                    break;
                case KeyEvent.VK_UP:
                    bU = false;
                    break;
                case KeyEvent.VK_DOWN:
                    bD = false;
                    break;
                case KeyEvent.VK_CONTROL:// 监听Ctrl弹起事件
                    tank.fire();
                    break;
                default:
                    break;
            }
            setMainTankDir();
        }
    }
}
