package Week07;

import java.util.Scanner;

public class Prac08 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("문자열을 입력하세요. 빈칸이나 있어도 되고 영어 한글 모두 됩니다.");
        
        String sentence = sc.nextLine(); // 문자열 입력받음

        for (int i = 1; i <= sentence.length(); i++) 
        {
            System.out.print(sentence.substring(i)); // i부터 출력
            System.out.println(sentence.substring(0, i)); // 0~i 전까지 출력
        }

        sc.close();
    }
}
