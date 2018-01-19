package fr.utt.lo02;

import GUI.Controleur;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 *
 * <b>ImageCarte est le label contenant l'image de la carte qui sera affiché à l'écran</b>
 * <p>Elle hérite de la classe JLabel de javax.swing</p>
 * <p>
 *     Cette classe permet au Plateau d'afficher l'image associée à la carte sur la fenêtre de jeu
 * @see GUI.Plateau
 * @see Carte
 *
 *
 * </p>
 *
 * @author Titejue, PYBurosse
 * @version 1.0
 */
public class ImageCarte extends JLabel{
    private Carte cartelie;

    /**
     * Constructeur de ImageCarte
     * @param adresse
     *          L'adresse de l'image de la carte à afficher
     * @param c
     *          La carte représenté par l'image
     */
    public ImageCarte(String adresse, Carte c)
    {
        super((new ImageIcon(new ImageIcon(adresse).getImage().getScaledInstance(75, 100, Image.SCALE_DEFAULT))));
        this.cartelie = c;
        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent mouseEvent) {
                super.mouseClicked(mouseEvent);
                System.out.println("clic sur : " + cartelie.toString());
                Controleur.carteClic(cartelie);

            }
        });

    }
}
