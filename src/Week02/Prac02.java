package Week02;

import java.util.Scanner;

public class Prac02 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n, x, y;

		System.out.print("2자리 정수 입력(10~99)>>");
		n = sc.nextInt();

		x = n / 10; // n의 10의 자리;
		y = n % 10; // n의 1의 자리;

		if (x == y)
			System.out.println("YES! 10의 자리와 1의 자리가 같습니다.");
		else
			System.out.println("NO! 10의 자리와 1의 자리가 다릅니다.");

		sc.close();
	}

}
