import java.time.*;
/*
设计一个月日历，利用LocalDate这个预定义类，使用工厂方法构建对象
利用静态方法构建对象变量
 */
public class CalenderTest {
    public static void main(String[] args)
    {
        LocalDate date = LocalDate.now();   //构建一个date对象，并用当前时间初始化
        int month = date.getMonthValue();   //获得当月月份
        int today = date.getDayOfMonth();   //获得日期

        date = date.minusDays(today - 1);   //将date设置为当月的第一天
        DayOfWeek weekday = date.getDayOfWeek();    //构建一个weekday对象，并初始化为星期几

        int value = weekday.getValue();    //1：Mon....7：Sun

        System.out.println("Mon Tue Wed Thu Fri Sat Sun");
        for (int i = 1; i < value ; i++)    //第一行进行缩进，直到出现当前的星期几
            System.out.print("    ");
        while(date.getMonthValue() == month)    //当月循环
        {
            System.out.printf("%3d",date.getDayOfMonth());      //打印日期值
            if (date.getDayOfMonth() == today)         //如果日期为当天加*标记
                System.out.print("*");
            else
                System.out.print(" ");
            date = date.plusDays(1);        //将日期加1
            if(date.getDayOfWeek().getValue() == 1)     //时间如果是周一则需要换行
                System.out.println();
        }
        if (date.getDayOfWeek().getValue() != 1 )
            System.out.println();
    }
}
