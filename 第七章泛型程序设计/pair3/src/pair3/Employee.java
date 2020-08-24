package pair3;

import java.time.LocalDate;

public class Employee {
    private double salary;
    private String name;
    private LocalDate date;

    public Employee(String name, double salary , int year , int month , int day)
    {
        this.salary = salary;
        this.name = name;
        date = LocalDate.of(year,month,day);
    }

    public String getName() {
        return name;
    }

    public double getSalary() {
        return salary;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
}
