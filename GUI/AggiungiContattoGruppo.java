package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.ListSelectionModel;
import javax.swing.border.EmptyBorder;

import Controller.Controller;
import Model.Gruppo;
import Model.Contatto;

import javax.swing.DefaultListModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


/**
 * The Class AggiungiContattoGruppo consente di selzionare uno per volta i contatti
 * che verranno aggiunti a un gruppo. Ogni volta che si clicca su un contatto bisognerà
 * cliccare anche il tasto seleziona, prima di passare al prossimo account da aggiungere.
 * Una volta terminata la selezione si dovrà cliccare sul tasto 'ok'
 */
public class AggiungiContattoGruppo extends JFrame {

	private JPanel contentPane;
	
	/** c: variabile per gestire la visibilità. */
	GestioneVisibilitaGUI c;
	
	/**con: variabile del controller */
	Controller con;
	
	/** contattimodel sarà una lista model. Questo consente 
	 * l'aggiornamento della finestra a ogni modifica */
	private DefaultListModel<Contatto> contattiModel = new DefaultListModel<>();
	
	/** contatti è l'array list che conterrà tutti i contatti. */
	ArrayList<Contatto> contatti = new ArrayList<Contatto>();
	
	/** The contattigruppo è l'array list che conterrà tutti i gruppi. */
	ArrayList<Contatto> contattigruppo = new ArrayList<Contatto>();
	
	/**
	 * creazione del frame
	 *
	 * @param in è la variabile relativa a questa finestra nella classe gestioneVisibilità
	 * @param cin è la variabile del controller
	 * @param gin è la variabile che riferisce a un gruppo
	 */
	public AggiungiContattoGruppo(GestioneVisibilitaGUI in, Controller cin, Gruppo gin) {
		c = in;
		con = cin;
		contatti = con.getRubricaContatti();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 548, 578);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
	
		
		JLabel lblNewLabel = new JLabel("Seleziona i contatti da aggiungere al gruppo:");
		JList list = new JList();
		contattiModel.addAll(contatti);
		list.setModel(contattiModel);
		contentPane.add(list, BorderLayout.NORTH);
		list.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
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
		
		/**
		* Quando il pulsante indietro verrà cliccato si ritornerà alla schermata
		*  precedente senza salvare i contatti selezionati nel gruppo
		*/
		JButton btnNewButton_1 = new JButton("Indietro");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				c.tryIndietroAggiungiContattoGruppo();
			}
		});
		
		
		
		JButton btnNewButton_2 = new JButton("OK");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				con.addContattoGruppo(gin, contattigruppo);
				c.tryOKAggiungiContattoGruppo(gin);
			}
		});
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(btnNewButton_1)
					.addGap(63)
					.addComponent(lblNewLabel, GroupLayout.DEFAULT_SIZE, 382, Short.MAX_VALUE)
					.addGap(123))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(btnNewButton)
					.addContainerGap(435, Short.MAX_VALUE))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(list, GroupLayout.DEFAULT_SIZE, 241, Short.MAX_VALUE)
					.addGap(271))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(190)
					.addComponent(btnNewButton_2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addGap(243))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnNewButton_1)
						.addComponent(lblNewLabel))
					.addGap(18)
					.addComponent(btnNewButton)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(list, GroupLayout.PREFERRED_SIZE, 379, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
					.addComponent(btnNewButton_2)
					.addGap(27))
		);
		contentPane.setLayout(gl_contentPane);
	}
}
