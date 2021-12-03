package com.company;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class movieDAO {

    private static movieDAO m_dao;
    private Connection con;
    private PreparedStatement pstmt;
    private ResultSet rs;
    private int flag;
    private movieDAO() {
    }

    public static movieDAO getInstance() {

        if (m_dao == null) {
            m_dao = new movieDAO();
        }
        return m_dao;
    }

    public void getflag(int k){
        this.flag = k;
    }


    public  List<movieDTO> selectallmovie()throws SQLException {

        List<movieDTO> list = new ArrayList<movieDTO>();

        String url = "jdbc:mysql://146.56.185.190:3306/movie";
        String userName = "root";
        String password = "password";

        con = DriverManager.getConnection(url, userName, password);

        if(flag == -1) {
            String getmoviecard =
                    "SELECT name,image,tag1,tag2,star,year FROM moviecard ORDER BY star ASC;"; //각 db 가져오기


            pstmt = con.prepareStatement(getmoviecard);
            rs = pstmt.executeQuery();
            movieDTO m_dto = null;
            while (rs.next()) {
                m_dto = new movieDTO(rs.getString("name"),
                        rs.getString("image"), rs.getString("tag1"),
                        rs.getString("tag2"), rs.getFloat("star"),
                        rs.getInt("year"));

                list.add(m_dto);
            }
        }
        else {
            if( flag == 0){ //이름순정렬
                String getmoviecard =
                        "SELECT name,image,tag1,tag2,star,year FROM moviecard ORDER BY name ASC;"; //각 db 가져오기


                pstmt = con.prepareStatement(getmoviecard);
                rs = pstmt.executeQuery();
                movieDTO m_dto = null;
                while (rs.next()) {
                    m_dto = new movieDTO(rs.getString("name"),
                            rs.getString("image"), rs.getString("tag1"),
                            rs.getString("tag2"), rs.getFloat("star"),
                            rs.getInt("year"));

                    list.add(m_dto);
                }
            }
            else if(flag == 1){ //인기순 정렬
                String getmoviecard =
                        "SELECT name,image,tag1,tag2,star,year FROM moviecard ORDER BY star ASC;"; //각 db 가져오기


                pstmt = con.prepareStatement(getmoviecard);
                rs = pstmt.executeQuery();
                movieDTO m_dto = null;
                while (rs.next()) {
                    m_dto = new movieDTO(rs.getString("name"),
                            rs.getString("image"), rs.getString("tag1"),
                            rs.getString("tag2"), rs.getFloat("star"),
                            rs.getInt("year"));

                    list.add(m_dto);
                }
            }
        }

        close();
        return list;
    }

    public void close() throws SQLException {
        if (rs != null) { rs.close(); }
        if (pstmt != null) { pstmt.close(); }
        if (con != null) { con.close(); }
    }
}


