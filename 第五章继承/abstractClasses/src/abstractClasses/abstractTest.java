package abstractClasses;

public class abstractTest {
    public static  void main(String[] args)
    {
        var people =  new Person[2];

        people[0] = new Employee("Carl Cracker", 80000, 1987, 12, 15);
        people[1] = new Student("Harry Hacker", "math");

//构建抽象类，当抽象子类都定义了getDescription时，抽象超类不可以省略了，需要了解接口
//并且抽象类不能构造对象，所以调用e不会引用Person对象而是会引用子类

        for(Person  e : people)
            System.out.println(e.getName() +","+e.getDescription());
    }
}
