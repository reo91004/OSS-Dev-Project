package Week03;

public class Prac02 {
    public static void main(String[] args) {
        int n[][] = {{1}, {1,2,3}, {1}, {1,2,3,4}, {1,2}};

        int len = n.length; // for문을 돌때마다 n.length 함수가 실행되면 알고리즘 시간적으로 손해이므로 미리 지정

        for (int i=0; i<len; i++)
        {
            for (int j=0; j<n[i].length; j++)
                System.out.print(n[i][j] + " ");
            System.out.println();
        }
    }
}
