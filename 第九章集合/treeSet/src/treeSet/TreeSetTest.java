package treeSet;
/*树集，TreeSet类
先按默认顺序输出，然后再按比较排序输出
 */
import java.util.Comparator;
import java.util.TreeSet;

public class TreeSetTest {
    public static void main(String[] args)
    {
        var parts = new TreeSet<Item>();    //树集参数用Item类
        parts.add(new Item("Toaster" , 1234));
        parts.add(new Item("Widget" , 4562));
        parts.add(new Item("Modem" , 9912));
        System.out.println(parts);
                                                        //Comparator<>对元素进行排序的比较器
        var sortByDescription = new TreeSet<Item>(Comparator.comparing(Item::getDescription));//::是方法引用
        sortByDescription.addAll(parts);
        System.out.println(sortByDescription);
    }
}
