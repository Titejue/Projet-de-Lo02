package fr.utt.lo02;

public class Carte {

    private ValeurCarte valeur ;
    private CouleurCarte couleur ;


    // ------------------------------- CONSTRUCTEUR -------------------------------------------------------------

    public Carte(ValeurCarte num, CouleurCarte type) {
        this.valeur = num ;
        this.couleur = type ;
    }


    // ------------------------------- GETTER ET SETTER -------------------------------------------------------------

    ValeurCarte getValeur() {
        return this.valeur;
    }

    void setValeur(ValeurCarte numero) {
        this.valeur = numero;
    }

    CouleurCarte getCouleur() {
        return this.couleur;
    }

    void setCouleur(CouleurCarte type) {
        this.couleur = type;
    }

    // Connaitre la carte (valeur et couleur)
    public String toString() {
        String s ;
        if (this.getValeur() == ValeurCarte.Joker){
            s = "" + this.getValeur() + "" ;
        }
        else {
            s = "" + this.getValeur() + " de " + this.getCouleur() + "" ;
        }
        return s ;
    }
}

