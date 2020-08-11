import java.util.*;
/*
    do-while 循环
    每年得到的资产，每次循环判断是否想要退休，循环条件N，注意equals用法
 */
public class Retirement2 {
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);

        System.out.print("How much money will you contribute every year? ");
        double payment = in.nextDouble();

        System.out.print("Interest rate in %: ");
        double interestRate = in.nextDouble();

        double balance = 0;
        int year = 0;

        String input;

        do {
            balance += payment;
            double interest = balance * interestRate / 100;
            balance += interest;
            year++;
                                                        //%,是分组分隔符
            System.out.printf("After year %d,your balance is %,.2f%n",year,balance);

            System.out.print("Ready to retire? (Y/N) ");
            input = in.next();
        }
        while(input.equals("N"));       //方法equals验证两个字符是否相等
    }
}
