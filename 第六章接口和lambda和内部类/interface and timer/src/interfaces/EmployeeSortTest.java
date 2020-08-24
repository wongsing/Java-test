package interfaces;

import java.lang.reflect.Array;
import java.util.*;

public class EmployeeSortTest {
    public static void main(String[] args)
    {
        var staff = new Employee[3];

        staff[0] = new Employee("Harry Hacker" , 35000);
        staff[1] = new Employee("Kobe" , 45000);
        staff[2] = new Employee("Lebron" , 55000);

        Arrays.sort(staff);

        for(Employee e : staff)
            System.out.println("name="+e.getName() +",salary="+e.getSalary());
    }
}
