package Week02;

import java.util.Scanner;

public class Prac06 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int num, x, y;

        System.out.print("1~99 사이의 정수를 입력하시오>>");

        num = sc.nextInt();
        x = num / 10; // 10의 자리
        y = num % 10; // 1의 자리

        System.out.print("박수");
        if (x % 3 == 0) // 3으로 나누어지는 3, 6, 9가 0이면 짝소리가 나도록
            System.out.print("짝");

        if (y == 0) // 1의 자리가 0이면 짝 소리가 안나도록 함
        { 
        } 
        else if (y % 3 == 0)
            System.out.print("짝");

        sc.close();
    }
}