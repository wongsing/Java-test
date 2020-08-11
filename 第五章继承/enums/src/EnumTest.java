import java.util.*;
//枚举类比较直接用 == ，可以为它增加构造器、方法和字段。
public class EnumTest {
    public static void main(String[] args)
    {
        var in = new Scanner(System.in);
        System.out.print("Enter a size: (SMALL, MEDIUM, LARGE, EXTRA_LARGE)");
        String input = in.next().toUpperCase();     //toUpperCase输入转换成大写字母
        Size size = Enum.valueOf(Size.class , input);   //将size设置成input-->Size.SMALL.toString()将返回字符串
        System.out.println("size="+size);
        System.out.println("abbreviation=" + size.getAbbreviation());
        if(size == Size.EXTRA_LARGE)
            System.out.println("Good job--you paid attention to the _.");
    }
}
//枚举类
enum Size
{
    SMALL("S") , MEDIUM("M") , LARGE("L") , EXTRA_LARGE("XL");
    //字段
    private  String abbreviation;
    //枚举类构造器是私有的
    private Size(String abbreviation){this.abbreviation = abbreviation; }
    //方法
    public String getAbbreviation(){return abbreviation; }
}