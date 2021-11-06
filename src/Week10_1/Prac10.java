package Week10_1;

import java.io.*;
import java.util.*;

public class Prac10 {
    public static void main(String[] args) {
        HashMap<String, String> contact = new HashMap<String, String>();
        File f = new File("c:\\temp\\phone.txt");
        Scanner sc = new Scanner(System.in);

        try {
            Scanner fsc = new Scanner(new FileReader(f));
            while(fsc.hasNext()) {
                String name = fsc.next();
                String number = fsc.next();
                contact.put(name, number);
            }
            fsc.close();
        }
        catch (IOException e) { // 파일을 저장할 수 없는 경우 예외
            e.printStackTrace();
        }

        while(true) {
            System.out.printf("이름>> ");
            String name = sc.next();

            if(name.equals("그만"))
                break;

            String number = contact.get(name);
            if(number == null) {
                System.out.println("찾는 이름이 없습니다.");
            }
            else {
                System.out.println(number);
            }
        }

    }
}
