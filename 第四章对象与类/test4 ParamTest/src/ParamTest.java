/*
测验方法参数，得到3条结论：
1.方法不能直接改变基本数据类型的参数
2.方法可以改变对象参数的状态，要通过构建对象变量副本才可修改
3.方法不能让一个对象参数引用一个新的对象,不能实现C/C++那种swap指针互换
 */
public class ParamTest {
    public static void main(String[] args)
    {
        /*
        Test1:将数值参数的值增长3倍，失败，方法不能改变基本数据类型的参数
         */
        System.out.println("Testing tripleValue:");
        double percent = 10;
        System.out.println("Before: percent=" + percent);
        tripleValue(percent);
        System.out.println("After: percent=" + percent);

        /*
        Test2:成功将一个员工的工资增长三倍，方法可以改变对象参数的状态
        构建一个新的对象变量x引用同一个对象，相当于两个对象变量x，harry同时引用同一个对象
         */
        System.out.println("\nTesting tripleSalary:");
        Employee harry = new Employee("Harry", 50000);
        System.out.println("Before: salary=" + harry.getSalary());
        tripleSalary(harry);
        System.out.println("After: salary=" + harry.getSalary());

        /*
        Test3:参数变量x和y交换了，但变量a、b无影响，方法不能让一个对象参数引用一个新的对象
         */
        System.out.println("\nTesting swap:");
        Employee a = new Employee("Alice", 70000);
        Employee b = new Employee("Bob", 60000);
        System.out.println("Before: a=" + a.getName());
        System.out.println("Before: b=" + b.getName());
        swap(a,b);
        System.out.println("After:a=" + a.getName());
        System.out.println("After:b=" + b.getName());
    }
    //3个静态方法
    public static void tripleValue(double x)    //失败
    {
        x = 3 * x;
        System.out.println("End of method: x=" + x);
    }

    public static void tripleSalary(Employee x)     //成功
    {
        x.raiseSalary(200);
        System.out.println("End of method: salary=" + x.getSalary());
    }

    public static void swap(Employee x , Employee y)    //失败
    {
        Employee temp = x;
        x = y;
        y = temp;
        System.out.println("End of method: x=" + x.getName());
        System.out.println("End of method: y=" + y.getName());
    }
}
//构造自定义类
class Employee
{
    private String name;
    private  double salary;

    public Employee(String n , double s)    //构造器
    {
        name = n;
        salary = s;
    }

    public String getName() {
        return name;
    }

    public double getSalary()
    {
        return salary;
    }

    public void raiseSalary(double byPercent)
    {
        double raise = salary * byPercent / 100;
        salary += raise;
    }
}