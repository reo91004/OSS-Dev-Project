package Week06;

import java.util.Scanner;

// 다시 공부해보기

abstract class Shape {
    private Shape next;

    public Shape() {
        next = null;
    }

    public void setNext(Shape obj) {
        next = obj;
    } // 링크 연결

    public Shape getNext() {
        return next;
    }

    public abstract void draw();
}

class Line extends Shape {
    String name = "line";

    public void draw() {
        System.out.println("Line");
    }
}

class Rect extends Shape {
    String name = "Rect";

    public void draw() {
        System.out.println("Rect");
    }
}

class Circle extends Shape {
    String name = "Circle";

    public void draw() {
        System.out.println("Circle");
    }
}

class GraphicEditor {
    private Shape head, tail;
    private Scanner sc = new Scanner(System.in);

    GraphicEditor() {
        head = null;
        tail = null;
    }

    public void insert() {
        System.out.print("Line(1), Rect(2), Circle(3)>>");
        int var = sc.nextInt();

        switch (var) {
            case 1:
                if (head == null) {
                    Shape temp = new Line();
                    head = temp;
                    tail = temp;
                } else {
                    Shape temp = new Line();
                    tail.setNext(temp);
                    tail = temp;
                }
                break;
            case 2:
                if (head == null) {
                    Shape temp = new Rect();
                    head = temp;
                    tail = temp;
                } else {
                    Shape temp = new Rect();
                    tail.setNext(temp);
                    tail = temp;
                }
                break;
            case 3:
                if (head == null) {
                    Shape temp = new Circle();
                    head = temp;
                    tail = temp;
                } else {
                    Shape temp = new Circle();
                    tail.setNext(temp);
                    tail = temp;
                }
                break;
        }
    }

    public void delete() {
        Shape cur = head;
        Shape tmp = head;
        int i;

        System.out.print("삭제할 도형의 위치 >> ");
        int var = sc.nextInt();

        if (var == 1) {
            if (head == tail) {
                head = null;
                tail = null;
                return;
            } else { 
                head = head.getNext();
                return;
            }
        }
        for (i = 1; i < var; i++) {
            tmp = cur; 
            cur = cur.getNext();
            if (cur == null) {
                System.out.println("삭제할 수 없습니다.");
                return;
            }
        }
        if (i == var) {
            tmp.setNext(cur.getNext());
            tail = tmp;
        } else
            tmp.setNext(cur.getNext());
    }

    public void printAll() {
        Shape pre = head;

        while (pre != null) {
            pre.draw();
            pre = pre.getNext();
        }
    }

    public void run() {
        System.out.println("그래픽 에디터 beauty를 실행합니다.");

        while (true) {
            System.out.print("삽입(1), 삭제(2), 모두 보기(3), 종료(4)>>");
            int var = sc.nextInt();

            switch (var) {
                case 1:
                    insert();
                    break;
                case 2:
                    delete();
                    break;
                case 3:
                    printAll();
                    break;
                case 4:
                    System.out.println("beauty을 종료합니다.");
                    sc.close();
                    return;
            }
        }
    }
}

public class Prac12 {
    public static void main(String[] args) {
        GraphicEditor editor = new GraphicEditor();
        editor.run();
    }
}