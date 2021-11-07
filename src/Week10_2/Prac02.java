package Week10_2;

import javax.swing.*;
import java.awt.*;

public class Prac02 extends JFrame {
    public Prac02() {
        Container c = getContentPane();
        c.setLayout(new BorderLayout(5, 7));

        c.add(new JButton("North"), BorderLayout.NORTH);
        c.add(new JButton("West"), BorderLayout.WEST);
        c.add(new JButton("Center"), BorderLayout.CENTER);
        c.add(new JButton("East"), BorderLayout.EAST);
        c.add(new JButton("South"), BorderLayout.SOUTH);

        setTitle("Prac02");
        setSize(400, 200);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }

    public static void main(String[] args) {
        Prac02 start = new Prac02();
    }
}
