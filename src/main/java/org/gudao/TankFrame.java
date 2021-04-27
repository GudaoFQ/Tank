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
     * @param g g
     */
    @Override
    public void paint(Graphics g) {
        // 每次缩放窗口大小都会调用此方法，坐标也就会一直跟随改变
        g.fillRect(x,y,50,50);
        //x += 10;
        //y += 10;
    }


    /**
     * @Auther: Gudao
     * @Date: 2021/04/27
     * @Description: 自定义键盘监听事件
     */
    class MyKeyListener extends KeyAdapter{
        @Override
        public void keyPressed(KeyEvent e) {
            x += 30;// 此时不会重新刷新画布

            // 默认会调用paint；也可以写个线程，每隔一段时间进行paint
            //  repaint();
        }

        @Override
        public void keyReleased(KeyEvent e) {
            System.out.println("released");
        }
    }
}
