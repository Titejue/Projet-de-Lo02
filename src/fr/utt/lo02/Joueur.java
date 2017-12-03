package fr.utt.lo02;

import java.util.LinkedList;

public abstract class Joueur {

    //Nom du joueur
    protected String nom;

    protected LinkedList<Carte> main ;
    protected LinkedList<Carte> cartesJouable ;
    protected int numCarte ;
    protected CouleurCarte couleurCarte ;
    protected Carte carteChoisie ;
    protected Carte carteAJouer ;



    // --------------------------------------- REMPLIR MAIN ------------------------------------------------
    protected void recevoirCarte(Carte carte) { }



    // ---------------------------------------- JOUER ------------------------------------------------------
    public void jouer(LinkedList<Carte> main, LinkedList<Carte> cartesJouable){}



    // -------------------------------------- GETTER MAIN --------------------------------------------------
    public void setMain(LinkedList<Carte> main) { }



    // ------------------------------------ RECEVOIR UNE CARTE -----------------------------------------------
    public void ajouterCarte(Carte carte) {   }



    // ------------------------------------ POSER UNE CARTE --------------------------------------------------
    public void donnercarte(Carte carte) {}



    // ------------------------------------ CHOISIR COULEUR CARTE --------------------------------------------------
    public void choisirCouleur(){}



    // -------------------------------------- CHOISIR CARTE A DONNER ---------------------------------------------
    public void choisirCarte(LinkedList<Joueur> joueurs, Joueur j){}








    // -------------------------- GETTER ---------------------------


    protected LinkedList<Carte> getMain() {
        return main;
    }

    public int getNumCarte() {
        return numCarte;
    }

    public CouleurCarte getCouleurCarte() {
        return couleurCarte;
    }

    public Carte getCarteChoisie() {
        return carteChoisie;
    }

    public String getNom() {
        return nom;
    }

}


