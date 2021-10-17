package Week07.Prac04.app;

import Week07.Prac04.base.Shape;
import Week07.Prac04.derived.Circle;

public class GraphicEditor {
	public static void main(String[] args) {
		Shape shape = new Circle();
		shape.draw();
	}
}