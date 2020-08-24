package pair2;
/*
类型变量的限定，用extends
若有多个可以用&分隔开，可以有多个接口超类型，最多只能有一个限定可以是类而且是第一个
 */
import java.time.*;

public class PairTest2 {
    public static void main(String[] args)
    {
        LocalDate[] birthdays =
                {
                        LocalDate.of(1906,12,9), //G.Hopper
                        LocalDate.of(1815,12,10), //A.LOVE
                        LocalDate.of(1903,12,3), //B.BAD
                        LocalDate.of(1910,6,22), //C.CAT
                };
        Pair<LocalDate> mm = ArrayAlg.minmax(birthdays);
        System.out.println("min = " + mm.getFirst());
        System.out.println("max = " + mm.getSecond());
    }
}
//T实现Comparable的接口
class ArrayAlg
{
    public static <T extends Comparable> Pair<T> minmax (T[] a)
    {
        if (a == null || a.length == 0) return null;
        T min = a[0];
        T max = a[0];
        for (int i=1; i < a.length ; i++)
        {
            if (min.compareTo(a[i]) > 0) min = a[i];
            if (max.compareTo(a[i]) < 0) max = a[i];
        }
        return new Pair<>(min,max);
    }
}