package fr.utt.lo02;

import javax.swing.*;
import java.util.LinkedList;
import java.util.Random;
import java.util.Scanner;

import GUI.* ;
import vuetexte.VueTexte;

public class Main {

    public static void main(String[] args) {

        //FenetreJeu fen = new FenetreJeu() ;


        /**
         * Il va falloir importer le package "GUI" et permettre au joueur de choisir entre la partie "terminale"
         * et la partie dans le GUI.
         * En gros reprendre la classe "Partie" du package fr.utt.lo02
         * la copier dans GUI
         * et la modifier pour que ce qui s'affiche en println soit affiché en interface sur un JPanel par exemple.
         */

        /*PanneauMenu t = new PanneauMenu();

        t.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        t.pack();
        t.setVisible(true);*/

        VueTexte vt = new VueTexte();
        Partie partie = Partie.getInstance();

        Partie.getInstance().lancerPartie();





        //Test t = new Test();
//        System.out.println("Une partie va se démarrer");




    }













}
