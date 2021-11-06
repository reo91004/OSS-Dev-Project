package Week10_1;

import java.io.*;
import java.util.Scanner;

public class Prac04 {
    public static void main(String[] args) {
        try {
            Scanner fScanner = new Scanner(new FileReader("C:\\windows\\system.ini"));
            int lineNumber = 1;
            while (fScanner.hasNext()) {
                String line = fScanner.nextLine();
                System.out.printf("%4d: ", lineNumber);
                System.out.println(line);
                lineNumber++;
            }
        }
        catch (IOException e) {
            System.out.printf("잘못 입력");
        }
    }
}
