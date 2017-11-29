package fr.utt.lo02;

import java.util.Collections;
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

    // --------------------------------------- CONSTRUCTEUR ----------------------------------------------

    public Pioche(LinkedList<JeuDeCarte> jeux) {
        this.pioche = new LinkedList<>();

        for (JeuDeCarte jdc : jeux) {
            pioche.addAll(jdc.getJeu());
        }
        Collections.shuffle(pioche);
    }


    // -------------------------------- DISTRIBUER LA CARTE -----------------------------------------------

    public void distribuer(int nbDeCarte) {
        for (int i = 0 ; i < nbDeCarte ; i++) {
            for (Joueur j : Partie.getJoueurs()){
                donnerCarte(j, 1);
            }
        }
    }


    // --------------------------------- DONNER CARTE -----------------------------------------------------

    public void donnerCarte(Joueur j, int nbDeCarte) {
        for (int i = 0 ; i < nbDeCarte ; i++) {
            Carte c = pioche.getFirst();
            j.recevoirCarte(c);
            pioche.remove(c);
        }
    }


    // --------------------------------- GETTER -----------------------------------------------------------

    public LinkedList<Carte> getPioche() {
        return pioche;
    }

}
