package shuffle;
import java.util.*;
/*
shuffle方法随机打乱元素，subList方法设置子范围，sort方法就是排序
 */
public class ShuffleTest {
    public static void main(String[] args)
    {
        var numbers = new ArrayList<Integer>();
        for (int i = 1; i <= 49; i++)
            numbers.add(i);
        Collections.shuffle(numbers);   //  打乱元素
        List<Integer>winningCombination = numbers.subList(0,6); //子范围下标0-5
        Collections.sort(winningCombination);//元素排序
        System.out.println(winningCombination);
    }
}
