package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Controller.Controller;
import Model.Contatto;
import Model.Gruppo;

import javax.swing.DefaultListModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Color;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.awt.event.ActionEvent;


/**
 * La Classe VisualizzaContattiGruppo permette di visualizzare i contatti del gruppo
 * Inoltre consente di aggiungere nuovi contatti a questo gruppo o di rimuoverli.
 */
public class VisualizzaContattiGruppo extends JFrame {


	private JPanel contentPane;
	
	/** è il nome del gruppo; se questa variabile viene sovrascritta e la modifica salvata
	 * il nome del gruppo sarà quello inserito. */
	private JTextField textField;
	
	/** c è la variabile che usiamo per gestire la visibilità. */
	GestioneVisibilitaGUI c;
	
	/** con è la variabile associata al controller. */
	Controller con;
	
	/** contattiMmodel è una list model che ci consente di tenere aggiornata la pagina ad ogni moodifica. */
	private DefaultListModel<Contatto> contattiModel = new DefaultListModel<>();
	
	/** contattigruppo è l'array di tutti i contatti relativi a un gruppo. */
	private ArrayList<Contatto> contattigruppo = new ArrayList<>();
	
	/**
	 *
	 *@param in è la variabile relativa a questa finestra nella classe gestioneVisibilità
	 *@param cin è la variabile del controller
	 * @param gin è la variabile del gruppo del quale si voglioni visualizzare i contatti
	 */
	public VisualizzaContattiGruppo(GestioneVisibilitaGUI in, Controller cin, Gruppo gin) {
		c = in;
		con = cin;
		contattigruppo = gin.getContatti();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 481, 542);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblNewLabel = new JLabel("Contatti presenti nel gruppo:");
		lblNewLabel.setBounds(142, 9, 184, 14);
		
		JList list = new JList();
		list.setBounds(15, 66, 281, 348);
		LinkedHashSet<Contatto> hashSet = new LinkedHashSet<>(contattigruppo);
		ArrayList<Contatto> contattigruppo = new ArrayList<>(hashSet);
		contattiModel.addAll(contattigruppo);
		list.setModel(contattiModel);
		contentPane.add(list, BorderLayout.NORTH);
		JButton btnNewButton = new JButton("Aggiungi");
		btnNewButton.setBounds(360, 34, 102, 23);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				gin.getContatti().addAll(contattigruppo);
				c.tryAggiungiContattoGruppo(gin);
			}
		});
		
		JButton btnNewButton_1 = new JButton("Rimuovi");
		btnNewButton_1.setBounds(360, 68, 102, 23);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int x;
				contattiModel.remove(x = list.getSelectedIndex());
				gin.getContatti().remove(x);
			}
		});
		btnNewButton_1.setBackground(Color.RED);
		
		textField = new JTextField(gin.getNome());
		textField.setBounds(15, 40, 96, 20);
		textField.setColumns(10);
		
		JButton btnNewButton_3 = new JButton("OK");
		btnNewButton_3.setBounds(200, 447, 96, 23);
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(textField.getText().isBlank() == false)
				{
					gin.setNome(textField.getText());
					c.tryOKVisualizzaContattiGruppo();
				}
				else
				{
					JOptionPane.showMessageDialog(null, "Inserisci un nome");
				}
			}
		});
		contentPane.setLayout(null);
		contentPane.add(list);
		contentPane.add(textField);
		contentPane.add(btnNewButton);
		contentPane.add(lblNewLabel);
		contentPane.add(btnNewButton_1);
		contentPane.add(btnNewButton_3);
	}
}
