package equals;

import java.time.*;
import java.util.Objects;

public class Employee {
    private String name;
    private double salary;
    private LocalDate hireDay;

    public Employee(String name , double salary , int year , int month, int day)
    {
        this.name = name;
        this.salary = salary;
        hireDay = LocalDate.of(year,month,day);
    }

    public String getName()
    {
        return name;
    }

    public double getSalary() {
        return salary;
    }

    public LocalDate getHireDay() {
        return hireDay;
    }

    public void raiseSalary(double byPercent)
    {
        double raise = salary * byPercent /100;
        salary += raise;
    }
//比较两个对象是否相等，如果两个对象指向同一块存储区域，则返回true
    public boolean equals(Object otherObject)
    {   //检测this是否与otherObject相等
        if(this == otherObject) return true;
        //otherObject是否为空
        if (otherObject == null) return false;
        //比较this与otherObject的类
        if (getClass() != otherObject.getClass()) return false;
        //将otherObject强转成相应类型
        var other = (Employee) otherObject;
        //使用“==“检测基本类型，用Objects.equals比较对象字段
        return Objects.equals(name,other.name) && salary == other.salary
            && Objects.equals(hireDay , other.hireDay);
    }
    //参数为null，返回0，否则调用hashcode的结果,一个散列码
    public int hashCode()
    {
        return Objects.hash(name,salary,hireDay);
    }
    //返回对象值的字符串
    public String toString()
    {
        return getClass().getName() + "[name=" + name + ",salary=" + salary +",hireDay=" + hireDay+"]";
    }
}
