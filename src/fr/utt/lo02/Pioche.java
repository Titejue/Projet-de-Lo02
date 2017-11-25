package fr.utt.lo02;

import java.util.LinkedList;

public class Pioche {

    protected LinkedList<Carte> pioche ;

    // Constructeur en cours

    /** Au départ, la pioche sera remplie de TOUTES les cartes
     * Elles seront ensuite distribuées entre les joueurs
     *
     * METHODES A PREVOIR :
     * Remettre le talon dans la pioche
     * Distribuer la pioche aux joueurs
     * Donner une ou plusieurs carte(s) à un joueur
     * Etre mélangé
     */


    public Pioche() {
    }

    // --------------------------------------------- RECEVOIR CARTE ------------------------------------------------

    public void recevoirCarte(LinkedList<Carte> liste){
        pioche.add(Talon.talon) ;
        


    }

}
