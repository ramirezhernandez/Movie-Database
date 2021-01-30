package com.company;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class data {
    Connection con;
    public data(){
        try {
            con = DriverManager.getConnection(info.HOST, info.USER, info.PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


  public  Connection getcon(){
        return con;

    }
    public void closecon(){
        try {
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


}
