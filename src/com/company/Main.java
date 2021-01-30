package com.company;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class Main {

    public static void main(String[] args) throws SQLException {
        System.out.println("chek");
        data data = new data();
        MVCmodel cmodel = new MVCmodel(data);
        MVCview mvCview = new MVCview();
        MVCcontroller controller = new MVCcontroller(cmodel,mvCview);
        mymovie m = new mymovie(1,"da","af","fa0",1990);


    }

}
