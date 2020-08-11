/*
含有静态字段和静态方法的自定义创建类
 */
public class StaticTest {
    public static void main(String[] args)
    {
        Employee[] staff = new Employee[3]; //构造一个Employee数组，并且填入3个Employee对象
        //var staff = new Employee[3];      java10才可以用var声明局部变量

        staff[0] = new Employee("Tom", 40000);
        staff[1] = new Employee("Dick", 60000);
        staff[2] = new Employee("Harry", 65000);

        for(Employee e : staff)     //遍历staff数组
        {
            e.setId();
            System.out.println("name="+e.getName() + ",id=" + e.getId()
                    + ",salary=" + e.getSalary());
        }

        int n = Employee.getNextId();   //静态方法
        System.out.println("Next available id=" + n);
    }
}
//构建自定义类
class Employee
{
    private static int nextId = 1;      //静态字段，只属于类，不属于任何对象，相当于c语言的static静态局部变量
    private  String name;
    private  double salary;
    private  int id;

    public Employee(String n , double s)    //构造器
    {
        name = n;
        salary = s;
        id = 0;
    }

    public String getName()
    {
        return name;
    }

    public double getSalary() {
        return salary;
    }

    public int getId() {
        return id;
    }

    public void setId()     //不返回任何参数
    {
        id = nextId;
        nextId++;
    }

    public static int getNextId()
    {
        return nextId;      //返回的是static字段，静态字段
    }

    public static void main(String[] args)  //测试单元可以单独运行测试
    {
        Employee e = new Employee("Harry",50000);
        System.out.println(e.getName()+" "+e.getSalary());
    }
}