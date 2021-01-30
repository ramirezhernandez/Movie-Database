package com.company;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class mymovieDAO {
    private Connection con;

    public mymovieDAO(Connection con) {
        this.con = con;
        try {
            PreparedStatement st = con.prepareStatement("USE mymovies");
            st.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public mymovieDAO() {

    }

    public List<mymovie> getAll() {
        List<mymovie> movies = new ArrayList<>();
        try {
            PreparedStatement st = con.prepareStatement("SELECT * FROM mymovies.mymovie;");
            ResultSet resultSet = st.executeQuery();
            while (resultSet.next()) {
                movies.add(new mymovie(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3), resultSet.getString(4), resultSet.getInt(5)));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return movies;
    }

    public void delete(String title) {
        try {
            PreparedStatement st = con.prepareStatement("DELETE FROM mymovies.mymovie WHERE title = ? LIMIT 1;");
            st.setString(1,title);
            st.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void addMovie(mymovie mymovie) {
        try {
            PreparedStatement statement = con.prepareStatement("INSERT INTO mymovie (movie_id,title,genre,director,release_year) VALUES (?,?,?,?,?);");
            setInfo(statement, mymovie);
            statement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void setInfo(PreparedStatement statement, mymovie mymovie) {
        try {
            statement.setInt(1, mymovie.getMovie_id());
            statement.setString(2, mymovie.getTitle());
            statement.setString(3, mymovie.getGenre());
            statement.setString(4, mymovie.getDirector());
            statement.setInt(5, mymovie.getRelease_year());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<mymovie> searchmovies(mymovie mymovie ) {
        List<mymovie> mymovieas = new ArrayList<>();
       try {
           PreparedStatement statement = con.prepareStatement("SELECT * FROM mymovies.mymovie WHERE title = ? AND movie_id = ? AND genre = ? AND director = ? AND release_year = ?");
           setInfo(statement,mymovie);
           ResultSet res = statement.executeQuery();
           while (res.next()){
               mymovieas.add(new mymovie(res.getInt(1), res.getString(2), res.getString(3), res.getString(4), res.getInt(5)));
           }
       } catch (SQLException e) {
           e.printStackTrace();
       }
     return mymovieas;

    }
    private mymovie odlornor(boolean old) {
        try {
            String s = "SELECT * FROM mymovies.mymovie  ORDER BY release_year";
            if (old) {
                s += " DESC";
            }
            PreparedStatement st = con.prepareStatement(s);
            ResultSet res = st.executeQuery();
            res.next();
            return new mymovie(res.getInt(1), res.getString(2), res.getString(3), res.getString(4), res.getInt(5));

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    public mymovie oldest(){
        return odlornor(true);
    }
    public mymovie newest(){
        return odlornor(false);
    }

    public mymovie searchbygenre( String genre){
        try {
            PreparedStatement st = con.prepareStatement("SELECT * FROM mymovies.mymovie WHERE genre = ?");
            st.setString(1,genre);
            ResultSet res = st.executeQuery();
            while (res.next()){
                return new mymovie(res.getInt(1), res.getString(2), res.getString(3), res.getString(4), res.getInt(5));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
           return null;
    }

}
