package org.gudao;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * @Auther: Gudao
 * @Date: 2021/4/27
 * @Description:
 */
public class Main {
    public static void main(String[] args) throws InterruptedException {
        // 创建窗口对象
        Frame f = new TankFrame();
        while (true){
            Thread.sleep(50);
            f.repaint();
        }
    }
}
