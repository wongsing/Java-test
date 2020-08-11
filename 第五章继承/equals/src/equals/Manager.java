package equals;

import java.util.Objects;

public class Manager extends Employee {
    private  double bonus;

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

    public void setBonus(double bonus)
    {
        this.bonus = bonus;
    }
//覆盖方法，先得出父类的是否相等，然后再强制转换类型，最后比较子类的独有字段
    public boolean equals(Object otherObject)
    {
        if(!super.equals(otherObject)) return false;
        var other = (Manager) otherObject;
        return bonus == other.bonus;
    }
//一样是覆盖，从父类得到已知的再加上新增的字段bonus
    public  int hashCode()
    {
        return java.util.Objects.hash(super.hashCode(),bonus);
    }

    public String toString()
    {
        return super.toString() + "[bonus=" + bonus + "]";
    }
}
