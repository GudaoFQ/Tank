package org.gudao;

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * @Auther: Gudao
 * @Date: 2021/4/27
 * @Description:
 */
public class TankFrame extends Frame {
    int x = 200,y = 200;
    // 移动方向
    Dir dir = Dir.DOWN;
    // 移动速度
    private static final int SPEED = 10;

    public TankFrame() throws HeadlessException {
        // 设置窗口大小
        setSize(800,600);
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


    /**
     * 窗口变化就会被执行
     *
     * 每次刷新，哪个方向为true，那就一直增加那个方向对应的xy的值
     *
     * @param g g
     */
    @Override
    public void paint(Graphics g) {
        g.fillRect(x,y,50,50);
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
                    x -= 10;
                    break;
                case KeyEvent.VK_RIGHT:
                    bR = true;
                    x += 10;
                    break;
                case KeyEvent.VK_UP:
                    bU = true;
                    y -= 10;
                    break;
                case KeyEvent.VK_DOWN:
                    bD = true;
                    y += 10;
                    break;
                default:
                    break;
            }
            setMainTankDir();
        }

        private void setMainTankDir() {
            if(bL){
                dir = Dir.LEFT;
            }
            if(bR){
                dir = Dir.RIGHT;
            }
            if(bU){
                dir = Dir.UP;
            }
            if(bD){
                dir = Dir.DOWN;
            }
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
                    x -= 10;
                    break;
                case KeyEvent.VK_RIGHT:
                    bR = false;
                    x += 10;
                    break;
                case KeyEvent.VK_UP:
                    bU = false;
                    y -= 10;
                    break;
                case KeyEvent.VK_DOWN:
                    bD = false;
                    y += 10;
                    break;
                default:
                    break;
            }
            setMainTankDir();
        }
    }
}
