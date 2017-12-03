package fr.utt.lo02;

import java.util.LinkedList;

public interface Variante {

    LinkedList<Carte> getCartePourJouer();
    int getPaiement() ;
    public int getSens() ;
    public int getProchainTour() ;

    int effetCarte(Carte carte) ;

   // public void piocher() ;
    void carteJouable(Joueur j, LinkedList<Carte> main, LinkedList<Carte> dernieresCartes, int payer);


    // Premier Tour
    void carteJouableDebut(Joueur j, LinkedList<Carte> main, LinkedList<Carte> dernieresCartes) ;


    // Action des cartes

    public void actionCarte(int paie, int sens, int tour, int nbJoueur) ;

}
