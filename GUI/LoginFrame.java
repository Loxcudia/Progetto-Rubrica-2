package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Controller.Controller;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


/**
 * La Classe LoginFrame serve per far effettuare un login all'utente
 */
public class LoginFrame extends JFrame {


	private JPanel contentPane;
	
	/** text field � la variabile dove l'utente inserir� il nickname */
	private JTextField textField;
	
	/** text field 1 � la variabile dove l'utente inserir� il suo numero telefonico */
	private JTextField textField_1;
	
	/** c � la variabile che usiamo per gestire la visibilit� */
	private GestioneVisibilitaGUI c;
	
	/** con e la variabile associata al controller. */
	Controller con;
	

	/**
	 * Creazione del frame per il login.
	 *
	 * @param in � la variabile relativa a questa finestra nella classe gestioneVisibilit�
	 */
	public LoginFrame(Controller in)
	{
		con = in;
		c = new GestioneVisibilitaGUI(this, con);
		initialize(c);
	}

	public void initialize(GestioneVisibilitaGUI in) {
		c = in;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblNewLabel = new JLabel("Nickname");
		
		JLabel lblNewLabel_1 = new JLabel("Numero Telefonico");
		
		textField = new JTextField();
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		
		/**
		 * quando viene premuto il pulsante 'ok' il programma controller� che il nickname non sia vuoto o composto
		 * da soli spazi e il numero di telefono sia composto da soli numeri; in tal caso chiamer� la funzione trylogin 
		 * della classe GestioneVisibilit�. In caso contrario apre un pop-up che segnala l'errore
		 */
		
		JButton btnNewButton = new JButton("OK");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(con.isNumeric(textField_1.getText()) == true && textField.getText().isBlank() == false)
				{
					c.tryLogin(textField.getText(), textField_1.getText());
				}
				else
				{
					JOptionPane.showMessageDialog(null, "Nickname o numero di telefono non validi");
				}
			}
		});
		
		JLabel lblNewLabel_2 = new JLabel("Benvenuto!");
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(149)
							.addComponent(btnNewButton, GroupLayout.DEFAULT_SIZE, 89, Short.MAX_VALUE)
							.addGap(15))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addContainerGap()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(lblNewLabel_1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(lblNewLabel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
									.addGap(44)))
							.addGap(18)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(textField, GroupLayout.DEFAULT_SIZE, 136, Short.MAX_VALUE)
								.addComponent(textField_1, GroupLayout.DEFAULT_SIZE, 136, Short.MAX_VALUE))))
					.addGap(171))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(150)
					.addComponent(lblNewLabel_2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addGap(218))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(lblNewLabel_2)
					.addGap(9)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addComponent(lblNewLabel)
						.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 18, GroupLayout.PREFERRED_SIZE))
					.addGap(66)
					.addComponent(btnNewButton)
					.addContainerGap(93, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
	}
}
