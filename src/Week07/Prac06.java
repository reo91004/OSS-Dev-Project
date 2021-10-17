package Week07;

import java.util.Scanner;
import java.util.Calendar;

class Person {
    Scanner sc = new Scanner(System.in);
    Calendar time = Calendar.getInstance();

    private String name, temp;
    private int sec1, sec2;

    public Person(String name) {
        this.name = name;
    }

    public int enter() {
        temp = sc.nextLine();
        time = Calendar.getInstance();

        System.out.println("\t현재 초 시간 = " + time.get(Calendar.SECOND));

        return time.get(Calendar.SECOND);
    }

    public int game() {
        System.out.print(name + " 시작 <Enter>키  >>");
        sec1 = enter();
        System.out.print("10초 예상 후 <Enter>키  >>");
        sec2 = enter();

        if (sec1 < sec2)
            return sec2 - sec1;
        else
            return (60 - sec1) + sec2;
    }
}

public class Prac06 {
    public static void main(String[] args) {
        Person person1 = new Person("황기태");
        Person person2 = new Person("이재문");

        System.out.println("10초에 가까운 사람이 이기는 게임입니다.");
        int res1 = person1.game();
        int res2 = person2.game();

        if (Math.abs(res1 - 10) < Math.abs(res2 - 10))
            System.out.println("황기태의 결과 " + res1 + ", 이재문의 결과 " + res2 + ", 승자는 황기태");
        else
            System.out.println("황기태의 결과 " + res1 + ", 이재문의 결과 " + res2 + ", 승자는 이재문");
    }
}
