package Week10_2;

import javax.swing.*;
import java.awt.*;

public class Prac04 extends JFrame {
    public Prac04() {
        Color[] color = {Color.RED, Color.ORANGE, Color.YELLOW,
                Color.GREEN, Color.CYAN, Color.BLUE, Color.MAGENTA,
                Color.GRAY, Color.PINK, Color.LIGHT_GRAY};

        Container c = getContentPane();
        c.setLayout(new GridLayout(1, 10));

        for (int i = 0; i < 10; i++) {
            String text = Integer.toString(i);
            JButton b = new JButton(text);
            b.setOpaque(true);
            b.setBackground(color[i]);
            c.add(b);
        }

        setTitle("Prac04");
        setSize(600, 300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }

    public static void main(String[] args) {
        Prac04 start = new Prac04();
    }
}
