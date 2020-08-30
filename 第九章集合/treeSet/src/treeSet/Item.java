package treeSet;
import java.util.*;
//Item类实现了Comparable接口,要重新改写compareTo方法
public class Item implements Comparable<Item>
{
    private String description;
    private int partNumber;
    //构造器
    public Item(String aDescription , int aPartNumber)
    {
        description = aDescription;
        partNumber = aPartNumber;
    }

    public String getDescription() {
        return description;
    }
    public String toString()
    {
        return "[description=" + description +", partNumber=" + partNumber +"]";
    }
    //完美的equals方法，参考第五章
    public boolean equals(Object otherObject)
    {
        if (this == otherObject) return true;
        if (otherObject == null) return false;
        if (getClass() != otherObject.getClass()) return false;
        var other = (Item) otherObject;
        return Objects.equals(description,other.description) && partNumber == other.partNumber;
    }

    @Override
    public int hashCode() {
        return Objects.hash(description, partNumber);
    }

    public int compareTo(Item other)
    {
        int diff = Integer.compare(partNumber, other.partNumber);
        return diff !=0 ? diff : description.compareTo(other.description);
     }
}
