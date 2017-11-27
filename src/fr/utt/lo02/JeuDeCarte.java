package fr.utt.lo02;

import java.util.* ;

public class JeuDeCarte {

    int variante ;
    private LinkedList<Carte> jeu ;

    public JeuDeCarte(int typeJeu){

        /**
         * 0 : Jeu classique 54 cartes (52 cartes + 2 Jokers)
         * 1 : Jeu de 52 cartes
         * 2 : Jeu de 34 cartes (32 cartes + 2 Jokers)
         * 3 : Jeu de 32 cartes
         */

        switch (typeJeu)
        {
            case 0:
                System.out.println("Ouch !");
                break;
            case 1:
                System.out.println("Vous avez juste la moyenne.");
                break;
            case 2:
                System.out.println("Parfait !");
                break;
            case 3:
                break;
            default:
                System.out.println("Il faut davantage travailler.");
        }


        

    }

    public LinkedList<Carte> getJeu() {
        return jeu ;
    }



}
