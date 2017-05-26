import  org.junit.Test;

import java.io.*;
import java.util.Scanner;

import static org.junit.Assert.*;
public class TransposeTest {
    private Transpose transposeTest1 = new Transpose(0, false, false);
    private Transpose TransposeTest2 = new Transpose(0, false, false);

    private void example2()throws IOException{
//        transposeTest1.transpose( new Scanner("A B C\nD E"),new PrintWriter(new BufferedOutputStream((System.out))));
//        transposeTest1.transpose( new Scanner(new File("iFile.txt")),new PrintWriter(new FileOutputStream("oFile.txt")));
    }


    @Test
    public void example() throws IOException{
        example2();
//        assertEquals("A D\nB E\n C", transposeTest1.transpose( new Scanner("A B C\nD E"),new PrintWriter(new BufferedOutputStream((System.out)))));

//        assertEquals("123 54\n431 124\n86 55", transposeTest1.transpose( new Scanner(new File("files/iFile.txt")),new PrintWriter(new FileOutputStream("files/oFile.txt"))));
    }

}
