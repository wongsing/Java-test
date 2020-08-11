import java.util.*;
import java.math.*;
/*
    大数，满足任意得长度和精度，BigInteger、BigDouble
    需要用BigInteger.valueOf()将数值转换成大数,用multiply和divide来乘除，add和subtract来加减，mod求模
 */
public class Biginteger {
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);

        System.out.print("How many numbers do you need to draw? ");
        int k = in.nextInt();

        System.out.print("What is the highest number you can draw? ");
        int n = in.nextInt();

        //概率算式：n*(n-1)*(n-2)*...*(n-k+1)/(1+2+...+k)
        BigInteger lottertOdds = BigInteger.valueOf(1);
        for( int i = 1; i <= k; i++)
            lottertOdds = lottertOdds.multiply(BigInteger.valueOf(n-i+1)).divide(BigInteger.valueOf(i));

        System.out.print("Your odds are 1 in "+ lottertOdds + ". Good luck!");

    }
}
