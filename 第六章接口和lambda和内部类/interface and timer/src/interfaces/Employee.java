package interfaces;
/*
1.创建一个Employee类的对象来实现Comparable接口，但要在实现类中改写接口中的抽象方法compareTo
 */

public class Employee implements Comparable<Employee>
{
    private String name;
    private double salary;

    public Employee(String name,double salary)
    {
        this.name = name;
        this.salary = salary;
    }

    public String getName()
    {
        return name;
    }

    public double getSalary() {
        return salary;
    }

    public void raiseSalary(double byPercent)
    {
        double raise = salary * byPercent /100;
        salary += raise;
    }
/*
重写抽象方法，比较工资，对象与other相比，返回一整数，正负0
 */
    public int compareTo(Employee other)
    {
        return Double.compare(salary , other.salary);
    }
}
