package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Controller.Controller;
import Model.AccountMessaggistica;
import Model.Contatto;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


/**
 * La Classe AggiungiAccountMessaggistica consente l'inserimento di un account
 * di messaggistica relativi all'account che si sta creando. 
 * Il metodo pu� essere chiamato pi� volte
 */
public class AggiungiAccountMessaggistica extends JFrame {


	private JPanel contentPane;
	
	/**text field � lo spazio dove l'utente inserir� il nickname. */
	private JTextField textField;
	
	/** text field 1 � lo spazio dove l'utente inserir� l'email relativa all'account di messaggistica. */
	private JTextField textField_1;
	
	/**Text field 2 � lo spazio dove l'utente inserir� il fornitore. */
	private JTextField textField_2;
	
	/** textArea � lo spazio dove l'utente potr� inserire la frase di benvenuto*/
	private JTextArea textArea;
	
	/**con: variabile del controller */
	Controller con;
	
	/** c: variabile per gestire la visibilit�. */
	GestioneVisibilitaGUI c;
	

	/**
	 * Creazione del frame
	 *
	 * @param in � la variabile relativa a questa finestra nella classe gestioneVisibilit�
	 */
	public AggiungiAccountMessaggistica(GestioneVisibilitaGUI in, Controller cin) {
		c = in;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 553, 380);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblNewLabel = new JLabel("Inserisci informazioni per il nuovo account di messaggistica relativo al contatto");
		
		JLabel lblNewLabel_1 = new JLabel("Nickname:");
		
		textField = new JTextField();
		textField.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Email:");
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Fornitore:");
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("Frase di benvenuto:");
		
		textArea = new JTextArea();
		/**
		 * Quando il pulsante ok verr� cliccato verranno salvati tutti i dati inseriti nei vari textField
		 * in un ogetto di accountmessaggistica
		 */
		
		JButton btnNewButton = new JButton("OK");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AccountMessaggistica a= new AccountMessaggistica(textField.getText(), textField_2.getText(), textField_1.getText(), textArea.getText(),null);
				c.tryIndietroAggiungiAccountMessaggistica(a);
			}
		});
		
		/**
		 * Quando il pulsante annulla verr� cliccato si ritorner� alla schermata precedente perdendo i dati inseriti
		 * nei vai text field
		 */
		JButton btnNewButton_1 = new JButton("Annulla");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				c.tryAnnullaAggiungiAccountMessaggistica();
			}
		});
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(lblNewLabel_1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
									.addPreferredGap(ComponentPlacement.RELATED))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(lblNewLabel_2)
									.addGap(27))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(lblNewLabel_3, GroupLayout.DEFAULT_SIZE, 49, Short.MAX_VALUE)
									.addPreferredGap(ComponentPlacement.RELATED)))
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
									.addComponent(lblNewLabel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
									.addGap(137))
								.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
									.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
										.addComponent(textField, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 241, Short.MAX_VALUE)
										.addComponent(textField_2, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 241, Short.MAX_VALUE)
										.addComponent(textField_1, GroupLayout.DEFAULT_SIZE, 241, Short.MAX_VALUE))
									.addGap(269))))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(lblNewLabel_4)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGap(37)
									.addComponent(btnNewButton, GroupLayout.DEFAULT_SIZE, 47, Short.MAX_VALUE)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(btnNewButton_1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
									.addGap(303))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(textArea, GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
									.addGap(277))))))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblNewLabel)
					.addGap(34)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_1)
						.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_2)
						.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_3)
						.addComponent(textField_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(26)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_4)
						.addComponent(textArea, GroupLayout.PREFERRED_SIZE, 70, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, 44, Short.MAX_VALUE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnNewButton_1)
						.addComponent(btnNewButton))
					.addGap(20))
		);
		contentPane.setLayout(gl_contentPane);
	}
}
