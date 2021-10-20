package Week07.Prac12;

import java.util.Scanner;

class Person {
    private int n1, n2, n3;
    public String name;

    public Person(String name) {
        this.name = name;
    }

    public boolean game() {
        n1 = (int) ((Math.random() * 3) + 1);
        n2 = (int) ((Math.random() * 3) + 1);
        n3 = (int) ((Math.random() * 3) + 1);
        System.out.print("\t" + n1 + "  " + n2 + "  " + n3 + "  ");

        if (n1 == n2 && n2 == n3)
            return true;
        else
            return false;
    }
}

public class Gamble2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String name, temp;
        int num;

        System.out.print("겜블링 게임에 참여할 선수 숫자>>");
        num = sc.nextInt();

        Person person[] = new Person[num];

        for (int i = 0; i < num; i++) {
            System.out.print((i + 1) + "번째 선수 이름>>");
            name = sc.next();
            person[i] = new Person(name);
        }

        temp = sc.nextLine(); // 버퍼 지우기

        while (true) {
            for (int i = 0; i < num; i++) {
                System.out.print("[" + person[i].name + "]:<Enter>");
                temp = sc.nextLine();

                if (person[i].game()) {
                    System.out.println(person[i].name + "님이 이겼습니다!");
                    sc.close();
                    return;
                }

                System.out.println("아쉽군요!");
            }

        }
    }
}