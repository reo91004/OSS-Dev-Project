package Week02;

import java.util.Scanner;

public class Prac12 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        double x, z;
        String y;
        System.out.print("연산>>");
        x = sc.nextDouble();
        y = sc.next();
        z = sc.nextDouble();

        if (y.equals("+")) // 주어진 힌트
            System.out.println(x + y + z + "의 계산 결과는 " + (x + z));
        else if (y.equals("-"))
            System.out.println(x + y + z + "의 계산 결과는 " + (x - z));
        else if (y.equals("*"))
            System.out.println(x + y + z + "의 계산 결과는 " + (x * z));
        else if (y.equals("/"))
        {
            if (z == 0)
                System.out.println("0으로 나눌 수 없습니다.");
            else
                System.out.println(x + y + z + "의 계산 결과는 " + (x / z));
        }
   
        /* switch 문
        switch(y)
        {
            case "+":
                System.out.println(x + y + z + "의 계산 결과는 " + (x + z));
                break;
            case "-":
                System.out.println(x + y + z + "의 계산 결과는 " + (x - z));
                break;
            case "*":
                System.out.println(x + y + z + "의 계산 결과는 " + (x * z));
                break;
            case "/":
                if (z == 0)
                    System.out.println("0으로 나눌 수 없습니다.");
                else
                    System.out.println(x + y + z + "의 계산 결과는 " + (x / z));
        }
        */

        sc.close();
    }
}
