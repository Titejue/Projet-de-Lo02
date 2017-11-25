package fr.utt.lo02;

import java.util.LinkedList;

public class Talon {
    protected LinkedList<Carte> talon ;


    // Constructeur en cours
    public Talon() {
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
