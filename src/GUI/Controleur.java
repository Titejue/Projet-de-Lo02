package GUI;

import java.util.LinkedList;
import java.util.Observable;
import java.util.Observer;
import javax.swing.*;
import fr.utt.lo02.*;
import java.awt.event.*;

public class Controleur {
    private LinkedList<Joueur> joueurs;
    private Pioche pioche;
    private Talon talon;
    private JFrame fenetre;
    private Joueur JReal;
    public Controleur(LinkedList<Joueur> j, Pioche p, Talon t, JFrame f)
    {
        this.joueurs = j;
        this.pioche = p;
        this.talon = t;
        this.fenetre = f;
        JReal = this.joueurs.get(0);



    }
    /*public void genererClic()
    {
        for(Carte c:JReal.getMain())
        {
            c.getImage().addMouseListener(new MouseAdapter () {

                public void mouseLiberalClick(MouseEvent e) {
                    JReal.setCarteChoisie(c);
                }
            });
        }
    }*/

}
