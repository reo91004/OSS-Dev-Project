package Week10_1;

import java.io.*;

public class Prac02 {
    public static void main(String[] args) {
        FileReader fr = null;
        File f = new File("C:\\temp\\phone.txt");
        try {
            fr = new FileReader(f);
            int c;
            while ((c = fr.read()) != -1) {
                System.out.print((char) c);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
