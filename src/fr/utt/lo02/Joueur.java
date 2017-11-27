package fr.utt.lo02;

import java.util.* ;
import java.lang.* ;

public abstract class Joueur {

    //Nom du joueur
    protected String nom ;
    //Cartes en main du joueur
    protected LinkedList<Carte> main ;



    /**
     * Un joueur peut :
     * Piocher
     * Choisir une Carte
     * Poser une carte
     * Passer son tour
     * Regarder le jeu dans main (méthode qui appelle une méthode afficher() de la classe main
     */




    public Carte piocher(Pioche p) {
        Carte cartePioche = p.getFirst() ;
        main.add(cartePioche);
        return carte ;
    }






    // -------------------------------------------- JOUER UNE CARTE ------------------------------------------

    public void JouerCarte(Carte carte) {
        Joueur.choisirCarte() ;
        Talon.recevoirCarte(carte) ;
    }

    // -------------------------------------------- PIOCHER UNE CARTE ------------------------------------------

    public void PiocherCarte(int nombre) {
        for (int i=0, i=nombre, i++) {
            Carte carte = Pioche.getFirst();
            System.out.println("Vous avez pioché la carte " + Carte.carte.getValeur() + " de " + Carte.carte.getCouleur());
            main = main.add(carte) ;
            Pioche.pioche = Pioche.pioche.remove(carte) ;
        }
        /**
         * Quand piocher ?
         * Quand on ne peut pas joueur : on passe alors son tour
         * Quand on subit l'action d'une carte spéciale
         * Il faut donc entrer en paramètre d'entrer le nombre de carte à piocher
         */
    }






}

