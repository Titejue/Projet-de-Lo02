package fr.utt.lo02;


import java.util.LinkedList;

public class Adversaire extends Joueur {


    /**
     * On essaiera de jouer à plusieurs en local ou écran scindé
     * Pour le moment on considère des IA
     */

    public Adversaire(String nom) {
        this.nom = nom;
        this.main =  new LinkedList<Carte>() ;
    }

    public void jouer() {
    }

    // --------------------------------------- REMPLIR MAIN ------------------------------------------------

    protected void recevoirCarte(Carte carte) {
        this.main.add(carte);
    }
}
