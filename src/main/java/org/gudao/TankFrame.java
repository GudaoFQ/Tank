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
    Tank tank = new Tank(200,200,Dir.DOWN);

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
        tank.paint(g);

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

        private void setMainTankDir() {
            if(bL){
               tank.setDir(Dir.LEFT);
            }
            if(bR){
                tank.setDir(Dir.RIGHT);
            }
            if(bU){
                tank.setDir(Dir.UP);
            }
            if(bD){
                tank.setDir(Dir.DOWN);
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
                default:
                    break;
            }
            setMainTankDir();
        }
    }
}
