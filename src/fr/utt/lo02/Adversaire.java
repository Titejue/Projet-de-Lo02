package fr.utt.lo02;


public class Adversaire extends Joueur {
    private String nom ;


    /**
     * On essaiera de jouer à plusieurs en local ou écran scindé
     * Pour le moment on considère des IA
     */

    public Adversaire(String nom) {
        this.nom = nom ;}
}
