package pair1;
/*
定义简单的泛型类
泛型类可以有多个类型变量
 */
public class Pair<T> {
    private T first;
    private T second;

    public Pair()
    {first = null ; second = null;}

    public Pair(T first , T second)     //类型变量
    {this.first = first ; this.second = second;}

    public T getFirst() {
        return first;
    }
    public T getSecond() {
        return second;
    }

    public void setFirst(T newValue) {
        first = newValue;
    }

    public void setSecond(T newValue) {
        second = newValue;
    }
}
