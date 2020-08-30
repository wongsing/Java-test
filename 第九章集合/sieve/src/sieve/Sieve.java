package sieve;
import java.util.*;
/*
寻找2000000以内素数的多少个，埃拉托色尼筛法，
利用位集,首先全部设置为开状态，然后将素数的倍数设置为关状态，最后留下来的就是素数
 */
public class Sieve {
    public static void main(String[] args)
    {
        int n = 2000000;
        long start = System.currentTimeMillis();
        var bitSet = new BitSet(n+1);
        int count = 0;
        int i;
        for (i = 2; i <= n; i++)
            bitSet.set(i);  //设置一个位
        i = 2;
        while(i *i <= n)
        {
            if (bitSet.get(i))  //获得一个位
            {                   //若是开，则把倍数设置为关
                count++;
                int k = 2 * i;
                while( k <= n)
                {
                    bitSet.clear(k);    //清除一个位
                    k += i;
                }
            }
            i++;
        }
        while(i <= n)
        {
            if (bitSet.get(i)) count++;
            i++;
        }
        long end = System.currentTimeMillis();
        System.out.println(count + " primes");
        System.out.println((end - start) + "milliseconds");
    }
}
