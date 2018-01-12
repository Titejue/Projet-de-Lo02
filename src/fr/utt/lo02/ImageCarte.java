package fr.utt.lo02;

import GUI.Controleur;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ImageCarte extends JLabel{

    private Carte cartelie;
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
