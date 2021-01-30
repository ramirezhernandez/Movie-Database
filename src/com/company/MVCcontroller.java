package com.company;

import java.util.ArrayList;
import java.util.List;

public class MVCcontroller implements Firelistener{
    private MVCmodel model;
    private MVCview view;
    public MVCcontroller(MVCmodel model, MVCview view) {
        this.model = model;
        this.view = view;
        view.setFirelistener(this);
    }

    public void start(){
        view.start();
    }


    @Override
    public void fireAddButton(mymovie mymovie) {
        model.addMovie(mymovie);
    }

    @Override
    public void fireGetallButton() {
       view.clearTable();
       view.changeTable(model.getAll());
    }

    @Override
    public void fireDeleteButton(String title) {
        model.delete(title);
    }

    @Override
    public void oldest() {
       view.clearTable();
       List<mymovie> rame = new ArrayList<>();
       rame.add(model.oldest());
       view.changeTable(rame);
    }

    @Override
    public void newest() {
        view.clearTable();
        List<mymovie> rame = new ArrayList<>();
        rame.add(model.newest());
        view.changeTable(rame);
    }

    @Override
    public void searchbygenre(String genre) {
      view.clearTable();
      List<mymovie> mymovieas = new ArrayList<>();
      mymovieas.add(model.searchbygenre(genre));
      view.changeTable(mymovieas);
    }

    @Override
    public void fireconnectionclose() {
      model.closecon();
    }


}
