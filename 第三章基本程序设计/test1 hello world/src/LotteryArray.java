import java.util.*;
/*
    从n个数字抽取k个数字，能随机得到哪些结果
    一维数组的创建，Arrays类的方法length/sort;
    Math.random用法
 */
public class LotteryArray {
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        System.out.print("How many numbers do you need to draw? ");
        int k = in.nextInt();

        System.out.print("What is the highest number you can draw? ");
        int n = in.nextInt();

        //创建一个长度为n的整型数组，需要用到new，若是int[] a; 则不算是真正数组，只是声明变量而已
        int[] numbers = new int[n];
        for(int i = 0;i < numbers.length;i++)   //arrays.length直接算出数组元素个数
            numbers[i] = i+1;          //数组初始化

        int[] result = new int[k];      //保存抽取的数字
        for(int i = 0;i < result.length;i++)
        {   //Math.random()返回一个0-1的随机浮点数，再*n是要得到0~n-1的随机数
            int r = (int)(Math.random() * n);

            result[i] = numbers[r];   //抽取到的随机数存入result数组

            numbers[r] = numbers[n - 1];    //避免重复，将最后一个数覆盖已抽到的结果
            n--;
        }

        Arrays.sort(result);        //数组自动排序，用的是快排实现的
        System.out.println("Bet the follwing comnination.It will make you rich!");
        for(int r : result)         //for each循环，逐个输出数组的所有元素
            System.out.println(r);
    }
}
