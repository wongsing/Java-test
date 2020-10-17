import gameimages.Images;
import java.net.URL;
public class TestUrl {
    public static void main(String[] args) {
        URL headerURL = Images.class.getResource("/");//"/"指的是相对路径
        System.out.println(headerURL);
    }
}
