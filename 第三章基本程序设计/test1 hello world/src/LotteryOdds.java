import java.util.*;
/*
    for确定循环
    用来计算抽奖的概率，抽取k个数，总共n个数
 */
public class LotteryOdds {
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System .in);

        System.out.print("How many numbers do you need to draw? ");
        int k = in.nextInt();

        System.out.print("What is the highest number you can draw? ");
        int n = in.nextInt();

        //概率算式：n*(n-1)*(n-2)*...*(n-k+1)/(1+2+...+k)
        int lottertOdds = 1;
        for( int i = 1; i <= k; i++)
            lottertOdds = lottertOdds * (n - i + 1) / i;

        System.out.print("Your odds are 1 in "+ lottertOdds + ". Good luck!");
    }
}
