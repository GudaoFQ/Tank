package org.gudao;

import java.awt.Frame;

/**
 * @Auther: Gudao
 * @Date: 2021/4/27
 * @Description:
 */
public class Main {
    public static void main(String[] args) throws InterruptedException {
        // 创建窗口对象
        TankFrame f = new TankFrame();

        // 创建5个坦克
        for (int i = 0; i < 5; i++) {
            f.tankList.add(new Tank(50 + i*80, 200, Dir.DOWN, f, Group.Bad));
        }

        while (true){
            Thread.sleep(50);
            f.repaint();
        }
    }
}
