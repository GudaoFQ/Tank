package org.gudao;

import java.awt.*;
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
        x += 10;
        y += 10;
    }
}
