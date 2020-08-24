package annoymousInnerClass;
/*
1.匿名内部类，创建一个类的对象，不需要指定名字，直接实现ActionListener接口，实现方法在actionPerformed{}定义
2.它不能有构造器，因为没有名字
3.内部类能访问外部类的字段
 */
import java.awt.*;
import java.awt.event.*;
import java.time.*;
import javax.swing.*;

public class AnnoymousInnerClassTest {
    public static void main(String[] args)
    {
        var clock = new TalkingClock();
        clock.start(1000, true);

        JOptionPane.showMessageDialog(null,"该去睡觉了吗？");
        System.exit(0);
    }
}

class TalkingClock
{
    public void start(int interval , boolean beep)
    {
        var listener = new ActionListener()
        {
            public void actionPerformed(ActionEvent event)
            {
                System.out.println("At the tone, the time is "
                +Instant.ofEpochMilli(event.getWhen()));
                if (beep) Toolkit.getDefaultToolkit().beep();
            }
        };
        var timer = new Timer(interval,listener);
        timer.start();
    }
}