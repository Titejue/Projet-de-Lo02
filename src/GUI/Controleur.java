package GUI;

import java.awt.*;
import java.util.LinkedList;
import java.util.Observable;
import java.util.Observer;
import javax.swing.*;
import fr.utt.lo02.*;
import java.awt.event.*;
import fr.utt.lo02.JoueurReel;

public class Controleur {
    private static LinkedList<Joueur> joueurs;
    private Pioche pioche;
    private Talon talon;
    private JFrame fenetre;
    private Joueur JReal;
    private static Controleur ourInstance = null;
    private Controleur(LinkedList<Joueur> j, Pioche p, Talon t, JFrame f)
    {
        joueurs = j;
        this.pioche = p;
        this.talon = t;
        this.fenetre = f;
        JReal = this.joueurs.get(0);





    }
    //getter et createur du singleton
    public static Controleur getInstance()
    {
        return ourInstance;
    }
    public static Controleur getInstance(LinkedList<Joueur> j, Pioche p, Talon t, JFrame f)
    {
        if(ourInstance ==null)
        {
            ourInstance = new Controleur(j, p, t, f);
        }
        return ourInstance;
    }

    public static void carteClic(Carte c)
    {
        Partie.getInstance().getJoueurReel().setChoix(c);
    }

    public static void couleurClic(CouleurCarte cc)
    {
        Partie.getInstance().getJoueurReel().setCouleurChoisie(cc);
    }

    public static void joueurClic(Joueur j)
    {
        Partie.getInstance().getJoueurReel().setJoueurChoix(j);
    }

    //---------------------------------Choisir un adversaire------------------

    public static void fenetreChoixJoueur()
    {
        JFrame fenChoix = new JFrame();
        fenChoix.setVisible(true);
        fenChoix.setBounds(150, 150, 200, 500);
        fenChoix.setLayout(new GridLayout((joueurs.size() - 1), 1));
        fenChoix.setResizable(false);
        fenChoix.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        fenChoix.setTitle("Choisissez un joueur pour lui donner la carte");


        for(Joueur j:joueurs)
        {
            if(! (j instanceof JoueurReel))
            fenChoix.getContentPane().add(new BoutonAdversaire(j.getNom(), j, fenChoix));
        }
        fenChoix.repaint();


    }

    public void choixTexte(int i)
    {

        Partie.getInstance().getJoueurReel().setChoix(Partie.getInstance().getJoueurReel().getMain().get(i));
        Partie.getInstance().getJoueurReel().setJoueurChoix(joueurs.get(i));
        switch(i)
        {
            case (1):
                Partie.getInstance().getJoueurReel().setCouleurChoisie(CouleurCarte.Coeur);
                break;
            case (2):
                Partie.getInstance().getJoueurReel().setCouleurChoisie(CouleurCarte.Carreau);
                break;
            case (3):
                Partie.getInstance().getJoueurReel().setCouleurChoisie(CouleurCarte.Trefle);
                break;
            case (4):
                Partie.getInstance().getJoueurReel().setCouleurChoisie(CouleurCarte.Pique);
                break;
            default:
                System.out.println("Vous n'avez pas saisie la bonne référence");

        }
    }



}
