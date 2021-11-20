package com.company;

import javax.swing.*;
import java.awt.*;

public class selectFavoriteMovie extends JFrame{
    public selectFavoriteMovie() {
        // 배경 패널 생성
        JPanel backgroundPanel = new JPanel();
        add(backgroundPanel);
        backgroundPanel.setLayout(null);

        // 영화 5개씩 보여줄 패널 생성
        JPanel showMovieList = new JPanel();
        showMovieList.setBounds(0, 0, 700, 300);
        showMovieList.setBackground(Color.WHITE);
        backgroundPanel.add(showMovieList);

        setSize(700, 400);
        setLocationRelativeTo(null); // 중앙에 배치
        setResizable(false);
        setTitle("맞춤 알고리즘 새로고침");
        setVisible(true);
    }
}
