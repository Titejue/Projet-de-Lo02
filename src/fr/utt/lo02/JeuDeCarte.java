package fr.utt.lo02;

import java.util.* ;

public class JeuDeCarte {

    private LinkedList<Carte> jeu ;

    public JeuDeCarte(int typeJeu, int nbDeck) {

        /**
         * 0 : Jeu classique 54 cartes (52 cartes + 2 Jokers)
         * 1 : Jeu de 52 cartes
         * 2 : Jeu de 34 cartes (32 cartes + 2 Jokers)
         * 3 : Jeu de 32 cartes
         */

        jeu = new LinkedList<>();


        for (int i=0 ; i < nbDeck ; i++) {

            switch (typeJeu) {
                case 0:
                    for (CouleurCarte couleur : CouleurCarte.values()) {
                        for (ValeurCarte valeur : new ValeurCarte[]{ValeurCarte.AS, ValeurCarte.DEUX, ValeurCarte.TROIS, ValeurCarte.QUATRE, ValeurCarte.CINQ, ValeurCarte.SIX, ValeurCarte.SEPT, ValeurCarte.HUIT, ValeurCarte.NEUF, ValeurCarte.DIX, ValeurCarte.V, ValeurCarte.D, ValeurCarte.R}) {
                            jeu.add(new Carte(valeur, couleur));
                        }
                    }
                    jeu.add(new Carte(ValeurCarte.Joker));
                    jeu.add(new Carte(ValeurCarte.Joker));

                    break;
                case 1:
                    for (CouleurCarte couleur : CouleurCarte.values()) {
                        for (ValeurCarte valeur : new ValeurCarte[]{ValeurCarte.AS, ValeurCarte.DEUX, ValeurCarte.TROIS, ValeurCarte.QUATRE, ValeurCarte.CINQ, ValeurCarte.SIX, ValeurCarte.SEPT, ValeurCarte.HUIT, ValeurCarte.NEUF, ValeurCarte.DIX, ValeurCarte.V, ValeurCarte.D, ValeurCarte.R}) {
                            jeu.add(new Carte(valeur, couleur));
                        }
                    }
                    break;
                case 2:
                    for (CouleurCarte couleur : CouleurCarte.values()) {
                        for (ValeurCarte valeur : new ValeurCarte[]{ValeurCarte.AS, ValeurCarte.SEPT, ValeurCarte.HUIT, ValeurCarte.NEUF, ValeurCarte.DIX, ValeurCarte.V, ValeurCarte.D, ValeurCarte.R}) {
                            jeu.add(new Carte(valeur, couleur));
                        }
                    }
                    jeu.add(new Carte(ValeurCarte.Joker));
                    jeu.add(new Carte(ValeurCarte.Joker));
                    break;
                case 3:
                    for (CouleurCarte couleur : CouleurCarte.values()) {
                        for (ValeurCarte valeur : new ValeurCarte[]{ValeurCarte.AS, ValeurCarte.SEPT, ValeurCarte.HUIT, ValeurCarte.NEUF, ValeurCarte.DIX, ValeurCarte.V, ValeurCarte.D, ValeurCarte.R}) {
                            jeu.add(new Carte(valeur, couleur));
                        }
                    }
                    break;
                default:
            }
        }
    }

    public JeuDeCarte(){}

    //Retourne la liste de Cartes
    public LinkedList<Carte> getJeu() {
        return jeu ;
    }





}
