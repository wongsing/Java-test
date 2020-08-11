import java.util.*;
//泛型数组列表创建，菱形语法--> ArrayList<Employee>()
//使用add方法添加元素，用set和get方法访问和修改元素,size方法返回实际元素个数
public class arrayListTest {
    public static void main(String[] args)
    {
        var staff = new ArrayList<Employee>();
        //var staff = new ArrayList<Employee>(100);    直接赋初始值确认容量
        staff.add(new Employee("Carl Cracker", 75000, 1987, 12, 15));
        staff.add(new Employee("Harry Hacker", 50000, 1989, 10, 1));
        staff.add(new Employee("Tony Tester", 40000, 1990, 3, 15));

        for (Employee e : staff)
            e.raiseSalary(5);

        for (Employee e : staff)
            System.out.println("name="+e.getName() + ",salary=" + e.getSalary() + ",hireDay="+e.getHireDay());

    }
}

