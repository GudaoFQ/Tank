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
    public TankFrame() throws HeadlessException {
        // 设置窗口大小
        setSize(800,600);
        // 设置是否能再次改变大小
        setResizable(false);
        // 设置标题
        setTitle("Gudao");
        // 设置可见
        setVisible(true);
    }


    /**
     * 窗口变化就会被执行
     *
     * @param g g
     */
    @Override
    public void paint(Graphics g) {
        g.fillRect(200,200,50,50);
    }

    public static void main(String[] args) {
        // 创建窗口对象
        Frame f = new TankFrame();
        // 设置窗口可关闭：设置windows的监听类
        f.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }
}
