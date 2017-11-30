package fr.utt.lo02;

import java.util.LinkedList;

public interface Variante {

    void effetCarte(Carte carte) ;
   // public void piocher() ;
    Carte carteJouable(LinkedList<Carte> main, LinkedList<Carte> dernieresCartes);

}
