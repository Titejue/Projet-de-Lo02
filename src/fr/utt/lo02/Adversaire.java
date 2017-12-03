package fr.utt.lo02;


import java.util.LinkedList;

public class Adversaire extends Joueur {


    /**
     * On essaiera de jouer à plusieurs en local ou écran scindé
     * Pour le moment on considère des IA
     */

    public Adversaire(String nom) {
        this.nom = nom;
        this.main =  new LinkedList<Carte>() ;
    }

    public void jouer(LinkedList<Carte> main, LinkedList<Carte> cartesJouable) {
        // On récupère la lsite des cartes jouables
        LinkedList<Carte> cjouable; //= Partie.getVariante().carteJouable();
        int j = cjouable.size() * Math.random();

    }

    // --------------------------------------- REMPLIR MAIN ------------------------------------------------

    protected void recevoirCarte(Carte carte) {
        this.main.add(carte);
    }







    // ---------------------------------- GETTER ---------------------------------------------------------

    public String getNom(){
        return this.nom ;
    }



}
