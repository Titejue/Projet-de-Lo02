package fr.utt.lo02;


import java.util.LinkedList;
import java.util.Random;
import java.util.Scanner;

public class Adversaire extends Joueur {


    /**
     * On essaiera de jouer à plusieurs en local ou écran scindé
     * Pour le moment on considère des IA
     */

    public Adversaire(String nom) {
        this.nom = nom;
        this.main =  new LinkedList<Carte>() ;
    }

    // ---------------------------------------- JOUER ---------------------------------------------------
    public void jouer(LinkedList<Carte> main, LinkedList<Carte> cartesJouable, Joueur j){
        j.setMain(main) ;
        this.cartesJouable = cartesJouable ;

        // Séléction aléatoire d'une carte par l'IA
        this.numCarte = new Random().nextInt(this.cartesJouable.size()) ;
        this.carteChoisie = this.cartesJouable.get(numCarte) ;
        this.main.remove(carteChoisie) ;
    }


    // ------------------------------------- CHOISIR LA COULEUR DE LA CARTE --------------------------------
    public void choisirCouleur() {
        Carte carte = new Carte();

        int c = 5;
        while (c > 4 || c < 1) {
            // Choisir une couleur entre 1 et 4
            c = new Random().nextInt(5);
            switch (c) {
                case (1):
                    carte.setCouleur(CouleurCarte.Coeur);
                    this.couleurCarte = CouleurCarte.Coeur;
                    break;
                case (2):
                    carte.setCouleur(CouleurCarte.Carreau);
                    this.couleurCarte = CouleurCarte.Carreau;
                    break;
                case (3):
                    carte.setCouleur(CouleurCarte.Trefle);
                    this.couleurCarte = CouleurCarte.Trefle;
                    break;
                case (4):
                    carte.setCouleur(CouleurCarte.Pique);
                    this.couleurCarte = CouleurCarte.Pique;
                    break;
            }
        }
    }


    // --------------------------------------- RECEVOIR CARTE DANS MAIN ------------------------------------------------
    protected void recevoirCarte(Carte carte) {
        this.main.add(carte) ;
    }


    // ------------------------------------ CHOISIR CARTE --------------------------------------------------
    public void choisirCarte(LinkedList<Joueur> joueurs, Joueur j) {
        int numCarteAJouer = new Random().nextInt(getMain().size()) ;

        Carte carteADonner = new Carte() ;
        carteADonner = j.main.get(numCarteAJouer);

        // Choisir le joueur à qui la donner
        joueurs.remove(j);


        System.out.println("Veuillez choisir le joueur à qui donner cette carte");
        int numjoueur = new Random().nextInt(joueurs.size()) ;
        System.out.println("Le joueur " + joueurs.get(numjoueur) + " est séléctionné");
        // Donner la carte au joueur séléctionné
        System.out.println("Il reçoit la carte " + carteADonner.toString());

        joueurs.get(numjoueur).recevoirCarte(carteADonner);

        // On supprime cette carte de la main du joueur
        LinkedList<Carte> mainFictive = j.getMain();
        mainFictive.remove(carteADonner);
        j.setMain(mainFictive);
    }


    // ------------------------------------ Afficher la main ----------------------------------------
    public void afficher(LinkedList<Carte> listeCarte) {
        for (int i=0 ; i<listeCarte.size() ; i++){
            System.out.println(i + " : " + listeCarte.get(i).toString());
        }
    }



    // ---------------------------------- GETTER ---------------------------------------------------------

    public void setMain(LinkedList<Carte> main) {
        this.main = main;
    }

    public CouleurCarte getCouleurCarte() {
        return this.couleurCarte ;
    }

    public String getNom() {
        return this.nom ;
    }

    public LinkedList<Carte> getMain() {
        return this.main ;
    }



}
