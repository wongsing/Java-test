package map;
import java.util.*;
/*
映射 HashMap类
 */
public class MapTest {
    public static void main(String[] args)
    {
        var staff = new HashMap<String,Employee>();
        staff.put("144-25-5464" , new Employee("Amy Lee"));
        staff.put("567-24-2546" , new Employee("Harry Hacker"));
        staff.put("157-62-7935" , new Employee("Gary Cooper"));
        staff.put("456-62-5527" , new Employee("Francesca Cruz"));

        System.out.println(staff);      //打印出来却显示不了employ的内容？？？
        //删除这个id
        staff.remove("567-24-2546");
        //更新id
        staff.put("456-62-5527" , new Employee("Francesca Miller"));
        //查看一个id
        System.out.println(staff.get("157-62-7935"));
        //打印全部信息
        staff.forEach((k,v)->
                System.out.println("key="+k+", value=" + v));
    }
}
