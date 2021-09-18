package Week03;

import java.util.Scanner;

public class Prac08 {
    public static boolean ScanArr(int a[], int arrlen, int temp) {
        for (int i = 0; i < arrlen; i++) 
        {
            if (a[i] == temp)
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("정수 몇개?>>");
        int n = sc.nextInt();

        if (0 <= n || n > 100) 
        {
            int arr[] = new int[n];

            for (int i = 0; i < n; i++) 
            {
                int temp = (int) (Math.random() * 100 + 1);

                if (!ScanArr(arr, i, temp))
                {
                    i--;
                    continue;
                }

                arr[i] = temp;
            }

            for (int i = 1; i <= n; ++i)
            {
                System.out.print(arr[i - 1] + " ");
                if (i % 10 == 0)
                    System.out.println();
            }
        } 
        else
            System.out.print("1에서 100사이 수를 입력하세요.");

        sc.close();
    }
}
