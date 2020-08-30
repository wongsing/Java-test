package set;
/*
散列表 HashSet类
输入单词文本，填入散列表，算出单词数和所需时间
 */
import java.util.*;

public class SetTest {
    public static void main(String[] args)
    {
        var words = new HashSet<String>();
        long totalTime = 0;
        //没有设置输出退出出口，则用ctrl+D强制停止输出
        try(var in = new Scanner(System.in))
        {
            while (in.hasNext())
            {
                String word = in.next();
                long callTime = System.currentTimeMillis();
                words.add(word);    //将单词存入散列表
                callTime = System.currentTimeMillis() - callTime;
                totalTime += callTime;
            }
        }
        //迭代器
        Iterator<String> iter = words.iterator();
        for (int i = 1; i <= 20 && iter.hasNext(); i++)
            System.out.println(iter.next());
        System.out.println("...");
        System.out.println(words.size() + " distinct words. " + totalTime+" milliseconds.");
    }
}
