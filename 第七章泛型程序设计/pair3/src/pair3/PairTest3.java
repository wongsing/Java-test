package pair3;
/*
通配符 Pair<? extends Employee> 表示任何泛型Pair类型的类型参数是Employee的子类
？super Manager 通配符限制为Manager的所有超类型--》超类型限定
Pair<?>无限通配符

 */
public class PairTest3 {
    public static void main(String[] args)
    {
        var ceo = new Manager("Gus Greedy" , 900000 , 2003 , 12 , 15);
        var cfo = new Manager("Sid Sneaky" , 600000 , 2003 , 12 , 15);
        var buddies = new Pair<Manager>(ceo,cfo);
        printBuddies(buddies);

        ceo.setBonus(10000000);
        cfo.setBonus(500000);
        Manager[] managers = {ceo , cfo};

        var result = new Pair<Employee>();
        minmaxBonus(managers , result);
        System.out.println("first: "+result.getFirst().getName() +
                ",second: " + result.getSecond().getName());
        maxminBonus(managers,result);
        System.out.println("first: "+result.getFirst().getName() +
                ",second: " + result.getSecond().getName());
    }

    public static void printBuddies(Pair<? extends Employee> p)
    {
        Employee first = p.getFirst();
        Employee second = p.getSecond();
        System.out.println(first.getName() + " and " + second.getName() + " are buddies.");
    }

    public static void minmaxBonus(Manager[] a , Pair<? super Manager> result)
    {
        if (a.length == 0) return;
        Manager min = a[0];
        Manager max = a[0];
        for (int i = 1; i < a.length; i++)
        {
            if (min.getSalary() > a[i].getSalary()) min = a[i];
            if (max.getSalary() < a[i].getSalary()) max = a[i];
        }
        result.setFirst(min);
        result.setSecond(max);
    }

    public static void maxminBonus(Manager[] a, Pair<? super Manager> result)
    {
        minmaxBonus(a,result);
        PairAlg.swapHelper(result);
    }
    //不能写public static <T super manager>
}

class PairAlg
{
    public static<T> boolean hasNulls(Pair<T> p)
    {
        return p.getFirst() == null || p.getSecond() == null;
    }

    public static void swap(Pair<?> p)
        {swapHelper(p);}
//通配符捕获
    public static <T> void swapHelper(Pair<T> p)
    {
        T t = p.getFirst();
        p.setFirst(p.getSecond());
        p.setSecond(t);
    }
}