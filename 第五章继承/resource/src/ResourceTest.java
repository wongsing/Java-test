import java.io.*;
import java.net.*;
import java.nio.charset.*;
import javax.swing.*;

public class ResourceTest {
    public static void main(String[] args) throws IOException
    {
        Class cl = ResourceTest.class;
 //       URL aboutURL = cl.getResource("src/test.JPG");
        var icon = new ImageIcon("src/test.JPG");

        InputStream stream = cl.getResourceAsStream("src/test.txt");
        var about = new String(stream.readAllBytes(),"UTF-8");

        InputStream stream2 = cl.getResourceAsStream("test1.txt");
        var title = new String(stream2.readAllBytes(),StandardCharsets.UTF_8).trim();

        JOptionPane.showMessageDialog(null,about,title,JOptionPane.INFORMATION_MESSAGE,icon);
    }

}

