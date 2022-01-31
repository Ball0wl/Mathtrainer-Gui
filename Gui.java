package com.company;

import javax.swing.*;
import java.awt.*;
import java.util.Timer;
import java.util.TimerTask;

import java.awt.event.ActionListener;

public class Gui extends JFrame {

    JPanel pnl = new JPanel();
    int ergebnis;
    int zaehler=0;
    int i=60;




    Gui() {




        JButton beginnerbtn = new JButton();
        JButton mediocrebtn = new JButton();
        JButton expertbtn = new JButton();
        JButton submit = new JButton();

        JTextArea aufgabe = new JTextArea();
        JTextField antwortField = new JTextField("",10);

        JLabel zeit = new JLabel();
        Timer timer = new Timer();



        beginnerbtn.setText("Anfänger");
        mediocrebtn.setText("Fortgeschritten");
        expertbtn.setText("Experte");
        submit.setText("Bestätigen");
        aufgabe.setText("WICHTIG:\n Nur ganze Zahlen.\n Kein Rest!\n Bitte Schwierigkeit wählen");

        beginnerbtn.addActionListener(
                e->{
                    timer.scheduleAtFixedRate(new TimerTask(){
                        int i=60;
                        public void run() {
                            zeit.setText("Zeit: "+i);
                            i--;
                            if(i<0) {
                                timer.cancel();
                                zeit.setText("Ende");
                            }
                        }
                    }, 0,1000);
                    int rnd, rnd2, op;
                    rnd=(int)(Math.random()*100)+1;
                    rnd2=(int)(Math.random()*100)+1;
                    op=(int)(Math.random()*4)+1;

                    switch(op) {
                        case 1:
                            aufgabe.setText(rnd + "+" + rnd2);
                            ergebnis=rnd+rnd2;
                            break;
                        case 2:
                            aufgabe.setText(rnd + "-" + rnd2);
                            ergebnis=rnd-rnd2;
                            break;
                        case 3:
                            rnd2=(int)(Math.random()*10)+1;
                            aufgabe.setText(rnd + "*" + rnd2);
                            ergebnis=rnd*rnd2;
                            break;
                        case 4:
                            rnd2=(int)(Math.random()*10)+1;
                            aufgabe.setText(rnd + "/" + rnd2);
                            ergebnis=rnd/rnd2;
                            break;
                    }

                }
        );


        mediocrebtn.addActionListener(
                m->{int rnd, rnd2, op;
                    timer.scheduleAtFixedRate(new TimerTask(){
                        int i=60;
                        public void run() {
                            zeit.setText("Zeit: "+i);
                            i--;
                            if(i<0) {
                                timer.cancel();
                                zeit.setText("Ende");
                            }
                        }
                    }, 0,1000);

                    rnd=(int)(Math.random()*100)+1;
                    rnd2=(int)(Math.random()*100)+1;
                    op=(int)(Math.random()*4)+1;

                    switch(op) {
                        case 1:
                            aufgabe.setText(rnd + "+" + rnd2);
                            ergebnis=rnd+rnd2;
                            break;
                        case 2:
                            aufgabe.setText(rnd + "-" + rnd2);
                            ergebnis=rnd-rnd2;
                            break;
                        case 3:
                            rnd2=(int)(Math.random()*50)+1;
                            aufgabe.setText(rnd + "*" + rnd2);
                            ergebnis=rnd*rnd2;
                            break;
                        case 4:
                            rnd2=(int)(Math.random()*50)+1;
                            aufgabe.setText(rnd + "/" + rnd2);
                            ergebnis=rnd/rnd2;
                            break;
                    }
                }
        );
        expertbtn.addActionListener(
                ex->{
                    int rnd, rnd2, op;
                    timer.scheduleAtFixedRate(new TimerTask(){
                        int i=60;
                        public void run() {
                            zeit.setText("Zeit: "+i);
                            i--;
                            if(i<0) {
                                timer.cancel();
                                zeit.setText("Ende");
                            }
                        }
                    }, 0,1000);

                    rnd=(int)(Math.random()*200)+1;
                    rnd2=(int)(Math.random()*100)+1;
                    op=(int)(Math.random()*4)+1;

                    switch(op) {
                        case 1:
                            aufgabe.setText(rnd + "+" + rnd2);
                            ergebnis=rnd+rnd2;
                            break;
                        case 2:
                            aufgabe.setText(rnd + "-" + rnd2);
                            ergebnis=rnd-rnd2;
                            break;
                        case 3:
                            rnd2=(int)(Math.random()*100)+1;
                            aufgabe.setText(rnd + "*" + rnd2);
                            ergebnis=rnd*rnd2;
                            break;
                        case 4:
                            rnd2=(int)(Math.random()*100)+1;
                            aufgabe.setText(rnd + "/" + rnd2);
                            ergebnis=rnd/rnd2;
                            break;
                    }
                }
        );
        submit.addActionListener(
                b->{
                    int erg;
                    if(!antwortField.getText().equals("")) {
                        erg = Integer.parseInt(antwortField.getText());
                    }else erg=0;
                    if(erg==ergebnis){
                        aufgabe.setText("Richtig! \ndas Ergebnis ist " + ergebnis);
                        zaehler++;
                    }else{
                        aufgabe.setText("Leider falsch!\n Das richtige Ergebnis ist " + ergebnis);
                    }
                }
        );



        beginnerbtn.setBackground(Color.green);
        beginnerbtn.setBorder(BorderFactory.createLineBorder(Color.BLACK));

        mediocrebtn.setBackground(Color.yellow);
        mediocrebtn.setBorder(BorderFactory.createLineBorder(Color.BLACK));

        expertbtn.setBackground(Color.red);
        expertbtn.setBorder(BorderFactory.createLineBorder(Color.BLACK));

        aufgabe.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        aufgabe.setEditable(false);
        antwortField.setBorder(BorderFactory.createLineBorder(Color.BLACK));



        pnl.add(beginnerbtn);
        pnl.add(mediocrebtn);
        pnl.add(expertbtn);
        pnl.add(aufgabe);
        pnl.add(antwortField);
        pnl.add(submit);
        pnl.add(zeit);


        pnl.setBounds(300,100,600,900);

        beginnerbtn.setBounds(30,150,130,30);
        mediocrebtn.setBounds(30,250,130,30);
        expertbtn.setBounds(30,350,130,30);
        aufgabe.setBounds(300,150,200,100);
        antwortField.setBounds(300,350,130,50);
        submit.setBounds(450,360,130,30);
        zeit.setBounds(400,50,130,30);


        this.add(beginnerbtn);
        this.add(mediocrebtn);
        this.add(expertbtn);

        this.add(zeit);
        this.add(aufgabe);
        this.add(antwortField);

        this.add(submit);

        this.setSize(800,600);
        this.setTitle("Mathetrainer");
        this.getRootPane().setDefaultButton(submit);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLayout(null);
        this.setVisible(true);
}
}

