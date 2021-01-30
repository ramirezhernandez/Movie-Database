package com.company;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import static org.junit.jupiter.api.Assertions.*;
@TestInstance(TestInstance.Lifecycle.PER_CLASS)

class mymovieDAOTest {
    private mymovieDAO dao;
    private data data;
    private static final int num = 12;
    @BeforeEach
    void setUp() {
        data = new data();
        dao = new mymovieDAO(data.getcon());
    }

    @Test
    void getAll() {
        assertEquals(num,dao.getAll().size());
    }
    @Test
    void addanddelteMovie() {
        int id = 16;
        int year = 2000;
        int num1 = num+1;
        dao.addMovie(new mymovie(id,"da","da","daa",year));
        assertEquals(num1,dao.getAll().size());
        dao.delete("da");
        assertEquals(12,dao.getAll().size());
    }




}