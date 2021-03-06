package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Controller.Controller;
import Model.Contatto;
import Model.NumeroTelefonoFisso;
import Model.NumeroTelefonoMobile;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


/**
 * La Class AggiungiNumeroTelefono permette di aggiungere uno o pi? numeri di telefono
 * a un contatto
 */
public class AggiungiNumeroTelefono extends JFrame {

	private JPanel contentPane;
	
	/** con ? la variabile associata al controller. */
	private Controller con;
	
	/** c ? la variabile usata per gestire la visibilit?. */
	private GestioneVisibilitaGUI c;
	
	/** Nel text field l'utente inserir? il numero di telefono aggiungere all'account */
	private JTextField textField;
	
	/**
	 * Create the frame.
	 *
	 * @param in ? la variabile relativa a questa finestra nella classe gestioneVisibilit?
	 * @param cin ? la variabile del controller
	 * @param scelta ? la variabile scelta che dipende da quale pulsante si ? usato per arrivare a questa finestra
	 * @param coin ? la variabile che riferisce a un contatto
	 */
	public AggiungiNumeroTelefono(GestioneVisibilitaGUI in, Controller cin, String scelta, Contatto coin) {
		c = in;
		con = cin;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblNewLabel = new JLabel("Aggiungi nuovo numero:");
		textField = new JTextField();
		textField.setColumns(10);
		
		/**
		 * Quando viene cliccato il pulsante 'ok', in base al valore di scelta che dipender?
		 * da quale pulsante si ? cliccato nella finestra precedente, il contenuto del textField
		 * verr? visualizzato come nuovo ogetto della classe NumeroTelefonoMobile e verr? passato come
		 * metodo alla funzione addNumeroContatto (funzione della classe NumeroTelefonoMobile), se la scelta ? M; 
		 * altrimenti se la scelta ? F, il contenuto del textField verr? visualizzato come 
		 * nuovo ogetto della classe NumeroTelefonoFisso e verr? passato come
		 * metodo alla funzione addNumeroContatto (funzione della classe NumeroTelefonoFisso)
		 * 
		 */
		
		JButton btnNewButton = new JButton("OK");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(scelta == "M")
				{
					NumeroTelefonoMobile n = new NumeroTelefonoMobile(textField.getText());
					boolean x = con.addNumeroContatto(coin, null, n);
					if(x == false)
					{
						JOptionPane.showMessageDialog(null, "Caratteri non validi");
					}
				}
				else if(scelta == "F")
				{
					NumeroTelefonoFisso n = new NumeroTelefonoFisso(textField.getText());
					boolean x = con.addNumeroContatto(coin, n, null);
					if(x == false)
					{
						JOptionPane.showMessageDialog(null, "Caratteri non validi per un numero telefonico");
					}
				}
				c.tryIndietroAggiungiNumeroTelefono(coin);
			}
		});
		

		/**
		 * Quando il pulsante annulla verr? cliccato si ritorner? alla schermata contatti perdendo i dati inseriti
		 */
		
		JButton btnNewButton_1 = new JButton("Annulla");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				c.tryIndietroAggiungiNumeroTelefono(coin);
			}
		});
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(129)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(textField, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 117, Short.MAX_VALUE)
						.addComponent(lblNewLabel, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
					.addGap(178))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(101)
					.addComponent(btnNewButton, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(btnNewButton_1, GroupLayout.DEFAULT_SIZE, 89, Short.MAX_VALUE)
					.addGap(135))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(22)
					.addComponent(lblNewLabel)
					.addGap(18)
					.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(27)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnNewButton_1)
						.addComponent(btnNewButton))
					.addContainerGap(127, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
	}
}
