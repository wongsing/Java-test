package gameimages;
import javax.swing.*;
import java.net.URL;
/*
Images类，专门获取游戏中所涉及的图片
吧对象添加修饰符static 则可以用类名.方法,而且调用的对象也必须是static
 */
public class Images {
    /*
    面向对象的思维 --》将图片进行封装，封装为一个对象，这样程序才能通过操控这个对象来控制图片
     */
    //将图片的路径封装成一个对象-->反射
    public static URL bodyURL = Images.class.getResource("/images/body.jpg");
    //将图片封装为程序中的一个对象；
    public static ImageIcon bodyImg = new ImageIcon(bodyURL);

    //将图片的路径封装成一个对象-->反射
    public static URL downURL = Images.class.getResource("/images/down.jpg");
    //将图片封装为程序中的一个对象；
    public static ImageIcon downImg = new ImageIcon(downURL);

    //将图片的路径封装成一个对象-->反射
    public static URL upURL = Images.class.getResource("/images/up.jpg");
    //将图片封装为程序中的一个对象；
    public static ImageIcon upImg = new ImageIcon(upURL);

    //将图片的路径封装成一个对象-->反射
    public static URL leftURL = Images.class.getResource("/images/left.jpg");
    //将图片封装为程序中的一个对象；
    public static ImageIcon leftImg = new ImageIcon(leftURL);

    //将图片的路径封装成一个对象-->反射
    public static URL rightURL = Images.class.getResource("/images/right.jpg");
    //将图片封装为程序中的一个对象；
    public static ImageIcon rightImg = new ImageIcon(rightURL);

    //将图片的路径封装成一个对象-->反射
    public static URL foodURL = Images.class.getResource("/images/food.jpg");
    //将图片封装为程序中的一个对象；
    public static ImageIcon foodImg = new ImageIcon(foodURL);

    //将图片的路径封装成一个对象-->反射
    public static URL headerURL = Images.class.getResource("/images/header.jpg");
    //将图片封装为程序中的一个对象；
    public static ImageIcon headerImg = new ImageIcon(headerURL);


}
