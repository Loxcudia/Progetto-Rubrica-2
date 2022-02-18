package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Controller.Controller;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


/**
 * La Classe AggiungiNumeriSecondari consente di aggiungere un numero di telefono
 * secondario durante la creazione del'utente al quale sarà riferito.
 * Il metodo può essere chiamato più volte
 */
public class AggiungiNumeriSecondari extends JFrame {


	private JPanel contentPane;

	/** tipo è larray di dimensione 2 di stringhe con la quale controlleremo la tipologia del numero di telefono inserito del contatto. */
	String[] tipo = {"Fisso", "Mobile"};
	
	/** combobox è il menù a tendina all'interno del quale l'utente selezionerà la tipologia del numero di telefono inserito. */
	private JComboBox combobox= new JComboBox(tipo);
	
	/** Nel text field verrà inserito il numero di telefono. */
	private JTextField textField;
	
	/** con è la variabile che si riferisce al controller. */
	Controller con;
	
	/** c è la variabile usata per la gestione della visibilità. */
	GestioneVisibilitaGUI c;
	
	/**
	 * Creazione del frame.
	 *
	 *@param in è la variabile relativa a questa finestra nella classe gestioneVisibilità
	 *@param cin è la variabile del controller
	 */
	public AggiungiNumeriSecondari(GestioneVisibilitaGUI in, Controller cin) {
		c = in;
		con = cin;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 580, 376);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblNewLabel = new JLabel("Inserisci i nuovi numeri e la loro tipologia:");
		
		JLabel lblNewLabel_1 = new JLabel("Numero:");
		
		JLabel lblNewLabel_2 = new JLabel("Tipologia:");
		
		textField = new JTextField();
		
		/**
		 * Quando il pulsante ok verrà cliccato verrà passato il numero di telefono e la
		 * sua tipologia alla funzione AggiungiNumeroSecondario
		 * Se i caratteri inseriti non sono validi verrà aperto un pop-up che spiega l'errore
		 */
		
		JButton btnNewButton = new JButton("OK");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(con.isNumeric(textField.getText()) == true)
				{
					if(combobox.getSelectedItem().equals("Fisso"))
					{
						c.AggiuntaNumeroSecondario("F", textField.getText());
					}
					else
					{
						c.AggiuntaNumeroSecondario("M", textField.getText());
					}
				}
				else
				{
					JOptionPane.showMessageDialog(null, "Caratteri non validi per un numero telefonico");
				}
			}
		});
		
		/**
		 * Quando il pulsante annulla verrà cliccato si ritornerà alla schermata precedente perdendo i dati inseriti
		 */
		
		JButton btnNewButton_1 = new JButton("Annulla");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				c.tryIndietroAggiungiNumeriSecondari();
			}
		});
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNewLabel_1, GroupLayout.DEFAULT_SIZE, 53, Short.MAX_VALUE)
						.addComponent(lblNewLabel_2, GroupLayout.DEFAULT_SIZE, 53, Short.MAX_VALUE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(combobox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(textField, GroupLayout.PREFERRED_SIZE, 128, GroupLayout.PREFERRED_SIZE))
					.addGap(363))
				.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addGroup(Alignment.LEADING, gl_contentPane.createSequentialGroup()
							.addGap(162)
							.addComponent(btnNewButton, GroupLayout.DEFAULT_SIZE, 95, Short.MAX_VALUE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(btnNewButton_1, GroupLayout.PREFERRED_SIZE, 87, Short.MAX_VALUE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(166)
							.addComponent(lblNewLabel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
					.addGap(196))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblNewLabel)
					.addGap(29)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_1)
						.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(33)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_2)
						.addComponent(combobox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(65)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnNewButton_1)
						.addComponent(btnNewButton))
					.addContainerGap(110, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
	}
}
