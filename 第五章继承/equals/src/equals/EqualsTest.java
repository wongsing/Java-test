package equals;
//Object超类的equals方法测试，hashCode方法，toString方法
//equals四个步骤：先看otherobje是否与this相等，后看otherobject是否为空，两者的类是否相等，最后对象用equals比，基本类型用==比
public class EqualsTest {
    public static void main(String[] args)
    {
        var alice1 = new Employee("Alice Adams" , 75000 , 1987, 12, 15);
        var alice2 = alice1;
        var alice3 = new Employee("Alice Adams" , 75000 , 1987, 12, 15);
        var bob = new Employee("Bob Brandson" , 50000 , 1989, 10, 1);

        System.out.println("alice1 == alice2: " + (alice1 == alice2));

        System.out.println("alice1 == alice3: " + (alice1 == alice3));

        System.out.println("alice1.equals(alice3): " + (alice1.equals(alice3)));

        System.out.println("alice1.equals(bob): " + (alice1.equals(bob)));

        System.out.println("bob.toString(): " + bob );

        var carl = new Manager("Carl Craker",80000,1987,12,15);
        var boss = new Manager("Carl Craker",80000,1987,12,15);

        boss.setBonus(5000);

        System.out.println("boss.toString(): " + boss );
        System.out.println("carl.equals(boss): " + carl.equals(boss) );

        System.out.println("alice1.hashcode(): " + alice1.hashCode());
        System.out.println("alice3.hashcode(): " + alice3.hashCode());
        System.out.println("bob.hashcode(): " + bob.hashCode());
        System.out.println("carl.hashcode(): " + carl.hashCode());
    }
}
