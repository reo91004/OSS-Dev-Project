package com.company;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class selectFavoriteMovie extends JFrame{
    private DefaultTableModel dtmmovie;

    public selectFavoriteMovie() {
        // 배경 패널 생성
        JPanel backgroundPanel = new JPanel();
        add(backgroundPanel);
        backgroundPanel.setLayout(null);

        String[] columnNames = new String[] { "번호", "이미지" ,"태그1" , "태그2" , "별" ,"연도"};
        // dtmovie를 직접 수정할 수 없도록 함
        dtmmovie = new DefaultTableModel(columnNames, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        // 입력된 클래스가 그대로 column에 표현되도록 함
        JTable selectmovie = new JTable(dtmmovie) {
            @Override
            public Class<?> getColumnClass(int column) {
                // row - JTable에 입력된 이차원 배열의 행에 속한다면
                // 모든 컬럼의 값을 입력된 형태로 반환한다.
                return getValueAt(0, column).getClass();
            }
        };

        selectmovie.setRowHeight(100); // 행 높이 조절
        selectmovie.getTableHeader().setReorderingAllowed(false);  // 열 이동 막기
        selectmovie.getTableHeader().setResizingAllowed(false); // 열 너비 변경 막기
        selectmovie.getColumnModel().getColumn(0).setPreferredWidth(100); // 열 너비 조절
        JScrollPane showselectmovie = new JScrollPane(selectmovie);
        showselectmovie.setPreferredSize(new Dimension(500, 80));

        JButton like = new JButton("Like");
        JButton dislike = new JButton("Dislike");

        // 영화 보여줄 패널 생성
        JPanel showMovieList = new JPanel();
        showMovieList.setLayout(new BorderLayout());
        showMovieList.setBounds(0, 0, 600, 100);
        showMovieList.setBackground(Color.WHITE);
        showMovieList.add(showselectmovie, BorderLayout.CENTER);
        backgroundPanel.add(showMovieList);

        JPanel buttons = new JPanel();
        buttons.setBounds(0, 100, 600, 100);
        buttons.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));
        buttons.add(like);
        buttons.add(dislike);

        backgroundPanel.add(buttons);

        setSize(600, 180);
        setLocationRelativeTo(null); // 중앙에 배치
        setResizable(false);
        setTitle("맞춤 알고리즘 새로고침");
        setVisible(true);
    }
    public DefaultTableModel getDtmNamecard() {
        return dtmmovie;
    }
}
