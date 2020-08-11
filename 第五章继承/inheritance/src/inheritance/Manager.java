package inheritance;
//extends 是继承 ， Manager是子类，而Employee 是超类父类
public class Manager  extends Employee{
    private double bonus;   //新增的实例字段

    //Manager子类构造器，用super调用父类构造器
    public Manager(String name , double salary , int year , int month , int day)
    {
        super(name,salary,year,month,day);
        bonus = 0;
    }
    //super还可以调用超类的方法,覆盖方法要用super调用才可解决
    public double getSalary()
    {
        double baseSalary = super.getSalary();
        return baseSalary + bonus;
    }

    public void setBonus(double b)
    {
        bonus = b;
    }
}
