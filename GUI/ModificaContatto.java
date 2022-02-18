package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Controller.Controller;
import Model.Contatto;
import Model.Rubrica;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


/**
 * The Class ModificaContatto consente la modifica del contatto
 */
public class ModificaContatto extends JFrame {

	private JPanel contentPane;
	
	/** textfield è la variabile dove l'utente scriverà il nome  */
	private JTextField textField;
	
	/** textfield_1 è la variabile dove l'utente scriverà il cognome. */
	private JTextField textField_1;
	
	/** textfield_2 è la variabile dove l'utente scriverà l'età  */
	private JTextField textField_2;
	
	/** textfield_3 è la variabile dove l'utente scriverà il sesso . */
	private JTextField textField_3;
	
	/** textfield_4 è la variabile dove l'utente scriverà l'email /*
	private JTextField textField_4;
	
	/** textfield_5 è la variabile dove l'utente scriverà la residenza  */
	private JTextField textField_5;
	
	/** c è la variabile che usiamo per gestire la visibilità delle finestre. */
	GestioneVisibilitaGUI c;
	
	/** con è la variabile associata al controller. */
	Controller con;
	private JTextField textField_4;
	
	/**
	 *
	  *@param in è la variabile relativa a questa finestra nella classe gestioneVisibilità
	 * @param cin è la variabile del controller
	 * @param co è la variabile relativa al contatto che si vuole modificare 
	 * @param r è la variabile associata alla rubrica
	 */
	public ModificaContatto(GestioneVisibilitaGUI in, Contatto co, Rubrica r, Controller cin) {
		c = in;
		con = cin;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 470, 420);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblNewLabel = new JLabel("Scegli cosa modificare:");
		lblNewLabel.setBounds(144, 16, 130, 14);
		
		JLabel lblNewLabel_1 = new JLabel("Nome:");
		lblNewLabel_1.setBounds(15, 63, 60, 14);
		
		JLabel lblNewLabel_2 = new JLabel("Cognome:");
		lblNewLabel_2.setBounds(15, 89, 68, 14);
		
		JLabel lblNewLabel_3 = new JLabel("Et\u00E0:");
		lblNewLabel_3.setBounds(15, 115, 47, 14);
		
		JLabel lblNewLabel_4 = new JLabel("Sesso:");
		lblNewLabel_4.setBounds(15, 141, 60, 14);
		
		JLabel lblNewLabel_5 = new JLabel("Email:");
		lblNewLabel_5.setBounds(15, 167, 60, 14);
		
		JLabel lblNewLabel_6 = new JLabel("Residenza:");
		lblNewLabel_6.setBounds(15, 193, 68, 14);
		
		textField = new JTextField(co.getNome());
		textField.setBounds(85, 60, 232, 20);
		textField.setColumns(10);
		
		textField_1 = new JTextField(co.getCognome());
		textField_1.setBounds(85, 86, 232, 20);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField(co.getEtà());
		textField_2.setBounds(85, 112, 232, 20);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField(co.getSesso());
		textField_3.setBounds(86, 138, 232, 20);
		textField_3.setColumns(10);
		
		textField_4 = new JTextField(co.getEmail());
		textField_4.setBounds(85, 164, 233, 20);
		textField_4.setColumns(10);
		
		textField_5 = new JTextField(co.getResidenza());
		textField_5.setBounds(84, 190, 233, 20);
		textField_5.setColumns(10);
		
		/**
		 * quando l'uetente clicca sul tasto 'ok', il programma controlla che i dati inseriti sono validi
		 * e passerà le variabili presenti nei textfiel alle funzioni apposite del controller per modificare
		 * i dati relativi a quel contatto. Se le variabili inserite non sono idenee allora si aprirà un pop_up che
		 * spiegherà l'errore
		 */
		
		JButton btnNewButton_2 = new JButton("OK");
		btnNewButton_2.setBounds(131, 320, 54, 23);
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if((con.isNumeric(textField_2.getText()))||(textField_2.getText().isBlank())&&((!textField.getText().isBlank())||(!textField_1.getText().isBlank())))
				{
					Contatto cn = new Contatto(textField.getText(), textField_1.getText(), textField_2.getText(), textField_3.getText(), textField_4.getText(), textField_5.getText(), r);
					if(co.getNome() != cn.getNome())
					{
						co.setNome(textField.getText());
					}
					if(co.getCognome() != cn.getCognome())
					{
						co.setCognome(textField_1.getText());
					}
					if(co.getEtà() != cn.getEtà())
					{
						co.setEtà(textField_2.getText());
					}
					if(co.getSesso() != cn.getSesso())
					{
						co.setSesso(textField_3.getText());
					}
					if(co.getEmail() != cn.getEmail())
					{
						co.setEmail(textField_4.getText());
					}
					if(co.getResidenza() != cn.getResidenza())
					{
						co.setResidenza(textField_5.getText());
					}
					c.tryModificaContatto2();
				}
				else
				{
					JOptionPane.showMessageDialog(null, "Lettere non valide per l'età o il nome e il cognome sono vuoti");
				}
			}
		});
		 
		/**
		 * Il tasto annulla chiama la funzione tryIndietroModificaContatto e tutti i dati inseriti o le modifiche
		 * apportate andranno perse.
		 */
		
		JButton btnNewButton_3 = new JButton("Annulla");
		btnNewButton_3.setBounds(203, 320, 111, 23);
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				c.tryIndietroModificaContatto();
			}
		});
		contentPane.setLayout(null);
		contentPane.add(lblNewLabel);
		contentPane.add(lblNewLabel_1);
		contentPane.add(textField);
		contentPane.add(lblNewLabel_2);
		contentPane.add(textField_1);
		contentPane.add(lblNewLabel_5);
		contentPane.add(textField_4);
		contentPane.add(lblNewLabel_4);
		contentPane.add(textField_3);
		contentPane.add(lblNewLabel_3);
		contentPane.add(textField_2);
		contentPane.add(lblNewLabel_6);
		contentPane.add(textField_5);
		contentPane.add(btnNewButton_2);
		contentPane.add(btnNewButton_3);
		
		textField_4 = new JTextField();
		textField_4.setBounds(85, 164, 232, 20);
		contentPane.add(textField_4);
		textField_4.setColumns(10);
	}
}
