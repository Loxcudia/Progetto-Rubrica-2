package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.border.EmptyBorder;

import Controller.Controller;
import Model.Contatto;

import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;

// TODO: Auto-generated Javadoc
/**
 * La Class CreaGruppo permette di creare di gruppi e di aggiungerci i contatti desiderati.
 * E' possibile creare anche un gruppo vuoto
 */
public class CreaGruppo extends JFrame {

    private JPanel contentPane;
    
    /** Nel text field l'utente inserirà il nome del gruppo. */
    private JTextField textField;
    
    /** con è la variabile associata al controller. */
    Controller con;
    
    /** c è la variabile per gestire la visibilità della finestra. */
    GestioneVisibilitaGUI c;
    
    /** contattimodel sarà una lista model. Questo consente 
	 * l'aggiornamento della finestra a ogni modifica */
    private DefaultListModel<Contatto> contattiModel = new DefaultListModel<>();
	
	/** contatti è l'arrey list dove sono presenti tutti i contatti. */
	private ArrayList<Contatto> contatti = new ArrayList<>();
	
	/** contattigruppo è l'array list di tutti i contatti presenti nel gruppo. */
	private ArrayList<Contatto> contattigruppo = new ArrayList<>();
    
    /**
     *  creazione gruppo.
     *
     *@param in è la variabile relativa a questa finestra nella classe gestioneVisibilità
	 *@param cin è la variabile del controller
     */
    public CreaGruppo(GestioneVisibilitaGUI in, Controller cin) {
    	c = in;
    	con = cin;
    	contatti = con.getRubricaContatti();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 655, 449);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        
        JLabel lblNewLabel = new JLabel("Crea un Gruppo");
        lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel.setBounds(10, 11, 621, 14);
        contentPane.add(lblNewLabel);
        
        JLabel lblNewLabel_1 = new JLabel("Nome");
        lblNewLabel_1.setBounds(10, 55, 49, 14);
        contentPane.add(lblNewLabel_1);
        
        textField = new JTextField();
        textField.setBounds(131, 52, 151, 20);
        contentPane.add(textField);
        textField.setColumns(10);
        
        JLabel lblNewLabel_2 = new JLabel("Seleziona Contatto");
        lblNewLabel_2.setBounds(10, 116, 185, 14);
        contentPane.add(lblNewLabel_2);
        
        JList list = new JList();
        list.setBounds(10, 141, 611, 169);
        contattiModel.addAll(contatti);
		list.setModel(contattiModel);
		contentPane.add(list, BorderLayout.NORTH);
        list.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        
        
        /**
         * Una volta cliccato questo pulsante dopo, verrà salvata la posizione del contatto 
         * nell'array list contatti e verrà poi aggiunto nell'array list dei contatti
         * presenti in un gruppo
         * che
         */
        
        
        JButton btnNewButton = new JButton("Seleziona");
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	int[] selectIndices;
            	selectIndices = list.getSelectedIndices();
            	for(int i = 0; i < selectIndices.length; i++)
            	{
            		contattigruppo.add(contatti.get(selectIndices[i]));
            	}
            }
        });
        btnNewButton.setBounds(131, 112, 106, 23);
        contentPane.add(btnNewButton);
        
        JButton btnNewButton_1 = new JButton("Annulla");
        btnNewButton_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	c.tryAnnullaCreaGruppo();
            }
        });
        btnNewButton_1.setBounds(316, 353, 89, 23);
        contentPane.add(btnNewButton_1);
        
        /**
         * Quando si clicca sul pulsante 'ok' se il nome del gruppo non è vuoto o composto
         * da soli spazi allora salva il gruppo, altrimenti si aprirà un pop-up che ci avviserà
         * di inserire il nome 
         */
        
        JButton btnNewButton_2 = new JButton("Salva");
        btnNewButton_2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	if(textField.getText().isBlank() == false)
            	{
            		con.addGruppo(textField.getText(), contattigruppo);
                	c.trySalvaGruppo();
            	}
            	else
            	{
            		JOptionPane.showMessageDialog(null, "Inserisci un nome");
            	}
            }
        });
        btnNewButton_2.setBounds(205, 353, 89, 23);
        contentPane.add(btnNewButton_2);
        
        
    }
}