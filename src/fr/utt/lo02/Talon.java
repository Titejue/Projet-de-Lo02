package fr.utt.lo02;

import java.util.Collections;
import java.util.LinkedList;

public class Talon {

    protected LinkedList<Carte> talon ;


    // --------------------------------------- CONSTRUCTEUR ----------------------------------------------

    public Talon() {
        this.talon = new LinkedList<>() ;
    }


    // --------------------------------------------- RECEVOIR CARTE ------------------------------------------------

    public void recevoirCarte(Carte carte){
        talon.add(carte) ;
    }


    // --------------------------------------------- GETTER ET SETTER  ---------------------------------------------

    public LinkedList<Carte> getTalon() {
        return talon;
    }

    public void setTalon(LinkedList<Carte> talon) {
        this.talon = talon;
    }








}
