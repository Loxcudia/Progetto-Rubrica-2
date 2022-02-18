package Model;

import java.util.ArrayList;

/**
 * La classe Contatto.
 */
public class Contatto {
	
	/** il nome del contatto. */
	private String nome;
	
	/** il cognome del contatto. */
	private String cognome;
	
	/** l'età del contatto. */
	private String età;
	
	/** il sesso del contatto; potrà assumere solo tre valori Maschio, Femmina e non binario. */
	private String sesso;
	
	/** la residenza del contatto. */
	private String residenza;
	
	/** l'email del contatto. */
	private String email;
	
	
	/**Gli account di messagistica del contatto. */
	private ArrayList<AccountMessaggistica> accountm;
	
	/**La rubrica del contatto. */
	private Rubrica rub;
	
	/** I numeritelefonici fissi del contatto. */
	private ArrayList<NumeroTelefonoFisso> numeritelefonicif;
	
	/** I numeritelefonici mobili del contatto. */
	private ArrayList<NumeroTelefonoMobile> numeritelefonicim;
	
	/**
	 * Istanziazione di un nuovo contatto.
	 * L'inserimento è effettuato in place
	 *
	 * @param nome
	 * @param cognome
	 * @param età
	 * @param sesso 
	 * @param indirizzo di residenza
	 * @param email
	 * Infine il metodo Contatto inizializzi gli array: NumeroTelefonoFisso,
	 * NumeroTelefonoMobile e AccountMessaggistica
	 */
	public Contatto(String name, String surname, String age, String sex, String residence, String em, Rubrica r)
	{
		nome= name;
		cognome= surname;
		età= age;
		sesso= sex;
		residenza= residence;
		email= em;
		rub= r;
		numeritelefonicif = new ArrayList<NumeroTelefonoFisso>();
		numeritelefonicim = new ArrayList<NumeroTelefonoMobile>();	
		accountm = new ArrayList<AccountMessaggistica>();
	}
	
	/**
	* Gets and Sets della variabile rubrica.
	 *
	 * @return nome
	 */

	public Rubrica getRub() {
		return rub;
	}
	/**
	 * Setta la rubrica.
	 *
	 * @return rubrica
	 */
	
	public void setRub(Rubrica rub) {
		this.rub = rub;
	}
	
	/**
	 * Gets and Sets della variabile nome del contatto.
	 * @return nome
	 */
	public String getNome()
	{
		return nome;
	}
	
	/**
	 * Setta il nome del contatto
	 *
	 * @param n: Stringa contenente il nome del contatto
	 */
	public void setNome(String n)
	{
		nome = n;
	}
	
	/**
	 * Gets and Sets della variabile cognome del contatto.
	 *
	 * @return cognome
	 */
	public String getCognome() {
		return cognome;
	}
	
	/**
	 * Setta il cognome
	 *
	 * @param c: stringa contenente il cognome del contatto
	 */
	public void setCognome(String c) {
		cognome = c;
	}
	
	/**
	 * Gets and Sets della variabile età del contatto.
	 *
	 * @return età
	 */
	public String getEtà() {
		return età;
	}
	
	/**
	 * Setta l'età
	 *
	 * @param e: stringa contenente l'età del contatto
	 */
	public void setEtà(String e) {
		età = e;
	}
	
	/**
	 * Gets and Sets della variabile sesso del contatto.
	 *
	 * @return sesso
	 */
	public String getSesso() {
		return sesso;
	}
	
	/**
	 * Setta il sesso
	 *
	 * @param s: stringa contenente il sesso del contatto
	 */
	public void setSesso(String s) {
		sesso = s;
	}
	
	/**
	 * Gets and Sets della variabile residenza del contatto.
	 *
	 * @return residenza
	 */
	public String getResidenza() {
		return residenza;
	}
	
	/**
	 * Setta la residenza.
	 *
	 * @param r: stringa contenente la residenza del contatto
	 */
	public void setResidenza(String r) {
		this.residenza = r;
	}
	
	/**
	 * Gets and Sets della variabile email del contatto.
	 *
	 * @return email
	 */
	public String getEmail() {
		return email;
	}
	
	/**
	 * Setta l'email.
	 *
	 * @param e: stringa contenente l'email del contatto
	 */
	public void setEmail(String e) {
		email = e;
	}

	/**
	 * Gets and Sets dell' array che contiene gli account di messaggistica del contatto.
	 * @return Array di account
	 */
	public ArrayList<AccountMessaggistica> getAccountm() {
		return this.accountm;
	}
	
	/**
	 * Setta l'array degli account di messaggistica
	 *
	 * @param am: stringa contenente l'account di messaggistica del contatto
	 */
	public void setAccountm(AccountMessaggistica am) {
		this.accountm.add(am);
		am.setC(this);
	}
	
	
	
	/**
	* Gets and Sets della variabile NumeritelefoniciF del contatto.
	 *
	 * @return il numeritelefonico fisso
	 */
	public ArrayList<NumeroTelefonoFisso> getNumeritelefonicif() {
		return numeritelefonicif;
	}
	
	/**
	 * Setta il numeritelefonico fisso.
	 *
	 * @param nt: stringa contenente il numeritelefonico fisso da aggiungere a numeri telefonici
	 */
	public void setNumeritelefonicif(NumeroTelefonoFisso nt) {
		numeritelefonicif.add(nt);
	}
	
	/**
	 * Gets and Sets della variabile NumeritelefoniciM del contatto.
	 *
	 * @return il numero telefonico mobile
	 */
	public ArrayList<NumeroTelefonoMobile> getNumeritelefonicim() {
		return numeritelefonicim;
	}
	
	/**
	 * Setta il numeritelefonico mobile.
	 *
	 * @param nt: stringa contenente il numeritelefonico mobile da aggiungere a numeri telefonici
	 **/
	public void setNumeritelefonicifm(NumeroTelefonoMobile nt) {
		this.numeritelefonicim.add(nt);
		nt.setContatti(this);
	}
	
	/**
	 *toString è l'override del metodo toString(), usata per ritornare la
	 *concatenazione tra il @return nome e il @return cognome del contatto.
	 *
	 * @return concatenazione di nome e cognome del contatto.
	 */
	@Override
	public String toString()
	{
		return nome + " " + cognome;
	}
	
	/**
	 * Il metodo getInfo è utilizzato per concatenare tra loro le stringhe 
	 * delle variabili @return nome, @return cognome, @return email 
	 * @return età, @return sesso, @return residenza
	 * tutte precedute dal significato che ha la variabile e dai due punti
	 * @return concatenazione delle stringhe: nome, cognome, email, età , sesso, residenza
	 */
	public String getInfo()
	{
		return "Nome: " + nome + ", Cognome: " + cognome + ", Email: " + email + ", Età: " + età + ", Sesso: " + sesso + ", Residenza: " + residenza + ".";
	}
}