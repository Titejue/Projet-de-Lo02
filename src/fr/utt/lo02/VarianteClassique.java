package fr.utt.lo02;

abstract class VarianteClassique implements Variante {

    int numVariante;
    int paiement ;


        public VarianteClassique(int numVariante) {
            this.numVariante = numVariante;
            System.out.println("Vous avez choisi la variante Classique")
        }

        public void effetCarte(Carte carte){

            switch(carte.getValeur()){
                case AS :
                    this.paiement = 0 ;
                    break;
                case DEUX:

                    break;
                case TROIS:
                    break ;
                case QUATRE :
                    break;
                case CINQ:
                    break;
                case SIX:
                    break ;
                case SEPT:
                    break;
                case HUIT:
                    break ;
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
                default;
            }

        }


}
