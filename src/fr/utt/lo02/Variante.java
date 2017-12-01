package fr.utt.lo02;

import java.util.LinkedList;

public interface Variante {

    LinkedList<Carte> getCartePourJouer();

    int effetCarte(Carte carte) ;

   // public void piocher() ;
    void carteJouable(Joueur j, LinkedList<Carte> main, LinkedList<Carte> dernieresCartes);


    // Premier Tour
    void carteJouableDebut(Joueur j, LinkedList<Carte> main, LinkedList<Carte> dernieresCartes) ;


}
