package com.company;

public class mymovie {
    int movie_id;
    String title;
    String genre;
    String director;
    int release_year;

    public mymovie(int movie_id, String title, String genre, String director, int release_year) {
        this.movie_id = movie_id;
        this.title = title;
        this.genre = genre;
        this.director = director;
        this.release_year = release_year;
    }

    @Override
    public String toString() {
        return "mymovie{" +
                "movie_id=" + movie_id +
                ", title='" + title + '\'' +
                ", genre='" + genre + '\'' +
                ", director='" + director + '\'' +
                ", release_year=" + release_year +
                '}';
    }

    public int getMovie_id() {
        return movie_id;
    }

    public void setMovie_id(int movie_id) {
        this.movie_id = movie_id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public int getRelease_year() {
        return release_year;
    }

    public void setRelease_year(int release_year) {
        this.release_year = release_year;
    }
    public String[] getInfoForRow() {
        String[] ram = new String[5];
        ram[0] = Integer.toString(movie_id);
        ram[1] = title;
        ram[2] = genre;
        ram[3] = director;
        ram[4] = Integer.toString(release_year);
        return ram;
    }
}
