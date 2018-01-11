package fr.utt.lo02;

import GUI.Controleur;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class CouleurClic extends JLabel {

    private CouleurCarte couleur;
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
