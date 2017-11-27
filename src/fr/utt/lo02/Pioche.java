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


    public Pioche(int nbPaquet, boolean typeDePaquet, boolean joker)
    /*type de paquet : faux = 32, vrai = 52
    joker : faux = pas de joker
     */
    {
        int i;
        Carte carteT = new Carte(ValeurCarte.AS, CouleurCarte.Trefle);
        Carte carteCa = new Carte(ValeurCarte.AS, CouleurCarte.Carreau);
        Carte carteCo = new Carte(ValeurCarte.AS, CouleurCarte.Coeur);
        Carte carteP = new Carte(ValeurCarte.AS, CouleurCarte.Pique);
        if(typeDePaquet)
        {
            for(i = 0; i<=52; i++)
            {
                
            }
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
