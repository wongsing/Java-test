import java.util.Scanner;   //输出Scanner不在java.lang包中，需要import导入相应的包java.util

public class InputTest {
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);       //构造一个输入流
        System.out.print("What is your name?");
        String name = in.nextLine();    //读取一行

        System.out.print("How old are you?");
        int age = in.nextInt();         //读取一个数值

        System.out.println("Hello, " + name + ". Next year,you will be "+ (age + 1));
    }
}
