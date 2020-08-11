//不规则数组，先设置大行再分配小行，每一行长度不一样
public class LotteryArray2 {
    public static void main(String[] args)
    {
        final int NMAX = 10;
        int [][] odds = new int[NMAX+1][];      //11大行
        for(int n = 0; n <= NMAX;n++)
            odds[n] = new int[n+1];     //分配每行，相当于一行有几列

        for(int n =0; n < odds.length; n++)     //分配完后按照不越界来访问数组元素
            for(int k = 0; k < odds[n].length;k++)
            {
                int lotteryOdds = 1;
                for(int i = 1; i <= k;i++)
                    lotteryOdds = lotteryOdds * (n-i+1) / i;

                odds[n][k] = lotteryOdds;
            }

        for(int[] row : odds)
        {
            for(int odd :row)
                System.out.printf("%4d",odd);
            System.out.println();
        }
    }
}
