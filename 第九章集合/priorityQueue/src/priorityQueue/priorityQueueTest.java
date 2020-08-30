package priorityQueue;
/*
优先队列，先进先出，适合任务调度
 */
import java.util.*;
import java.time.*;

public class priorityQueueTest {
    public static void main(String[] args)
    {
        var pq = new PriorityQueue<LocalDate>();
        pq.add(LocalDate.of(1906,12,9));//G
        pq.add(LocalDate.of(1815,12,10));//A
        pq.add(LocalDate.of(1903,12,3));//J
        pq.add(LocalDate.of(1910,6,22));//K

        System.out.println("Iterating over elements ...");
        for (LocalDate date : pq)
            System.out.println(date);
        System.out.println("Removing elements ...");
        while(!pq.isEmpty())
            System.out.println(pq.remove());    //remove方法会将最小的元素删除,并不是有序的
    }
}
