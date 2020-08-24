package clone;

import  java.util.Date;
import  java.util.GregorianCalendar;
/*
1.克隆，用Employee类cloned对象实现Cloneable接口，改写clone抽象函数，克隆对象和可变的字段
 */

public class Employee implements Cloneable{
    private String name;
    private double salary;
    private Date hireDay;

    public Employee(String name , double salary)
    {
        this.name = name;
        this.salary = salary;
        hireDay = new Date();
    }

    public Employee clone()
            throws CloneNotSupportedException
    {
        //对象克隆
        Employee cloned = (Employee) super.clone();
        //易变的字段克隆，深拷贝
        cloned.hireDay = (Date) hireDay.clone();

        return cloned;
    }

    public void setHireDay(int year , int month , int day)
    {
        Date newHireDay = new GregorianCalendar(year , month -1 , day).getTime();
        hireDay.setTime(newHireDay.getTime());
    }

    public void raiseSalary(double byPercent)
    {
        double raise = salary * byPercent /100;
        salary += raise;
    }

    public String toString()
    {
        return "Employee[name=" + name +",salary=" + salary +",hireDay="+hireDay + "]";
    }
}
