package GUI;


import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;

import javax.swing.*;
import fr.utt.lo02.* ;


public class CarteLabel extends JLabel {


    private int WIDTH = 120;
    private double RATIO = 1.452;
    private ImageIcon logo;


    public CarteLabel(Carte carte) {
        CouleurCarte couleur = carte.getCouleur();
        ValeurCarte valeur = carte.getValeur();
        String nomImage = "src/Images/" + valeur + "_" + couleur + ".png";
        logo = new ImageIcon(nomImage);
        Image logoImage = getScaledImage(logo.getImage(), WIDTH, (int) (WIDTH * RATIO));
    }


    private Image getScaledImage(Image srcImg, int w, int h) {
        BufferedImage resizedImg = new BufferedImage(w, h, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2 = resizedImg.createGraphics();

        g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
        g2.drawImage(srcImg, 0, 0, w, h, null);
        g2.dispose();

        return resizedImg;
    }



}



