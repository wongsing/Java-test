import java.util.*;
/*
展示对象初始化块，静态初始化块，用this调用另一个构造器，无参数构造器,字段初始化
只要构造类的对象，就会执行对象初始化块，然后才允许构造器主体部分，而静态初始化块只在第一次加载时候初始化
this按照参数调用另一个构造器
 */
public class ConstrutorTest {


    public static void main(String[] args) {
        Employee[] staff = new Employee[3];

        staff[0] = new Employee("Harry", 40000);
        staff[1] = new Employee(60000);
        staff[2] = new Employee();

        for (Employee e : staff)
            System.out.println("name=" + e.getName() + ",id=" + e.getId() +
                    ",salary=" + e.getSalary());
    }
}
        class Employee
        {
            private static int nextId;     //静态字段

            private int id;
            private String name = "";
            private double salary;
            //静态初始化块，当类第一次加载就开始初始化了
            static
            {
                var generator = new Random();       //获得一个随机值0~9999
                nextId = generator.nextInt(10000);
            }
            //对象初始化块
            {
                id = nextId;
                nextId++;
            }
            //总共3个构造器，重载构造器
            public Employee(String n , double s)
            {
                name = n;
                salary = s;
            }

            public Employee(double s)
            {   //this调用另一个构造器Employee(String , double)
                this("Employee #" + nextId ,s);
            }
            //空构造器，所有对象默认初始值
            public Employee()
            {
                //全部为默认初始值
                //name 初始为空
                //salary 初始位0
            }

            public String getName() {
                return name;
            }

            public double getSalary() {
                return salary;
            }

            public int getId() {
                return id;
            }
        }


