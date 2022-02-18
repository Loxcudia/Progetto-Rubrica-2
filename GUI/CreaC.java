package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Controller.Controller;
import Model.AccountMessaggistica;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;

// TODO: Auto-generated Javadoc
/**
 * La Classe CreaC è la classe che ci permette la creazione di un contatto.
 */
public class CreaC extends JFrame {

	private JPanel contentPane;
	
	/** The text field è lo spazio in cui l'utente inserisce il nome. */
	private JTextField textField;
	
	/** The text field 1 è lo spazio in cui l'utente inserisce il cognome. */
	private JTextField textField_1;
	
	/** The text field 2 è lo spazio in cui l'utente inserisce l'età. */
	private JTextField textField_2;
	
	/** The text field 3 è lo spazio in cui l'utente inserisce la residenza */
	private JTextField textField_3;
	
	/** The text field 4 è lo spazio in cui l'utente inserisce l'email. */
	private JTextField textField_4;
	
	/** The text field 5 è lo spazio in cui l'utente inserisce il numero di telefono fisso */
	private JTextField textField_5;
	
	/** The text field 6 è lo spazio in cui l'utente inserisce il numero di telefono mobile */
	private JTextField textField_6;
	
	/**c è la variabile usata per gestire la visibilità delle finestre */
	private GestioneVisibilitaGUI c;
	
	/**con è la variabile del controller. */
	private Controller con;
	
	/**sesso è la stringa con la quale controlleremo il sesso del contatto */
	String[] sesso= {"M", "F", "NB"};
	
	/**combobox è il menù a tendina all'interno del quale l'utente selezionerà il sesso del contatto*/
	private JComboBox combobox= new JComboBox(sesso);
	
	/**
	 * Creazione contatto
	 *
	 *@param in è la variabile relativa a questa finestra nella classe gestioneVisibilità
	 *@param cin è la variabile del controller
	 */
	public CreaC(GestioneVisibilitaGUI in, Controller cin) {
		c = in;
		con = cin;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 568, 407);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblNewLabel = new JLabel("Inserisci le informazioni per il nuovo contatto");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setToolTipText("");
		lblNewLabel.setBounds(0, 11, 554, 14);
		
		JLabel lblNewLabel_1 = new JLabel("Nome: ");
		lblNewLabel_1.setBounds(40, 51, 55, 14);
		
		textField = new JTextField();
		textField.setBounds(115, 48, 277, 20);
		textField.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Cognome:");
		lblNewLabel_2.setBounds(40, 82, 78, 14);
		
		textField_1 = new JTextField();
		textField_1.setBounds(115, 79, 277, 20);
		textField_1.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Et\u00E0:");
		lblNewLabel_3.setBounds(40, 113, 55, 14);
		
		textField_2 = new JTextField();
		textField_2.setBounds(115, 113, 49, 20);
		textField_2.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("Sesso:");
		lblNewLabel_4.setBounds(40, 147, 55, 14);
		combobox.setBounds(115, 144, 40, 20);
		
		JLabel lblNewLabel_5 = new JLabel("Residenza:");
		lblNewLabel_5.setBounds(40, 173, 124, 14);
		
		textField_3 = new JTextField();
		textField_3.setBounds(188, 170, 204, 20);
		textField_3.setColumns(10);
		
		JLabel lblNewLabel_6 = new JLabel("Email:");
		lblNewLabel_6.setBounds(40, 199, 124, 14);
		
		textField_4 = new JTextField();
		textField_4.setBounds(188, 196, 204, 20);
		textField_4.setColumns(10);
		
		JLabel lblNewLabel_7 = new JLabel("Numero Telefono Fisso:");
		lblNewLabel_7.setBounds(40, 225, 150, 14);
		
		textField_5 = new JTextField();
		textField_5.setBounds(188, 222, 204, 20);
		textField_5.setColumns(10);
		
		JLabel lblNewLabel_8 = new JLabel("Numero Telefono Mobile:");
		lblNewLabel_8.setBounds(40, 251, 150, 14);
		
		textField_6 = new JTextField();
		textField_6.setBounds(188, 248, 204, 20);
		textField_6.setColumns(10);
		
		/**
		 * Quando l'utente cliccherà sul bottone 'OK' il contatto verrà chiamata
		 * la funzione addContatto solo se nelle caselle textField_ e TextField_6
		 * sono presenti esclusivamente numeri e nella casella textField2 sono presenti
		 * esclusivamente numeri o sia vuota o composta da soli spazzi.
		 * Altrimenti il metodo genera un pop-up che spiega l'errore
		 */
		JButton btnNewButton = new JButton("OK");
		btnNewButton.setBounds(196, 331, 68, 23);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(con.isNumeric(textField_5.getText()) && con.isNumeric(textField_6.getText()) && ((con.isNumeric(textField_2.getText()))||(textField_2.getText().isBlank())))
				{
					ArrayList<String> ns = new ArrayList<>();
					ArrayList<AccountMessaggistica> am = new ArrayList<>();
					ns = c.getNumeriSecondari();
					am = c.getAccountm();
					con.addContatto(textField.getText(), textField_1.getText(), textField_2.getText(), combobox.getSelectedItem().toString(), textField_3.getText(), textField_4.getText(), textField_5.getText(), textField_6.getText(), ns, am);
					c.creaContatto(textField.getText(), textField_1.getText(), textField_5.getText(), textField_6.getText());c.creaContatto(textField.getText(), textField_1.getText(), textField_5.getText(), textField_6.getText());
				}
				else
				{
					JOptionPane.showMessageDialog(null, "Caratteri non validi");
				}
			}
		});
		
		/**
		 * questo metodo consente di apire la finestra AggiungiAccountMessaggistica
		 */
		
		JButton btnNewButton_1 = new JButton("Aggiungi Account Messaggistica");
		btnNewButton_1.setBounds(40, 279, 224, 23);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				c.tryAggiungiAccountMessaggistica();
			}
		});
		
		/**
		 * questo metodo consente di apire la finestra AggiungiNumeriSecondari
		 */
		
		JButton btnNewButton_2 = new JButton("Aggiungi Numeri Secondari");
		btnNewButton_2.setBounds(270, 279, 219, 23);
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				c.tryAggiungiNumeriSecondari();
			}
		});
		
		/**
		 * Quando il pulsante annulla verrà cliccato si ritornerà alla schermata precedente perdendo i dati inseriti
		 */
		JButton btnNewButton_3 = new JButton("Annulla");
		btnNewButton_3.setBounds(270, 331, 78, 23);
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				c.tryIndietroCreaC();
			}
		});
		contentPane.setLayout(null);
		contentPane.add(lblNewLabel);
		contentPane.add(lblNewLabel_1);
		contentPane.add(textField);
		contentPane.add(lblNewLabel_4);
		contentPane.add(combobox);
		contentPane.add(lblNewLabel_8);
		contentPane.add(textField_6);
		contentPane.add(lblNewLabel_7);
		contentPane.add(lblNewLabel_6);
		contentPane.add(lblNewLabel_5);
		contentPane.add(textField_3);
		contentPane.add(textField_5);
		contentPane.add(textField_4);
		contentPane.add(lblNewLabel_2);
		contentPane.add(lblNewLabel_3);
		contentPane.add(textField_2);
		contentPane.add(textField_1);
		contentPane.add(btnNewButton_1);
		contentPane.add(btnNewButton);
		contentPane.add(btnNewButton_2);
		contentPane.add(btnNewButton_3);
	}
}
