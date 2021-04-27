package org.gudao;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * @Auther: Gudao
 * @Date: 2021/4/27
 * @Description:
 */
public class T {
    public static void main(String[] args) {
        // 创建窗口对象
        Frame f = new Frame();
        // 设置窗口大小
        f.setSize(800,600);
        // 设置是否能再次改变大小
        f.setResizable(false);
        // 设置标题
        f.setTitle("Gudao");
        // 设置可见
        f.setVisible(true);
        // 设置窗口可关闭：设置windows的监听类
        f.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }
}
