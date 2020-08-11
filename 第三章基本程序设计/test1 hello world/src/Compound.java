//多维数组
public class Compound {
    public static void main(String[] args)
    {
        final double STARTRATE = 10;
        final int NRATES = 6;
        final int NYEARS = 10;
        //初始化利率为10~15%
        double[] interestRate = new double[NRATES];
        for(int j = 0;j < interestRate.length;j++)
            interestRate[j] = (STARTRATE+j) / 100.0;

        //初始化本金为10000
        double[][] balances = new double[NYEARS][NRATES];
        for(int j = 0;j < balances[0].length;j++)
            balances[0][j] = 10000;
        //二维数组名.length指的是第一维i长度
        for(int i = 1;i< balances.length;i++)
        {       //二维数组名[].length指的是第二维j长度
            for(int j = 0; j <balances[i].length;j++)
            {
                //得到上一年的本金
                double oldBalance = balances[i-1][j];
                //计算出利息
                double interest = oldBalance * interestRate[j];
                balances[i][j] = oldBalance + interest;
            }
        }
        for(int j=0 ; j < interestRate.length;j++)
            System.out.printf("%9.0f%%",100*interestRate[j]);

        System.out.println();
        //for each循环，for(元素类型 变量名：要遍历的对象)
        for(double[] row : balances)
        {
            for(double b : row)
                System.out.printf("%10.2f",b);

            System.out.println();
        }
    }
}
