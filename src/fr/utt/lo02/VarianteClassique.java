package fr.utt.lo02;

import java.util.LinkedList;

public class VarianteClassique implements Variante {

    int numVariante;
    int paiement;
    Carte carteJouable;



    public void VarianteClassique() {
        System.out.println("Vous avez choisi la variante Classique");
    }

    public void effetCarte(Carte carte) {

        switch (carte.getValeur()) {
            case AS:
                this.paiement = 4;
                break;
            case DEUX:
                this.paiement = 2;
                break;
            case TROIS:
                
                break;
            case QUATRE:
                break;
            case CINQ:
                break;
            case SIX:
                break;
            case SEPT:
                break;
            case HUIT:
                break;
            case NEUF:
                break;
            case DIX:
                break;
            case V:
                break;
            case D:
                break;
            case R:
                break;
            case Joker:
                break;
            default:
        }

    }

    public Carte carteJouable(LinkedList<Carte> main, LinkedList<Carte> dernieresCartes) {
        int taille = dernieresCartes.size();
        // size() : nb d'élément dans la liste
        // get(int i) : renvoie l'élément au rang i sachant que l'on commence au rang 0
        if (dernieresCartes.getLast() == dernieresCartes.get(taille - 2) && dernieresCartes.get(taille - 2) == dernieresCartes.get(taille - 3) && dernieresCartes.get(taille - 3) == dernieresCartes.get(taille - 4)) {
            return carteJouable = dernieresCartes.getLast();
        } else return carteJouable;
    }
}

