package lambda;
/*
1.用lambda表达式可以传递到函数式接口,
2.参数，箭头，表达式 是lambda表达式标配
3.函数式接口指的是只有一个抽象方法的接口
 */
import java.util.*;
import javax.swing.*;
import javax.swing.Timer;

public class LambdaTest {
    public static void main(String[] args)
    {
        var planets = new String[]{
                "Mercury","Venus","Earth","Mars","Jupiter","Saturn","Uranus","Neptune"
        };
        System.out.println(Arrays.toString(planets));
        System.out.println("Sorted in dictionary order:");
        Arrays.sort(planets);
        System.out.println(Arrays.toString(planets));
        System.out.println("Sorted by length:");
        Arrays.sort(planets, (first,second)->first.length() - second.length());
        System.out.println(Arrays.toString(planets));

        var timer = new Timer(1000, event ->
                System.out.println("The time is "+new Date()));
        timer.start();

        JOptionPane.showMessageDialog(null , "油腻大叔 还不减肥?");
        System.exit(0);
    }

}
