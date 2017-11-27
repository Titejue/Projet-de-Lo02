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


    public Pioche(LinkedList<JeuDeCarte> jeux)
    /*type de paquet : faux = 32, vrai = 52
    joker : faux = pas de joker
     */
    {
        for(JeuDeCarte jdc:jeux)
        {
            pioche.addAll(jdc.getJeu());
        }
        Collections.shuffle(pioche);
    }

    public void distribuer(int nbDeCarte)
    {
        for(int i = 0; i < nbDeCarte; i++)
        {
            for(Joueur j: Partie.getJoueurs())
            {
                donnerCarte(j, 1);
            }
        }
    }

    public Carte donnerCarte(Joueur j, int nbDeCarte)
    {
        for(int i = 0; i < nbDeCarte; i++) {
            Carte c = pioche.getFirst();
            j.recevoirCarte(c);
            pioche.remove(c);
        }
    }

}
