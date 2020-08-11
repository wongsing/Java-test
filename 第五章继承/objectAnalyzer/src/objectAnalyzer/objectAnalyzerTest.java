package objectAnalyzer;

import java.util.*;

public class objectAnalyzerTest {
    public static void main(String[] args)
        throws ReflectiveOperationException
    {
        var squares = new ArrayList<Integer>();
        for(int i = 1 ; i <= 5; i++)
            squares.add(i * i);
        System.out.println(new objectAnalyzer().toString(squares));
    }
}
