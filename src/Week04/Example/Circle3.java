package Week04.Example;

public class Circle3 {
    int radius;
    String name;

    public Circle3() { // 매개 변수 없는 생성자
        radius = 1;
        name = ""; // radius의 초기값은 1
    }

    public Circle3(int r, String n) { // 매개 변수를 가진 생성자
        radius = r;
        name = n;
    }

    public double getArea() {
        return 3.14 * radius * radius;
    }

    public static void main(String[] args) {
        Circle3 pizza = new Circle3(10, "자바피자"); // Circle3 객체 생성, 반지름 10
        double area = pizza.getArea();

        System.out.println(pizza.name + "의 면적은 " + area);
        Circle3 donut = new Circle3();

        donut.name = "도넛피자";
        area = donut.getArea();
        System.out.println(donut.name + "의 면적은 " + area);
    }
}
