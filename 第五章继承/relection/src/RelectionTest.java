import java.util.*;
import java.lang.reflect.*;

//利用反射分析类的能力
//java.lang.reflect包中有三个类Field、Method、Constructor分别描述字段、方法、构造器
//Class类中可以用getFields、getMethods、getConstructors返回公共字段。方法和构造器的数组，包括超类的公共成员
//Class类中可以用getDeclareFields、getDeclareMethods、getDeclareConstructors返回类中声明的全部字段、方法、构造器的数组

public class RelectionTest {
    public static void main(String[] args)
            throws ReflectiveOperationException     //检查是否会抛出反射异常
    {
        String name;
        if(args.length > 0 )    name = args[0];
        else
        {
            var in = new Scanner(System.in);
            System.out.println("Enter class name (e.g. java.util.Date): ");
            name = in.next();
        }

        Class cl = Class.forName(name);
        Class supercl = cl.getSuperclass();     //得到运行类的继承的父类 就是java.util.Date
        String modifiers = Modifier.toString(cl.getModifiers());
        if(modifiers.length() > 0)
            System.out.print(modifiers + " ");
        System.out.print("class " + name);
        if(supercl != null && supercl != Object.class)
            System.out.print(" extends " + supercl.getName());

        System.out.print("\n{\n");
        printConstructors(cl);
        System.out.println();
        printMethods(cl);
        System.out.println();
        printFields(cl);
        System.out.println("}");
    }
    //打印构造器列表
    public static void printConstructors(Class cl)
    {
        Constructor[] constructors = cl.getDeclaredConstructors();      //返回全部的构造器

        for (Constructor c : constructors)
        {
            String name = c.getName();
            System.out.print("   ");
            String modifiers = Modifier.toString(c.getModifiers());     //返回类型的方法
            if (modifiers.length() > 0) System.out.print(modifiers + " ");
            System.out.print(name + "(");

            Class[] paramTypes = c.getParameterTypes();     //返回一个Class对象数组，各个对象表示参数的类型
            for (int j = 0 ; j < paramTypes.length; j++)
            {
                if(j>0) System.out.print(", ");
                System.out.print(paramTypes[j].getName());
            }
            System.out.println(");");
        }
    }
    //打印方法列表
    public static void printMethods(Class cl)
    {
        Method[] methods = cl.getDeclaredMethods();     //获得全部的方法

        for (Method m : methods)
        {
            Class retType = m.getReturnType();  //返回一个表示返回类型的Class对象
            String name = m.getName();
            System.out.print("   ");
            String modifiers = Modifier.toString(m.getModifiers());
            if (modifiers.length() > 0) System.out.print(modifiers + " ");
            System.out.print(retType.getName() + " "+name + "(");

            Class[] paramTypes = m.getParameterTypes(); //返回一个Class对象数组，各个对象表示参数的类型
            for (int j = 0; j < paramTypes.length;j++)
            {
                if(j>0) System.out.print(", ");
                System.out.print(paramTypes[j].getName());
            }
            System.out.println(");");
        }
    }
    //打印全部公共字段
    public static void printFields(Class cl)
    {
        Field[] fields = cl.getDeclaredFields();

        for (Field f : fields)
        {
            Class type = f.getType();
            String name = f.getName();
            System.out.print("   ");
            String modifers = Modifier.toString((f.getModifiers()));
            if (modifers.length() > 0) System.out.print(modifers + " ");
            System.out.println(type.getName() + " " + name + ";");
        }
    }
}
