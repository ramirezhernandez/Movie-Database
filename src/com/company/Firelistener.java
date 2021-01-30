package com.company;

public interface Firelistener {
    void fireAddButton(mymovie mymovie);
    void fireGetallButton();
    void fireDeleteButton(String title);
    void oldest();
    void newest();
    void searchbygenre(String genre);
    void fireconnectionclose();
}
