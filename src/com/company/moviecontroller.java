package com.company;
import java.awt.FileDialog;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class moviecontroller extends WindowAdapter  {

    private mainFrame mf;
    private movieDAO m_dao;

    public moviecontroller(mainFrame mf) {
        this.mf = mf;
        m_dao = movieDAO.getInstance();
        setAllNamecard(); // 테이블에 데이터를 추가한다.
        //imagePath = "";
    }


    private void setAllNamecard() {
        try {
            List<movieDTO> list = m_dao.selectallmovie();

            Object[] rowData = null;
            movieDTO tempDTO = null;
            for(int i=0; i<list.size(); i++) { // 조회된 레코드 수만큼 반복
                tempDTO = list.get(i);
                rowData = new Object[]{
                                tempDTO.getName(),
                                tempDTO.getAddr()
                        };
                mf.getDtmNamecard().addRow(rowData);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(mf, "ㅈㅅ!");
            e.printStackTrace();
        }
    }
}
