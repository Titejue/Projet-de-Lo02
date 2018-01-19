package fr.utt.lo02;

import java.util.Collections;
import java.util.LinkedList;
/**
 * <b>Pioche permet de définir la liste des cartes disponible pour être piochés </b>
 *
 * <p>
 * Elle contient la liste des cartes contenue dans la pile de la pioche
 * </p>
 *
 *
 * @author Titejue, PYBurosse
 *
 */
public class Pioche {

    private LinkedList<Carte> pioche ;



    // --------------------------------------- CONSTRUCTEUR ----------------------------------------------

    /**
     * Constructeur de Pioche
     *
     * @param jeux
     *          Le jeu de carte contenant l'intégralité des cartes jouable selon les paramètres choisie pour la partie
     * @see JeuDeCarte
     *
     * Le jeu de carte est intégré dans la pioche puis mélangé
     */
    public Pioche(JeuDeCarte jeux) {
        this.pioche = new LinkedList<>() ;
        pioche.addAll(jeux.getJeu());
        Collections.shuffle(pioche);
    }


    // --------------------------------- DONNER CARTE -----------------------------------------------------

    /**
     * Permet de faire piocher un nombre de carte prédéfini à un joueur
     * @param j
     *          Le joueur qui doit piocher
     *          @see Joueur
     * @param nbDeCarte
     *          Le nombre de carte à piocher
     * @return
     *          La liste des cartes piocher (destiné à l'affichage)
     */
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
    /**
     * Permet de récupérer la liste des cartes contenue dans la pioche

     * @return
     *         La liste des cartes de la pioche
     */
    public LinkedList<Carte> getPioche() {
        return pioche;
    }




    // -------------------------------- DONNER LA PREMIERE CARTE ------------------------------------------

    /**
     * Permet de récupérer la première carte de la pioche
     * @return
     *      La carte dur le dessus de la pioche
     */
    public Carte getPremiereCarte(){
        Carte carte = this.pioche.getFirst();
        return carte ;
    }

    //----------------------------------DISTRIBUER----------------------------------------------

    /**
     * Permet de distribuer un nombre de carte prédéfini à chacun des joueurs
     *
     * @param nombreDeCarte
     *          Le nombre de carte à distribuer
     * @param joueurs
     *          La liste des joueurs auquel  il faut distribuer les cartes
     */
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

    /**
     * Permet d'enlever une carte de la pioche
     * @param carte
     *          La carte à enlever de la pioche
     */
    // ---------------------------------- ENLEVER UNE CARTE -----------------------------------------
    public void supprimer(Carte carte){
        this.pioche.remove(carte) ;
    }



}
