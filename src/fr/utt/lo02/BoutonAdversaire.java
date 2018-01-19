package fr.utt.lo02;

import GUI.Controleur;

import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
/**
 * <b>BoutonAdversaire est une classe de type JButton</b>
 * <p>Elle hérite de la classe JButton de javax.swing
 * Elle permet de créer les boutons présent dans la fenêtre de choix d'un adversaire, en déclenchant les actions nécessaire lorsqu'un clic est détecté dessus</p>
 *
 *
 * @author Titejue, PYBurosse
 * @version 1.0
 */
public class BoutonAdversaire extends JButton{

    private Joueur joueur;

    /**
     * Contructeur de BoutonAdversaire
     * @param s
     *      Le texte à afficher sur le bouton
     * @param j
     *      La référence au joueur désigné par le bouton
     * @param fenetre
     *      La référence à la fenêtre dans laquel sera affiché le bouton
     */
    public BoutonAdversaire(String s, Joueur j, JFrame fenetre)
    {
        super(s);
        this.joueur = j;
        this.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent mouseEvent) {
                Controleur.joueurClic(joueur);
                fenetre.dispose();
            }
            public void mouseEntered(MouseEvent mouseEvent) {

            }
            public void mouseExited(MouseEvent mouseEvent) {

            }
            public void mousePressed(MouseEvent mouseEvent) {

            }
            public void mouseReleased(MouseEvent mouseEvent) {

            }
        });

    }
}
