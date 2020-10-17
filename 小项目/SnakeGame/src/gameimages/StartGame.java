package gameimages;
import javax.swing.*;
import java.awt.*;

public class StartGame {
    public static void main(String[] args) {
        //创建窗体
        JFrame jf = new JFrame();
        //给窗体设置一个标题
        jf.setTitle("小游戏 贪吃蛇 by wong");
        //设置窗体弹出的坐标，对应窗体的宽和高
        int width = Toolkit.getDefaultToolkit().getScreenSize().width;
        int height = Toolkit.getDefaultToolkit().getScreenSize().height;
        jf.setBounds((height-600)/5,(width-600)/5,800,800);
        //设置窗体大小不可调节
        jf.setResizable(false);
        //关闭窗口，程序同时关闭
        jf.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        //创建面板
        GamePanel gp = new GamePanel();
        //将面板放入窗体
        jf.add(gp);
        //默认情况下窗体是隐藏结果，必须把窗体进行显现-->显现方法最好放在最后
        jf.setVisible(true);
    }
}
