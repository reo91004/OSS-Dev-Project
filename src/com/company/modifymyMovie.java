package com.company;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class modifymyMovie {
    private static myMovieDAO my_modify;
    private Connection con1;
    private PreparedStatement pstmt1;
    private ResultSet rs1;

    private String name,img,tag1,tag2,star,year;

    public modifymyMovie(String name, String img, String tag1, String tag2, String star, String year) {
        this.name = name;
        this.img = img;
        this.tag1 = tag1;
        this.tag2 = tag2;
        this.star = star;
        this.year = year;

    }
    public void modify() throws SQLException {
        String url = "jdbc:mysql://146.56.185.190:3306/myMovie?autoReconnect=true&verifyServerCertificate=false&useSSL=true";
        String userName = "root";
        String password = "password";

        con1 = DriverManager.getConnection(url, userName, password);
        String getmoviecard =
                " INSERT INTO mymovie(name, img, tag1, tag2, star, year) "
                        +  " VALUES('" + name + "','" + img + "'," + tag1 + ", SYSDATE) ";
        pstmt1 = con1.prepareStatement(getmoviecard);
        rs1 = pstmt1.executeQuery();
        Statement state = null;
        int count = 0;

        myMovieDTO my_dto = null;
        try {
            state = con1.createStatement();
            count = state.executeUpdate(getmoviecard);

            System.out.println("성공적으로 추가되었습니다.");

        } catch (SQLException e) {
            e.printStackTrace();
        }  finally {
            // DB close 필수!
            // 접속이 된 것
            try {
                if(state != null) {
                    state.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        close();
        //return count;
    }

    private void close() throws SQLException {
        if (rs1 != null) { rs1.close(); }
        if (pstmt1 != null) { pstmt1.close(); }
        if (con1 != null) { con1.close(); }
    }
}
