package Week03;

import java.util.Scanner;

public class Prac14 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String course[] = { "Java", "C++", "HTML5", "컴퓨터구조", "안드로이드" };
        int score[] = { 95, 88, 76, 62, 55 };
        String name = "";
        int len = course.length;
        int count = 0;

        while (true) {
            System.out.print("과목 이름>>");
            name = sc.next();

            if (name.equals("그만"))
                break;

            for (int i = 0; i < len; i++) {
                if (course[i].equals(name)) {
                    System.out.println(course[i] + "의 점수는 " + score[i]);
                    break;
                } else
                    count++;
            }

            if (count == 5) {
                System.out.println("없는 과목입니다.");
                count = 0;
            }
        }

        sc.close();
    }
}
