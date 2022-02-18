package Model;

import java.util.ArrayList;


/**
 * La Classe Gruppo gestisce i gruppi che potranno essere creati, modificati ed eliminati.
 */
public class Gruppo {
	
	/** Il nome del gruppo. */
	//attributi:
	private String nome;
	
	/** L'array list dei contatti. */
	private ArrayList<Contatto> contatti;
	
	/**La rubrica. */
	private Rubrica r;
	
	//metodi:
	/**
	 * Istanziazione dei un nuovo gruppo.
	 *
	 * @param name: nome del gruppo
	 * @param rub: la rubrica
	 * Istanzazione del array contatti
	 */
	public Gruppo(String name, Rubrica rub)
	{
	    nome= name;
		r= rub;
		this.contatti = new ArrayList<>();
	}
	
	/**
	 * Aggiungi contatto.
	 *
	 * @param nome: il nome del contatto
	 * @param cognome: il cognome del contatto
	 * @param età:l'età del contattp
	 * @param sesso:il sesso del contatto
	 * @param residenza:la residenza del contatto
	 * @param email:l'email del contatto
	 * @param ru: la rubrica del contatto
	 * l'array list contatto viene modificato il place
	 */
	public void aggiungiContatto(String nome, String cognome, String età, String sesso, String residenza, String email, Rubrica ru)
	{
		Contatto c = new Contatto(nome, cognome, età, sesso, residenza, email, ru);
		contatti.add(c);
	}
	
	/**
	 * Elimina contatto.
	 *
	 * @param c: il contatto che l'utende vuole eliminare dal gruppo
	 */
	public void eliminaContatto(Contatto c)
	{
		for(int i=0; i < contatti.size(); i++)
		{
			if(contatti.get(i) == c)
			{
				contatti.remove(contatti.get(i));
			}
		}
	}
	
	/**
	 * Gets and Set del nome.
	 *
	 * @return nome del gruppo
	 */
	public String getNome() {
		return nome;
	}
	
	/**
	 * Setta il nome.
	 *
	 * @param nome: nome del gruppo
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	/**
	 * Gets l'array list dei contatti
	 *
	 * @return contatti: array list dei contatti presenti nel gruppo
	 */
	public ArrayList<Contatto> getContatti() {
		return contatti;
	}
	
	/**
	 * Setta l'array list contatti.
	 *
	 * @param c: contatto da aggiungere all'array list
	 */
	public void setContatti(Contatto c) {
		this.contatti.add(c);
	}
	
	/**
	 * * Gets and Set della rubrica.
	 *
	 * @return r: la rubrica
	 */
	public Rubrica getR() {
		return r;
	}
	
	/**
	 * Setta la rubrica
	 *
	 * @param r: è la rubrica 
	 */
	public void setR(Rubrica r) {
		this.r = r;
	}
	
	/**
	 * toString è l'override dell'omonimo metodo.
	 * Restituisce la stringa nome
	 * @return nome: il nome del gruppo
	 */
	@Override
	public String toString()
	{
		return nome;
	}
}