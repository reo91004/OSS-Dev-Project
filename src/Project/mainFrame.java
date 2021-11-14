package Project;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class mainFrame extends JFrame {
    public mainFrame() {
        // 배경 패널 설정
        JPanel backgroundPanel = new JPanel();
        add(backgroundPanel);
        backgroundPanel.setLayout(null);

        // 영화를 보여줄 패널 설정
        JPanel showMovie = new JPanel();
        showMovie.setBounds(0, 0, 600, 500);
        showMovie.setBackground(Color.WHITE);
        backgroundPanel.add(showMovie);

        // 메뉴를 보여줄 패널 설정
        JPanel showMenu = new JPanel();
        showMenu.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 30));
        showMenu.setBounds(600, 0, 180, 400);
        backgroundPanel.add(showMenu);

        // 버튼 생성, 메뉴에 넣도록 함
        // 선호하는 장르를 선택하도록 하는 버튼도 있어야 함
        JButton menuPopularMovie = new JButton("인기순 정렬");
        JButton menuNameMovie = new JButton("이름순 정렬");
        JButton menuRecommendMovie = new JButton("맞춤 추천");
        JButton menuMyMovie = new JButton("내 라이브러리");
        JButton menuReAi = new JButton("맞춤 알고리즘 새로고침");

        menuPopularMovie.setPreferredSize(new Dimension(120, 40));
        menuNameMovie.setPreferredSize(new Dimension(120, 40));
        menuRecommendMovie.setPreferredSize(new Dimension(120, 40));
        menuMyMovie.setBounds(630, 400, 120, 40);
        menuReAi.setBounds(630, 460, 120, 40);

        showMenu.add(menuPopularMovie);
        showMenu.add(menuNameMovie);
        showMenu.add(menuRecommendMovie);
        backgroundPanel.add(menuMyMovie);
        backgroundPanel.add(menuReAi);

        menuMyMovie.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new myMovie();
                dispose();
            }
        });

        menuReAi.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new selectFavoriteMovie();
            }
        });

        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // 중앙에 배치
        setResizable(false);
        setTitle("영화 추천 프로그램");
        setVisible(true);
    }

    public static void main(String[] args) {
        new mainFrame();
    }
}
