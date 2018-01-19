package fr.utt.lo02;

import java.util.* ;

/**
 * {@inheritDoc}
 * <p>
 *     JeuDeCarte est la classe qui décrit le jeu de carte
 *     choisit au début de la partie
 * </p>
 * Une carte est caractérisée par les informations suivantes :
 * <p>
 *     <ul>
 *         <li>Une liste de carte de type "Carte"</li>
 *     </ul>
 * </p>
 * @see Carte
 * @author Titejue, PYBurosse
 * @version 1.3
 */
public class JeuDeCarte {

    /**
     * La liste de cartes qui composent le jeu
     */
    private LinkedList<Carte> jeu ;

    /**
     * Constructeur JeuDeCarte
     * @param typeJeu
     *          La référence du jeu choisit en début de partie
     * <p>
     *     La référence du jeu correspond au type de jeu
     *     <ul>
     *         <li>0 : Jeu classique 54 cartes (52 cartes + 2 Jokers)</li>
     *         <li>1 : Jeu de 52 cartes</li>
     *         <li>2 : Jeu de 34 cartes (32 cartes + 2 Jokers)</li>
     *         <li>3 : Jeu de 32 cartes</li>
     *     </ul>
     * </p>
     * @param nbDeck
     *          Le nombre de paquets de cartes avec le(s)quel(s) va jouer
     */
    public JeuDeCarte(int typeJeu, int nbDeck) {

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

    /**
     * Constructeur JeuDeCarte
     * Construit un objet "JeuDeCarte"
     */
    public JeuDeCarte(){}

    /**
     * Retourne la liste de "Cartes" qui composent le jeu
     * @return La liste de "Cartes" qui composent le "JeuDeCarte"
     */
    public LinkedList<Carte> getJeu() {
        return jeu ;
    }
}