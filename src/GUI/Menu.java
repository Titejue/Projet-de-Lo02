package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JSplitPane;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.JButton;
import fr.utt.lo02.*;
// Un test de fenêtre que j'avais fait sur eclipse
/**

 * <b>Menu est la classe qui créer et gère le panneau qui permet de régler les paramètres de la partie</b>
 *
 * <p>
 * Elle initialise et créer une fenêtre contenant :
 * <ul>
 * <li>Un champs de texte pour le nom du joueur</li>
 * <li>Deux JSpinner, un pour le nombre de joueur, et un pour le nombre de paquets de cartes</li>
 * <li>Des boutons radio afin de choisir la variante, ainsi que le type de paquet de carte désiré</li>
 * <li>Des labels afin d'indiquer où se trouvent les informations</li>
 * <li>Un bouton valider pour confirmer les réglages et lancer la partie</li>
 * </ul>
 * </p>
 * @author Titejue, PYBurosse
 * @version 1.3
 */
public class Menu extends JPanel{


	private JTextField Name;
	private boolean valider = false;
	private final ButtonGroup buttonGroupCarte = new ButtonGroup();
    private final ButtonGroup buttonGroupVariant = new ButtonGroup();
    private static Menu ourInstance;
    private Partie partie;

    /**
     * Constructeur du panneau
     * @param p
     *      Recupération d'une référence à l'objet Partie qui l'a appelé
     * Initialisation du panneau
     */

	public Menu(Partie p) {
	    this.partie = p;
		initialize();

	}

	/**
	 * Initialisation du panneau, en créant et ajoutant les éléments necessaires
     *
	 */
	private void initialize() {

		this.setLayout(null);
		Name = new JTextField();
		Name.setText("Joueur\n");
		Name.setBounds(70, 34, 179, 25);
		this.add(Name);
		Name.setColumns(10);
		
		JLabel lblNomDuJoueur = new JLabel("Nom du joueur");
		lblNomDuJoueur.setBounds(70, 21, 300, 14);
		this.add(lblNomDuJoueur);
		
		JSpinner spinner = new JSpinner();
		spinner.setBounds(70, 90, 29, 20);
		this.add(spinner);
		spinner.setValue(2);

		JLabel lblNombreDeJoueurs = new JLabel("Nombre de joueurs dans la partie");
		lblNombreDeJoueurs.setBounds(70, 70, 270, 14);
		this.add(lblNombreDeJoueurs);

        JSpinner spinnerNbDeck = new JSpinner();
        spinnerNbDeck.setBounds(350, 90, 29, 20);
        this.add(spinnerNbDeck);
        spinnerNbDeck.setValue(1);

        JLabel lblNombreDeck = new JLabel("Nombre de jeux de cartes");
        lblNombreDeck.setBounds(350, 70, 300, 14);
        this.add(lblNombreDeck);
		
		JLabel lblTypeDePaquets = new JLabel("Type de paquets de cartes");
		lblTypeDePaquets.setBounds(70, 133, 300, 14);
		this.add(lblTypeDePaquets);
		
		JRadioButton rdbtnCartes54 = new JRadioButton("54 cartes ( 52 + jokers)\r\n");
		buttonGroupCarte.add(rdbtnCartes54);
        rdbtnCartes54.setBounds(70, 154, 300, 23);
		this.add(rdbtnCartes54);
		
		JRadioButton rdbtnCartes52 = new JRadioButton("52 cartes");
		buttonGroupCarte.add(rdbtnCartes52);
		rdbtnCartes52.setBounds(70, 178, 109, 23);
		this.add(rdbtnCartes52);
		
		JRadioButton rdbtnCartes32 = new JRadioButton("32 cartes");
		buttonGroupCarte.add(rdbtnCartes32);
		rdbtnCartes32.setBounds(70, 204, 109, 23);
		this.add(rdbtnCartes32);
        rdbtnCartes54.setSelected(true);

		JLabel lblVariante = new JLabel("Variante");
		lblVariante.setBounds(350, 133, 200, 14);
		this.add(lblVariante);
		
		JRadioButton rdbtnClassique = new JRadioButton("Classique");
		rdbtnClassique.setBounds(350, 154, 109, 23);
		this.add(rdbtnClassique);
        buttonGroupVariant.add(rdbtnClassique);

        JRadioButton rdbtnVMonClar = new JRadioButton("Variante Monclar");
        rdbtnVMonClar.setBounds(350, 180, 160, 23);
        this.add(rdbtnVMonClar);
        buttonGroupVariant.add(rdbtnVMonClar);

        JRadioButton rdbtnVMini = new JRadioButton("Variante Minimale");
        rdbtnVMini.setBounds(350, 206, 160, 23);
        this.add(rdbtnVMini);
        buttonGroupVariant.add(rdbtnVMini);

        JRadioButton rdbtnV1 = new JRadioButton("Variante 1");
        rdbtnV1.setBounds(350, 232, 160, 23);
       this.add(rdbtnV1);
        buttonGroupVariant.add(rdbtnV1);

		rdbtnClassique.setSelected(true);


		JButton btnValider = new JButton("Valider");
		btnValider.setBounds(270, 350, 89, 23);
		this.add(btnValider);

        btnValider.addActionListener(new ActionListener() {
            @Override
            /**
             * Validation des paramètres de la partie
             * @see Partie#creerPartie
             * Envoie des paramètres sélectionnés lors de l'appuie sur le boutton "Valider"
             */
            public void actionPerformed(ActionEvent actionEvent) {

                int numVar = 0;
                if(rdbtnClassique.isSelected())
                {
                    numVar = 0;
                }
                else if(rdbtnVMonClar.isSelected())
                {
                    numVar = 1;
                }
                else if(rdbtnVMini.isSelected())
                {
                    numVar = 2;
                }
                else if(rdbtnV1.isSelected())
                {
                    numVar = 3;
                }

                int typeDeck = 0;
                if(rdbtnCartes54.isSelected())
                {
                    typeDeck = 0;
                }
                else if(rdbtnCartes52.isSelected())
                {
                    typeDeck = 1;
                }
                else if(rdbtnCartes32.isSelected())
                {
                    typeDeck = 3;
                }
                //int nbJoueur, String nom, int numVar, int nbDeck, int typeDeck
                partie.creerPartie((int)spinner.getValue(), Name.getText(), numVar, (int)spinnerNbDeck.getValue(), typeDeck);

            }
        });
	}


}
