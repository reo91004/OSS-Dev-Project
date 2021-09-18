package Week03;

public class Prac10 {
    public static void main(String[] args) {
        int arr[][] = new int[4][4];
        int x, y, count = 0;

        while (count < 10) {
            x = (int) (Math.random() * 4);
            y = (int) (Math.random() * 4);

            if (arr[x][y] == 0) {
                arr[x][y] = (int) (Math.random() * 10 + 1);
                count++;
            }
        }

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print(arr[i][j] + " ");
            }

            System.out.println();
        }

    }
}
