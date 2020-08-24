package timer;
/*
1.接口跟回调，实现了一个计时器，类实现了java.awt.event包的ActionListener接口，并重写接口中抽象方法actionPerformed
 */
import java.awt.*;
import java.awt.event.*;
import java.time.*;
import javax.swing.*;

public class TimerTest {
    public static void main(String[] args)
    {
        var listener = new TimePrinter();

        var timer = new Timer(2000,listener);
        timer.start();

        JOptionPane.showMessageDialog(null,"Quit program?");
        System.exit(0);
    }
}

class TimePrinter implements ActionListener
{
    public void actionPerformed(ActionEvent event)
    {
        System.out.println("At the tone, the time is"
        + Instant.ofEpochMilli(event.getWhen()));
        Toolkit.getDefaultToolkit().beep();
    }
}
