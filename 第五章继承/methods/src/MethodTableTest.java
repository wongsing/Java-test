import java.lang.reflect.*;
//通过反射使用invoke调用当前Methods类中的方法
//可以用getDeclareMethods方法或者是调用Class类中的getMethods（String name , Class 方法的类型）
public class MethodTableTest {
    public static void main(String[] args)
            throws ReflectiveOperationException
    {
        Method square = MethodTableTest.class.getMethod("square",double.class);
        Method sqrt = Math.class.getMethod("sqrt", double.class);

        printTable(1,10,10,square);
        printTable(1,10,10,sqrt);
    }
    //sqrt是Math类中的方法,参数为一个double
    public static double square(double x)
    {
        return x * x;
    }

    public static void printTable(double from , double to , int n, Method f)
        throws ReflectiveOperationException
    {
        System.out.println(f);

        double dx = (to - from) / (n - 1);

        for (double x = from; x <= to; x += dx)
        {
            double y = (Double) f.invoke(null,x);   //Methods中的invoke方法任意调动当前对象的方法
            System.out.printf("%10.4f | %10.4f%n",x,y);
        }
    }
}
