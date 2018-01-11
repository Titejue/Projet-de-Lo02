package fr.utt.lo02;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;

public class Carte {

    private ValeurCarte valeur ;
    private CouleurCarte couleur ;
    private JLabel image;


// ------------------------------- CONSTRUCTEUR -------------------------------------------------------------

    public Carte(ValeurCarte num, CouleurCarte type) {
        this.valeur = num ;
        this.couleur = type ;
        //System.out.println("src/Images/" + this.getValeur().getNumero() + "_" + this.couleur.getName() + ".png");
        //this.image = new JLabel(new ImageIcon(new ImageIcon("src/Images/" + this.getValeur().getNumero() + "_" + this.couleur.getName() + ".png").getImage().getScaledInstance(75, 100, Image.SCALE_DEFAULT)));
        this.image = new ImageCarte("src/Images/" + this.getValeur().getNumero() + "_" + this.couleur.getName() + ".png", this);
        this.image.setOpaque(true);

    }
    public Carte(ValeurCarte num) {
        this.valeur = num ;
        this.image = new ImageCarte("src/Images/joker_1.png", this);


    }
    public Carte(CouleurCarte coul){
        this.couleur = coul ;
    }
    public Carte() {}


    // ------------------------------- GETTER ET SETTER -------------------------------------------------------------

    ValeurCarte getValeur() {
        return this.valeur;
    }


    public JLabel getImage() {
        return image;
    }

    void setValeur(ValeurCarte numero) {
        this.valeur = numero;
    }

    CouleurCarte getCouleur() {
        return this.couleur;
    }

    void setCouleur(CouleurCarte type) {
        this.couleur = type;
    }

    // Connaitre la carte (valeur et couleur)
    public String toString() {
        String s ;
        if (this.getValeur() == ValeurCarte.Joker){
            s = "" + this.valeur+ "" ;
        }
        else {
            s = "" + this.getValeur() + " de " + this.getCouleur() + "" ;
        }
        return s ;
    }
}

