package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JComboBox;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;

/**
 * La Classe Menu permette all'utente di scegliere se visualizzare i contatti o i gruppi e in tal caso in che ordine.
 */
public class Menu extends JFrame {

	private JPanel contentPane;
	
	/** c è la variabile che usiamo per gestire la visibilità. */
	private GestioneVisibilitaGUI c;
	
	/** The contatti. */
	public boolean cresc, contatti;


	public Menu(GestioneVisibilitaGUI in) {
		c = in;
		String nick = c.getNickname();
		String msg = "Ciao " + nick + "!";
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 386, 610);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		String[] visualizzaPer = {"Contatti", "Gruppi"};
		String[] visualizzaOrdine = {"Crescente", "Decrescente"};
		JComboBox comboBox = new JComboBox(visualizzaPer);
		
		JComboBox comboBox_1 = new JComboBox(visualizzaOrdine);
		
		JLabel lblNewLabel = new JLabel("Visualizza per: ");
		
		JLabel lblNewLabel_1 = new JLabel("Ordine:");
		
		JLabel lblNewLabel_2 = new JLabel(msg);
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		
		/**
		 * Quando l'utente clicca il tasto 'ok' allora il programma in base alle selezioni effettuate nei due menù
		 * assegnerà dei valori buleani alle variabile contatti e cresc. Senza che l'utente selezioni le due variabili
		 * avranno entrambe il valore true. 		
		 */
		
		JButton btnNewButton = new JButton("OK");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			if(comboBox.getSelectedItem().equals("Contatti"))
			{
				contatti = true;
			}
			else
				contatti = false;
			if(comboBox_1.getSelectedItem().equals("Crescente"))
			{
				cresc = true;
			}
			else
				cresc = false;
			c.contattiOrGruppi(contatti, cresc);
			}
		});
		
		JButton btnNewButton_1 = new JButton("Indietro");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				c.tryIndietroMenu();
			}
		});
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(btnNewButton_1, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(253, Short.MAX_VALUE))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblNewLabel_2, GroupLayout.DEFAULT_SIZE, 343, Short.MAX_VALUE))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(35)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addComponent(lblNewLabel_1)
						.addComponent(lblNewLabel))
					.addGap(42)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(btnNewButton)
							.addContainerGap())
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
								.addComponent(comboBox_1, Alignment.LEADING, 0, 109, Short.MAX_VALUE)
								.addComponent(comboBox, Alignment.LEADING, 0, 109, Short.MAX_VALUE))
							.addGap(92))))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(btnNewButton_1)
					.addGap(7)
					.addComponent(lblNewLabel_2)
					.addGap(34)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(comboBox_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_1))
					.addGap(38)
					.addComponent(btnNewButton)
					.addContainerGap(373, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
	}
}
