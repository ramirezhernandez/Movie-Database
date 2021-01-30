package com.company;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class MVCmodel extends mymovieDAO{
    private data data;
    public MVCmodel(data data){
        super(data.getcon());
        this.data = data;
    }

    public void closecon(){
        data.closecon();
    }
}
