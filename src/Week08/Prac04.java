package Week08;

import java.util.Vector;
import java.util.Scanner;

public class Prac04 {
    public static void main(String[] args) {
        Vector<Integer> stack = new Vector<Integer>();

        Scanner sc = new Scanner(System.in);

        while (true) 
        {
            System.out.print("강수량 입력 (0 입력시 종료) >> ");
            int num = sc.nextInt();

            if (num == 0)
                break;

            stack.add(num);

            int avg = 0;

            for (int i = 0; i < stack.size(); i++) 
            {
                System.out.print(stack.get(i) + " ");
                avg += stack.get(i);
            }

            System.out.println();
            avg /= stack.size();
            
            System.out.println("현재 평균 " + avg);
        }

        sc.close();
    }
}
