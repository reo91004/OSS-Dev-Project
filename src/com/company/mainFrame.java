package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

public class mainFrame extends JFrame {
    private int flag = -1;
    private DefaultTableModel dtmmovie;
    DefaultTableModel modelreset;
    public mainFrame() {
        // 배경 패널 설정
        JPanel backgroundPanel = new JPanel();
        backgroundPanel.setLayout(null);
        add(backgroundPanel);

        // 영화 목록을 보여줄 기능
        String[] columnNames = new String[] { "번호", "이미지" ,"태그1" , "태그2" , "별" ,"연도"};
        // dtmovie를 직접 수정할 수 없도록 함
        dtmmovie = new DefaultTableModel(columnNames, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        // 입력된 클래스가 그대로 column에 표현되도록 함
        JTable jtmoviecard = new JTable(dtmmovie) {
            @Override
            public Class<?> getColumnClass(int column) {
                // row - JTable에 입력된 이차원 배열의 행에 속한다면
                // 모든 컬럼의 값을 입력된 형태로 반환한다.
                return getValueAt(0, column).getClass();
            }
        };

        JScrollPane showjtmoviecard;

        jtmoviecard.setRowHeight(100); // 행 높이 조절
        jtmoviecard.getTableHeader().setReorderingAllowed(false);  // 열 이동 막기
        jtmoviecard.getTableHeader().setResizingAllowed(false); // 열 너비 변경 막기
        jtmoviecard.getColumnModel().getColumn(0).setPreferredWidth(100); // 열 너비 조절
        showjtmoviecard = new JScrollPane(jtmoviecard);
        showjtmoviecard.setPreferredSize(new Dimension(590, 490));

        // 영화 목록을 보여주는 패널
        JPanel showMovie = new JPanel();
        showMovie.setBounds(0, 0, 600, 500);
        showMovie.setBackground(Color.WHITE);
        backgroundPanel.add(showMovie);

        moviecontroller mc = new moviecontroller(this);
        showMovie.add(showjtmoviecard);

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

        // ~버튼 생성, 메뉴에 넣음

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

        // 인기순 정렬이 눌리면 flag가 1이 되도록
        menuPopularMovie.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e ) {
                flag = 1;
                modelreset= (DefaultTableModel) jtmoviecard.getModel();
                modelreset.setRowCount(0);
                moviecontroller mc = new moviecontroller(mainFrame.this);
                showMovie.add(showjtmoviecard);
            }
        });

        // 이름순 정렬이 눌리면 flag가 0이 되도록
        menuNameMovie.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                flag = 0;
                modelreset= (DefaultTableModel) jtmoviecard.getModel();
                modelreset.setRowCount(0);
                moviecontroller mc = new moviecontroller(mainFrame.this);
                showMovie.add(showjtmoviecard);
            }
        });
        // 테이블 우클릭 시 라이브러리 저장 여부 메뉴 띄우기
        jtmoviecard.addMouseListener(new MyMouseListener());

        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // 중앙에 배치
        setResizable(false);
        setTitle("영화 추천 프로그램");
        setVisible(true);
    }

    public DefaultTableModel getDtmNamecard() {
        return dtmmovie;
    }

    public int getFlag() {
        return flag;
    }

    private class MyMouseListener extends MouseAdapter {
        public void mouseClicked(MouseEvent e) {
            if (e.getButton() == 3) { // 우클릭시
                PopupMenu pm = new PopupMenu();
                MenuItem menu1 = new MenuItem("라이브러리 추가");
                MenuItem menu2 = new MenuItem("라이브러리 제거");

                pm.add(menu1);
                pm.addSeparator();
                pm.add(menu2);

                add(pm);

                JTable t = (JTable) e.getSource();
                int row = t.getSelectedRow();
                if (row != -1) { // 셀이 선택되었을 때 메뉴 보여짐
                    pm.show(mainFrame.this, e.getX(), e.getY());
                    menu1.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            try {
                                modifymyMovie temp = new modifymyMovie(String.valueOf(t.getValueAt(t.getSelectedRow(), 0)), String.valueOf(t.getValueAt(t.getSelectedRow(), 1)),
                                        String.valueOf(t.getValueAt(t.getSelectedRow(), 2)),String.valueOf(t.getValueAt(t.getSelectedRow(), 3)),
                                        String.valueOf(t.getValueAt(t.getSelectedRow(), 4)), String.valueOf(t.getValueAt(t.getSelectedRow(), 5)));
                                temp.modify();
                            } catch (SQLException s) {
                                s.printStackTrace();
                            }
                        }
                    });
                }
            }
        }
    }

    public static void main(String[] args) {
        new mainFrame();
    }
}
