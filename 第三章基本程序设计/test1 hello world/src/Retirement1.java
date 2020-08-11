import java.util.*;
/* while循环
输入要退休的总资产，每年能贡献的资产，加上利息，到几年后可以退休
 */
public class Retirement1 {
    public static void main(String[] args)
    {
        Scanner in  = new Scanner(System.in);

        System.out.print("How much moeney do yuo need to retire?");
        double goal = in.nextDouble();

        System.out.print("How much money will you contribute every year?");
        double payment = in.nextDouble();

        System.out.print("Interest rate in %: ");
        double interestRate = in.nextDouble();

        double balance = 0;
        int years = 0;

        while(balance < goal)
        {
            balance += payment;
            double interest = balance * interestRate / 100;
            balance += interest;
            years++;
        }

        System.out.println("You can retire in "+years+" years wtih " + (int)balance);
    }
}
