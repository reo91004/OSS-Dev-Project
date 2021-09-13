package Week03;

import java.util.Scanner;

public class Prac06 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int unit[] = { 50000, 10000, 1000, 500, 100, 50, 10, 1 };

        System.out.print("금액을 입력하시오>>");
        int money = sc.nextInt();
        int len = unit.length;

        for (int i = 0; i < len; i++) 
        {
            int change = money / unit[i];

            if (change > 0)
            {
                System.out.println(unit[i] + "원 짜리 : " + change + "개");
                money = money % unit[i];
            }
        }

        sc.close();
    }
}
