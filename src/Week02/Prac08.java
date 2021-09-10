package Week02;

import java.util.Scanner;

public class Prac08 {

    public static boolean inRect(int x, int y) {
        if ((x >= 100 && x <= 200) && (y >= 100 && y <= 200))
            return true;
        else
            return false;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int x1, x2, y1, y2;

        System.out.print("x1, y1을 입력하세요>>");
        x1 = sc.nextInt();
        y1 = sc.nextInt();
        System.out.print("x2, y2를 입력하세오>>");
        x2 = sc.nextInt();
        y2 = sc.nextInt();

        if (inRect(x1, y1) && inRect(x2, y2))
            System.out.println("두 사각형이 충돌합니다.");
        else
            System.out.println("두 사각형이 충돌하지 않습니다.");

        sc.close();
    }
}
