package fr.utt.lo02;

public class Carte {
    private ValeurCarte valeur ; //Valeur de la carte
    private CouleurCarte couleur;
    // private Localisation localisation; // Endroits possibles où se trouve la carte

    // CONSTRUCTEUR DE LA CLASSE CARTE

    public Carte(ValeurCarte num, CouleurCarte type) {
        this.valeur = num;
        this.couleur = type;
        //   this.localisation = Localisation.Pioche;
    }

    // Connaitre la carte (valeur et couleur)
    public String toString(){
        String s;
        s="["+this.getCouleur()+","+this.getValeur()+"]";
        return s;
    }

    // Getter et Setter
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


    protected void finalize() {
    }

    public void appliquer() {
    }


    public static void main(String[] args) {
        Carte Test = new Carte(ValeurCarte.DIX,CouleurCarte.Pique);
        System.out.println(Test);
}
