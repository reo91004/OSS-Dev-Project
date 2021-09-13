package Week02.Example;

public class ex01 {
    public static int sum(int n, int m) {
        return n + m;
    }

    public static void main(String[] args) {
        int i = 20;
        int s;
        char a;

        s = sum(i, 10); // sum() 메소드 호출
        a = '?';
        
        System.out.println(a); // 문자 '?' 화면 출력
        System.out.println("Hello"); // "Hello" 문자열 화면 출력
        System.out.println(s); // 정수 s 값 화면 출력
    }
}
    