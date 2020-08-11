import java.lang.reflect.*;
import java.util.*;
/*
演示了利用反射来编写泛型数组
newInstance 构造一个新数组，两个参数分别是数组的元素类型，和数组长度
Class.getComponentType获得元素类型
Array.length获得数组长度
 */

public class CopyOfTest {
    public static void main(String[] args)
    {
        int[] a = {1,2,3};
        a = (int[]) goodCopyOf(a, 10);
        System.out.println(Arrays.toString(a));

        String[] b ={"Tom" , "Dick" ,"Harry"};
        b = (String[]) goodCopyOf(b , 10);
        System.out.println(Arrays.toString(b));

        System.out.println("The follwing call with generate an exception.");
 //       b = (String[]) badCopyOf(b,10); //Object[]不能强转成String[]
    }

    public static Object[] badCopyOf(Object[] a, int newLength) //not use
    {
        var newArray = new Object[newLength];
        System.arraycopy(a,0,newArray,0,Math.min(a.length,newLength));
        return newArray;
    }
    //int[]可以转换成object，不能转换成Object[]
    public static Object goodCopyOf(Object a , int newLength)
    {
        Class cl = a.getClass();
        if(!cl.isArray())   return null;    //先判断是否为数组
        Class componentType = cl.getComponentType();
        int length = Array.getLength(a);
        Object newArray = Array.newInstance(componentType,newLength);
        System.arraycopy(a,0,newArray,0,Math.min(length,newLength));
        //(源数组，源数组起始位，目标数组，目标数组起始位，长度)
        return newArray;
    }
}
