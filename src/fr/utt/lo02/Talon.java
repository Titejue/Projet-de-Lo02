package fr.utt.lo02;

import java.util.LinkedList;
/**
 * <b>Talon permet de définir la liste des cartes déjà jouées dans la partie </b>
 *
 * <p>
 * Contient toutes les cartes jouées, jusqu'à ce qu'elles soient remélangé dans la pioche
 * @see Pioche
 * </p>
 *
 *
 * @author Titejue, PYBurosse
 *
 */
public class Talon {

    protected LinkedList<Carte> talon ;


    // --------------------------------------- CONSTRUCTEUR ----------------------------------------------

    /**
     * Contructeur de Talon
     */
    public Talon() {
        this.talon = new LinkedList<>() ;
    }


    // --------------------------------------------- RECEVOIR CARTE ------------------------------------------------

    /**
     * Permet d'ajouter une carte sur le dessus du talon
     * @param carte
     *          La carte à ajouter sur le talon
     */
    public void recevoirCarte(Carte carte){
        talon.add(carte) ;
    }


    /**
     * Permet de récupérer la dernière carte du talon
     * @return
     * la dernière carte placée sur le talon
     */
    // ----------------------------------- Retourner la dernière carte du talon -----------------------------------
    public Carte getDerniereCarte(){
        Carte carte = this.talon.getLast();
        return carte ;
    }


    // --------------------------------------------- GETTER ET SETTER  ---------------------------------------------

    /**
     * Permet de récupérer la liste des cartes du talon
     * @return
     *      Le contenu du talon
     */
    public LinkedList<Carte> getTalon() {
        return talon;
    }




}
