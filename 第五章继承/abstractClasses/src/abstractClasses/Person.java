package abstractClasses;
//构建抽象类，当抽象子类都定义了getDescription时，抽象超类不可以省略了，需要了解接口
//并且抽象类不能构造对象，所以调用e不会引用Person对象而是会引用子类
public abstract  class Person {
    public abstract String getDescription();
    private String name;
//构造器
    public Person(String name)
    {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
