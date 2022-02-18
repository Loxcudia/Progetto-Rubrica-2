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
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


/**
 * La Classe ModificaNumeroTelefono consete la modifica di un numero telefonico.
 */
public class ModificaNumeroTelefono extends JFrame {

	private JPanel contentPane;
	
	/** con � la variabile associata al controller. */
	private Controller con;
	
	/** c � la variabile che usiamo per gestire la visibilit� delle finestre */
	private GestioneVisibilitaGUI c;
	
	/** textField � la variabile dove verr� inserito il nuovo numero di telefono. */
	private JTextField textField;

	/**
	 * Instantiates a new modifica numero telefono.
	 *
	  *@param in � la variabile relativa a questa finestra nella classe gestioneVisibilit�
	 * @param cin � la variabile del controller
	 * @param nfin � la variabile associata al numero di telefono fisso
	 * @param nmin � la variabile associata al numero di telefono mobile
	 * @param coin � la variabile associata al contatto al quale � associato il numero di telefono
	 */
	public ModificaNumeroTelefono(GestioneVisibilitaGUI in, Controller cin, NumeroTelefonoFisso nfin, NumeroTelefonoMobile nmin, Contatto coin) {
		c= in;
		con = cin;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 572, 352);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblNewLabel = new JLabel("Modifica Numero Telefono:");
		
		textField = new JTextField();
		textField.setColumns(10);
		
		
		/**
		 * 	La funzione il base al valore del paramentro passato in imput chiamer� il metodo SetNumero o della classe
		 *  NumeroTelefonoFisso o NumeroTelefonoMobile. Se non viene inserito nessun numero si torna alla schermata precedente
		 */
		JButton btnNewButton = new JButton("OK");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(nmin == null)
				{
					if(nfin.getNumero() != textField.getText())
					{
						nfin.setNumero(textField.getText());
					}
					c.tryIndietroModificaNumero(coin);
				}
				else if(nfin == null)
				{
					if(nmin.getNumero() != textField.getText())
					{
						nmin.setNumero(textField.getText());
					}
					c.tryIndietroModificaNumero(coin);
				}
			}
		});
		
		JButton btnNewButton_1 = new JButton("Annulla");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				c.tryIndietroModificaNumero(coin);
			}
		});
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(123)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 98, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(btnNewButton_1, GroupLayout.PREFERRED_SIZE, 118, GroupLayout.PREFERRED_SIZE))
						.addComponent(textField, GroupLayout.PREFERRED_SIZE, 237, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(186, Short.MAX_VALUE))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(179)
					.addComponent(lblNewLabel, GroupLayout.DEFAULT_SIZE, 219, Short.MAX_VALUE)
					.addGap(239))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(19)
					.addComponent(lblNewLabel)
					.addGap(18)
					.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(105)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnNewButton)
						.addComponent(btnNewButton_1))
					.addContainerGap(104, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
	}
}
