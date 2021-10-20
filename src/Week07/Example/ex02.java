package Week07.Example;

class Point02 {
    int x, y;

    public Point02(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public String toString() {
        return "Point02(" + x + "," + y + ")";
    }
}

public class ex02 {
    public static void main(String[] args) {
        Point02 p = new Point02(2, 3);
        System.out.println(p.toString());
        System.out.println(p); // p는 p.toString()으로 자동 변환
        System.out.println(p + "입니다."); // p.toString() + "입니다"로 자동 변환
    }
}