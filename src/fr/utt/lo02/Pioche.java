package fr.utt.lo02;

import java.util.Collections;
import java.util.LinkedList;

public class Pioche {

    private LinkedList<Carte> pioche ;
    private JeuDeCarte jdc ;

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
    public Pioche(JeuDeCarte jeux) {
        this.pioche = new LinkedList<>() ;
        pioche.addAll(jeux.getJeu());
        Collections.shuffle(pioche);
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



    // -------------------------------- DONNER LA PREMIERE CARTE ------------------------------------------

    public Carte getPremiereCarte(){
        Carte carte = pioche.getFirst();
        return carte ;
    }

    //----------------------------------DISTRIBUER----------------------------------------------

    public void distribuer(int nombreDeCarte)
    {
        Carte c;
        for(int i=0; i<=nombreDeCarte; i++)
        {
            for(Joueur j: Partie.getJoueurs())
            {
                c = pioche.getFirst();
                j.ajouterCarte(c);
                pioche.remove(c);
            }
        }
    }



}
