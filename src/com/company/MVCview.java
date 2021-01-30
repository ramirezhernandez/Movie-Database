package com.company;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class MVCview {
    private JFrame frame;
    private JPanel mainpanel;
    private JTable table,table2;
    private MyButton add, delete, getAll, search, oldest, newest;
    private JComboBox pop, match;
    private JTextField movie_id, title, genre, director, release_year;
    private Firelistener firelistener;

    public void setFirelistener(Firelistener firelistener) {
        this.firelistener = firelistener;
    }

    public MVCview() {
        init();
        start();
        setTable();
        setButtons();
        setuptextfields();


    }

    public void init() {
        frame = new JFrame();
        frame.setTitle("my movies");
        frame.setSize(800, 600);
        mainpanel = new JPanel(new BorderLayout());
        frame.add(mainpanel);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        frame.addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent windowEvent) {

                firelistener.fireconnectionclose();
                System.exit(0);
            }


        });
    }

    public void start() {
        frame.setVisible(true);
    }

    public void setTable() {

        String[] collnames = {"movie_id", "title", "genre", "director", "release_year"};
        DefaultTableModel model = new DefaultTableModel();
        model.setColumnCount(5);
        model.setColumnIdentifiers(collnames);
        table = new JTable(model);
        mainpanel.add(new JScrollPane(table),BorderLayout.WEST);


    }

    public void setButtons() {
        JPanel buttonpanel = new JPanel(new GridLayout(3, 2));
        JPanel buttonpanel1 = new JPanel(new GridLayout(1, 2));
        JPanel buttonpanel2 = new JPanel(new GridLayout(1, 2));
        JPanel buttonpanel3 = new JPanel(new GridLayout(1, 2));
        add = new MyButton("add");
        delete = new MyButton("delete");
        getAll = new MyButton("getall");
        oldest = new MyButton("oldest");
        newest = new MyButton("newest");
        search = new MyButton("search");
        buttonpanel1.add(add);
        buttonpanel1.add(delete);
        buttonpanel2.add(getAll);
        buttonpanel2.add(search);
        buttonpanel3.add(oldest);
        buttonpanel3.add(newest);
        buttonpanel.add(buttonpanel1);
        buttonpanel.add(buttonpanel2);
        buttonpanel.add(buttonpanel3);
        mainpanel.add(buttonpanel);
        getAll.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                firelistener.fireGetallButton();
            }
        });
        add.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int num = getIntSafely();
                int num1 = getIntSafelyy();
                firelistener.fireAddButton(new mymovie(num, title.getText(), genre.getText(), director.getText(), num1));
                setTextsEmpty();
            }
        });
        delete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                firelistener.fireDeleteButton(title.getText());
            }
        });
        search.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                firelistener.searchbygenre(genre.getText());
            }
        });
        newest.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                firelistener.oldest();
            }
        });
        oldest.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                firelistener.newest();
            }
        });
    }

    public void setuptextfields() {
        JPanel textpanel = new JPanel();
        textpanel.setLayout(new GridLayout(1, 10, 10, 5));
        JLabel idlabel = new JLabel("movie_id:");
        textpanel.add(idlabel);
        movie_id = new JTextField();
        textpanel.add(movie_id);
        JLabel titlelabel = new JLabel("title:");
        textpanel.add(titlelabel);
        title = new JTextField();
        textpanel.add(title);
        JLabel genrelabel = new JLabel("genre:");
        textpanel.add(genrelabel);
        genre = new JTextField();
        textpanel.add(genre);
        JLabel drlabel = new JLabel("director:");
        textpanel.add(drlabel);
        director = new JTextField();
        textpanel.add(director);
        JLabel rllabel = new JLabel("release year:");
        textpanel.add(rllabel);
        release_year = new JTextField();
        textpanel.add(release_year);
        mainpanel.add(textpanel, BorderLayout.NORTH);
    }

    public void changeTable(List<mymovie> mymovieList) {
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        for (mymovie mymoviee : mymovieList) {
            model.addRow(mymoviee.getInfoForRow());
        }

    }

    public void clearTable() {
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        while (model.getRowCount() >= 1) model.removeRow(0);
    }

    private int getIntSafely() {
        int num = 0;
        try {
            num = Integer.parseInt(movie_id.getText());
        } catch (NumberFormatException n) {
            System.out.println("parse problem");
        }
        return num;
    }

    private int getIntSafelyy() {
        int num = 0;
        try {
            num = Integer.parseInt(release_year.getText());
        } catch (NumberFormatException n) {
            System.out.println("parse problem");
        }
        return num;
    }

    private void setTextsEmpty() {
        movie_id.setText("");
        title.setText("");
        genre.setText("");
        director.setText("");
        release_year.setText("");

    }
}

