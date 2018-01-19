package fr.utt.lo02;

import GUI.Controleur;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
/**
 *
 * <b>CouleurClic est le label contenant l'image des couleurs choisissable par le joueur</b>
 * <p>Elle hérite de la classe JLabel de javax.swing</p>
 * <p>
 *     Cette classe permet au Plateau d'afficher les images associées aux couleur sur la fenêtre de jeu
 *     afin que le joueur puisse cliquer sur l'une d'elles.
 * @see GUI.Plateau
 * @see JoueurReel#choisirCouleur()
 *
 *
 * </p>
 *
 * @author Titejue, PYBurosse
 */
public class CouleurClic extends JLabel {

    private CouleurCarte couleur;
    /**
     * Constructeur de ImageCarte
     * @param s
     *          L'adresse de l'image de la couleur à afficher
     * @param cc
     *          La couleur représentée par le Label
     */
    public CouleurClic(String s, CouleurCarte cc) {
        super(new ImageIcon(new ImageIcon(s).getImage().getScaledInstance(75, 100, Image.SCALE_DEFAULT)));

        couleur = cc;
        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent mouseEvent) {
                super.mouseClicked(mouseEvent);
                System.out.println("clic sur : " + couleur.toString());
                Controleur.couleurClic(couleur);

            }
        });
    }
}
