package objectAnalyzer;

import java.lang.reflect.AccessibleObject;      //可以设置字段的访问权限
import java.lang.reflect.Array;
import java.lang.reflect.Modifier;
import java.lang.reflect.Field;
import java.util.ArrayList;

//利用反射分析对象，返回对象的类名，所有字段名和值
public class objectAnalyzer {
    private ArrayList<Object> visited = new ArrayList<>();      //构建一个object对象的泛型数组

    public String toString(Object obj)
        throws ReflectiveOperationException     //检验是否要抛出反射异常
    {
        if(obj == null) return "null";      //
        if (visited.contains(obj)) return "...";    //contains方法 如果当前列表含有obj的话则返回true
        visited.add(obj);   //无的话则添加元素
        Class cl = obj.getClass();
        if (cl == String.class) return (String) obj;
        if(cl.isArray())
        {               //返回数组类型的class对象，并且检验指定的class类是否为基本类型
            String r = cl.getComponentType().isPrimitive() + "[]{";
            for (int i = 0; i < Array.getLength(obj);i++)
            {
                if (i > 0)  r+= ",";
                Object val = Array.get(obj, i);
                //用递归将每个值转换成字符串
                if (cl.getComponentType().isPrimitive()) r += val;
                else r += toString(val);
            }
            return r + "}";
        }

        String r = cl.getName();
        //访问该类的所有字段和所有超类的字段,递归实现，每个字段都有名字和值
        do {
            r += "[";
            Field[] fields = cl.getDeclaredFields();
            AccessibleObject.setAccessible(fields, true);   //设置一个对象数组可访问

            for (Field f : fields)
            {
                if (!Modifier.isStatic(f.getModifiers()))
                {
                    if (!r.endsWith("[")) r += ",";
                    r += f.getName() + "=";
                    Class t = f.getType();
                    Object val = f.get(obj);
                    //用递归将每个值转换成字符串
                    if (t.isPrimitive()) r += val;
                    else r += toString(val);
                }
            }
            r += "]";
            cl = cl.getSuperclass();
        }
        while(cl != null);

        return r;
    }
}
