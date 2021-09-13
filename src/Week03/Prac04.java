package Week03;

import java.util.Scanner;

public class Prac04 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("소문자 알파벳 하나를 입력하시오>>");
        String s = sc.next();
        char c = s.charAt(0);

        for (char i = c; i >= 'a'; i--)  // 처음에 받은 알파벳으로 시작
        {
            for (char j = 'a'; j <= i; j++) // 위에 받은 i로 for문 시작
                System.out.print(j);
            System.out.println();
        }

        sc.close();
    }
}
