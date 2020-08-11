import java.time.LocalDate;
/*
用户自定义类，构造新的类，利用方法调用得到数值
并且只能有一个public类，可以有任意自定义类
 */
public class EmployeeTest {
    public static void main(String[] args)
    {
        Employee[] staff = new Employee[3];     //构造一个Employee数组，并且填入3个Employee对象

        staff[0] = new Employee("Vral Cracker",75000, 1987, 12, 15);
        staff[1] = new Employee("Harry Hacker",50000, 1989, 10, 1);
        staff[2] = new Employee("Tony Tester", 40000, 1990, 3, 15);

        for (Employee e : staff)    //遍历staff数组，调用方法每人工资提高5%
            e.raiseSalary(5);

        for (Employee e : staff)    //遍历staff数组，调用方法打印每人信息
            System.out.println("name="+e.getName() + ",salary="+e.getSalary() +
                    ",hireDat=" + e.getHireDay());
    }
}
//用户自定义类,包括一个构造器，四个方法
class Employee
{
    private String name;       //私有数据只能该类使用
    private double salary;
    private LocalDate hireDay;
    //构造器与类名一致，可以有n个参数，不返回值
    public Employee (String n, double s, int year,int month , int day)
    {
        name = n;
        salary = s;
        hireDay = LocalDate.of(year,month,day);
    }
    //以下方法为访问器方法
    public String getName()
    {
        return name;
    }

    public double getSalary() {
        return salary;
    }

    public LocalDate getHireDay()
    {
        return hireDay;
    }

    public void raiseSalary(double byPercent)
    {
        double raise = salary * byPercent / 100;
        salary += raise;
    }
}