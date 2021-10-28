package Week08;

import java.util.*;

abstract class Shape {
    public Shape next;

    public Shape() {
        next = null;
    }

    public void draw() {
        System.out.println("Shape");
    }
}

class Line extends Shape {
    public void draw() {
        System.out.println("Line");
    }
}

class Rect extends Shape {
    public void draw() {
        System.out.println("Rect");
    }
}

class Circle extends Shape {
    public void draw() {
        System.out.println("Circle");
    }
}

public class Prac10 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean state = true;

        Vector<Shape> v = new Vector<Shape>();

        System.out.println("그래픽 에디터 beauty을 실행합니다.");
        
        while (state) 
        {
            System.out.print("삽입(1), 삭제(2), 모두보기(3), 종료(4) >> ");
            int select = sc.nextInt();

            switch (select) 
            {
                case 1:
                    System.out.print("Line(1), Rect(2), Circle(3)>> ");
                    int num1 = sc.nextInt();
                    if (num1 == 1) 
                        v.add(new Line());
                    else if (num1 == 2)
                        v.add(new Rect());
                    else if (num1 == 3)
                        v.add(new Circle());
                    else
                        System.out.println("잘못입력했습니다.");
                    break;
                case 2:
                    System.out.print("삭제할 도형의 위치>> ");
                    int pos = sc.nextInt();
                    if (pos < 0 || pos >= v.size())
                        System.out.println("삭제할 수 없습니다.");
                    else
                        v.remove(pos);
                    break;
                case 3:
                    for (int i = 0; i < v.size(); i++) 
                    {
                        Shape shape = v.get(i);
                        shape.draw();
                    }
                    break;
                case 4:
                    state = false;
                    break;
                default:
                    System.out.println("잘못입력했습니다.");
                    break;
            }
        }

        System.out.println("beauty을 종료합니다.");
        
        sc.close();
    }
}