package Week03;

import java.util.Scanner;

public class Prac16 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String str[] = { "가위", "바위", "보" };
        String user, com;
        int x;

        System.out.println("컴퓨터와 가위 바위 보 게임을 합니다.");

        do {
            System.out.print("가위 바위 보!>>");
            user = sc.next();

            if (user.equals("그만"))
                break;

            x = (int) (Math.random() * 3);
            com = str[x];

            if (user.equals("가위")) {
                if (str[x].equals("가위")) {
                    System.out.println("사용자 = " + user + " , 컴퓨터 = " + com + " 비겼습니다.");
                    continue;
                } else if (str[x].equals("바위")) {
                    System.out.println("사용자 = " + user + " , 컴퓨터 = " + com + " 사용자가 졌습니다.");
                    continue;
                } else if (str[x].equals("보")) {
                    System.out.println("사용자 = " + user + " , 컴퓨터 = " + com + " 사용자가 이겼습니다.");
                    continue;
                }
            }

            else if (user.equals("바위")) {
                if (str[x].equals("가위")) {
                    System.out.println("사용자 = " + user + " , 컴퓨터 = " + com + " 사용자가 이겼습니다.");
                    continue;
                } else if (str[x].equals("바위")) {
                    System.out.println("사용자 = " + user + " , 컴퓨터 = " + com + " 비겼습니다.");
                    continue;
                } else if (str[x].equals("보")) {
                    System.out.println("사용자 = " + user + " , 컴퓨터 = " + com + " 사용자가 졌습니다.");
                    continue;
                }
            }

            else if (user.equals("보")) {
                if (str[x].equals("가위")) {
                    System.out.println("사용자 = " + user + " , 컴퓨터 = " + com + " 사용자가 졌습니다.");
                    continue;
                } else if (str[x].equals("바위")) {
                    System.out.println("사용자 = " + user + " , 컴퓨터 = " + com + " 사용자가 이겼습니다.");
                    continue;
                } else if (str[x].equals("보")) {
                    System.out.println("사용자 = " + user + " , 컴퓨터 = " + com + " 비겼습니다.");
                    continue;
                }
            }

            System.out.print("사용자 = " + user + " , 컴퓨터 = " + com + " ");

        } while (true);
        System.out.println("게임을 종료합니다...");

        sc.close();
    }
}
