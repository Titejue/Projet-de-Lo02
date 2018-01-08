package fr.utt.lo02;

import java.util.Collections;
import java.util.LinkedList;

public class Pioche {

    private LinkedList<Carte> pioche ;
    private JeuDeCarte jdc ;
    private Carte carteTest ;

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

    public LinkedList<Carte> donnerCarte(Joueur j, int nbDeCarte) {
        LinkedList<Carte> listeTest = new LinkedList<Carte>();
        for (int i = 0 ; i < nbDeCarte ; i++) {
            j.recevoirCarte(this.pioche.getFirst());
            this.pioche.remove(this.pioche.getFirst());
            listeTest.add(this.pioche.getFirst());
        }
        return listeTest;
    }

    // --------------------------------- GETTER -----------------------------------------------------------

    public LinkedList<Carte> getPioche() {
        return pioche;
    }

    public void setPioche(LinkedList<Carte> pioche) {
        this.pioche = pioche;
    }



    // -------------------------------- DONNER LA PREMIERE CARTE ------------------------------------------

    public Carte getPremiereCarte(){
        Carte carte = this.pioche.getFirst();
        return carte ;
    }

    //----------------------------------DISTRIBUER----------------------------------------------

    public void distribuer(int nombreDeCarte , LinkedList<Joueur> joueurs){
        Carte c ;

        for(int i=0; i<nombreDeCarte; i++){
            for(Joueur j : joueurs)
            {
                c = this.pioche.getFirst();
                j.recevoirCarte(c);
                this.pioche.remove(c);
            }
        }
    }


    // ---------------------------------- ENLEVER UNE CARTE -----------------------------------------
    public void supprimer(Carte carte){
        this.pioche.remove(carte) ;
    }



}
