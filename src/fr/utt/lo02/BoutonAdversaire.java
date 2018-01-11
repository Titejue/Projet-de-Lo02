package fr.utt.lo02;

import GUI.Controleur;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class BoutonAdversaire extends JButton{

    private Joueur joueur;
    public BoutonAdversaire(String s, Joueur j, JFrame fenetre)
    {
        super(s);
        this.joueur = j;
        this.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent mouseEvent) {
                Controleur.joueurClic(joueur);
                System.out.println("CLICCESEFESZF");
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
