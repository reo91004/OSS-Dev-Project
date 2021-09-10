package Week02;

import java.util.Scanner;

public class Prac04 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int x, y, z;

        System.out.printf("정수 3개 입력>>");

        x = sc.nextInt();
        y = sc.nextInt();
        z = sc.nextInt();

        if (x > y && y > z || x < y && y < z) // 중간값 찾는 과정, y가 중간값
            System.out.println("중간 값은 " + y);
        else if (y > x && x > z || y < x && x < z) // x가 중간값
            System.out.println("중간 값은 " + x);
        else // 둘다 아니면 z가 중간값
            System.out.println("중간 값은 " + z);

        sc.close();

    }
}
