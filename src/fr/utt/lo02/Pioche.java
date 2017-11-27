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


    public Pioche(LinkedList<JeuDeCarte> jeux)
    /*type de paquet : faux = 32, vrai = 52
    joker : faux = pas de joker
     */
    {
        for(JeuDeCarte jeu:jeux)
        {

        }
    }

    // --------------------------------------------- RECEVOIR CARTE ------------------------------------------------

    public void recevoirCarte(LinkedList<Carte> liste){
        pioche.add(Talon.talon()) ;

    }


    // --------------------------------------------- Get premiere CARTE (piocher la premiere carte)------------------------------------------------

    public Carte getFirst(){
        Carte carte = pioche.getFirst();

        return carte ;
    }








}
