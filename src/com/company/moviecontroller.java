package com.company;

import java.awt.event.WindowAdapter;

import java.sql.SQLException;
import java.util.List;


public class moviecontroller extends WindowAdapter  {

    private mainFrame mf;
    private movieDAO m_dao;
    private int flag;

    public moviecontroller(mainFrame mf) {
        this.mf = mf;
        flag = mf.getFlag();
        m_dao = movieDAO.getInstance();
        m_dao.getflag(flag);
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
                        tempDTO.getimage(),
                        tempDTO.gettag1(),
                        tempDTO.gettag2(),
                        tempDTO.getstar(),
                        tempDTO.getyear(),
                };
                mf.getDtmNamecard().addRow(rowData);
            }
        } catch (SQLException e) {
        }
    }
}
