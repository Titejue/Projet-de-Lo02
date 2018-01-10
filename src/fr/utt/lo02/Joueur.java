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
    protected boolean uneCarte;
    protected direCarte processus;



    // --------------------------------------- REMPLIR MAIN ------------------------------------------------
    protected void recevoirCarte(Carte carte) { }



    // ---------------------------------------- JOUER ------------------------------------------------------
    public void jouer(LinkedList<Carte> main, LinkedList<Carte> cartesJouable, Joueur j){}



    // -------------------------------------- GETTER MAIN --------------------------------------------------
    public void setMain(LinkedList<Carte> main) { }



        // ------------------------------------ POSER UNE CARTE --------------------------------------------------
    public void donnercarte(Carte carte) {}



    // ------------------------------------ CHOISIR COULEUR CARTE --------------------------------------------------
    public void choisirCouleur(){}



    // -------------------------------------- CHOISIR CARTE A DONNER ---------------------------------------------
    public void choisirCarte(LinkedList<Joueur> joueurs, Joueur j){}








    // -------------------------- GETTER ---------------------------


    public LinkedList<Carte> getMain() {
        return this.main;
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


    public void afficher(LinkedList<Carte> listeCarte) {  }




}


