package linkedList;
/*
演示集合的链表，设置两个链表，先合并，然后从第二个列表中每隔一个删除一个元素，最后用removeall测试删除
LinkedList类,ListIterator、Iterator接口，并且Iterator接口没有add方法
 */
import java.util.*;

public class LinkedListTest {
    public static void main(String[] args)
    {
        var a = new LinkedList<String>();
        a.add("Amy");
        a.add("Carl");
        a.add("Erica");

        var b = new LinkedList<String>();
        b.add("Bob");
        b.add("Doug");
        b.add("France");
        b.add("Gloria");
        //Iterator接口没有add方法，,ListIterator接口有
        ListIterator<String> aIter = a.listIterator();
        Iterator<String> bIter = b.iterator();
        //将b元素分别间隔插入a中，合并
        while (bIter.hasNext())
        {
            if (aIter.hasNext()) aIter.next();
            aIter.add(bIter.next());
        }

        System.out.println(a);
        //将b的元素间隔删除
        bIter = b.iterator();
        while (bIter.hasNext())
        {
            bIter.next();
            if (bIter.hasNext())
            {
                bIter.next();
                bIter.remove();
            }
        }

        System.out.println(b);
        //去除b中元素剩下a中的元素
        a.removeAll(b);
        System.out.println(a);
    }
}
