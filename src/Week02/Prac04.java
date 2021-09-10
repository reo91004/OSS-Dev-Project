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

        if (x > y && y > z || x < y && y < z)
            System.out.println("중간 값은 " + y);
        else if (y > x && x > z || y < x && x < z)
            System.out.println("중간 값은 " + x);
        else
            System.out.println("중간 값은 " + z);

        sc.close();

    }
}
