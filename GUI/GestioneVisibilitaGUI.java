package GUI;
import java.util.ArrayList;


import Controller.Controller;
import Model.AccountMessaggistica;
import Model.Contatto;
import Model.Gruppo;
import Model.NumeroTelefonoFisso;
import Model.NumeroTelefonoMobile;
import Model.Rubrica;
// TODO: Auto-generated Javadoc

/**
 * The Class GestioneVisibilitaGUI.
 */
public class GestioneVisibilitaGUI {
	
	/**c è la variabile del controller. */
	//attributi:
	private Controller c;
	
	/** r è la variabile della rubrica. */
	private Rubrica r;
	
	/** nickname è la variabile del nickname dell'utente. */
	private String nickname;
	
	/** numero è la variabile del numero telefonico dell'utente. */
	private String numero;
	
	/** numeri secondari è l'array list dei numeri telefonici secondari. */
	private ArrayList<String> numeriSecondari = new ArrayList<>();
	
	/** accountm è l'arraylist degli account di messaggistica. */
	private ArrayList<AccountMessaggistica> accountm = new ArrayList<>();
	
	/** con è la variabile buleana usata per controllare se l'utente vuole visualizzare
	 * i contatti o i gruppi. */
	private boolean con;
	
	/** The cre è la variabile buleana usata per controllare se l'utente vuole visualizzare
	 * i dati in ordine crescente o decrescente. */
	private boolean cre = true;
	
	/** i è la variabile usata per gestire la visibilità della finestra LoginFrame. */
	private LoginFrame i;
	
	/** m è la variabile usata per gestire la visibilità della finestra Menu. */
	private Menu m;
	
	/** The sc. */
	private SchermataContatti sc;
	
	/** sg è la variabile usata per gestire la visibilità della finestra SchermataGruppi. */
	private SchermataGruppi sg;
	
	/**ci è la variabile usata per gestire la visibilità della finestra CreaC. */
	private CreaC ci;
	
	/** mc è la variabile usata per gestire la visibilità della finestra ModificaContatto. */
	private ModificaContatto mc;
	
	/** vcm è la variabile usata per gestire la visibilità della finestra VisualizzaContattoNumeri. */
	private VisualizzaContattoNumeri vcm;
	
	/** ans è la variabile usata per gestire la visibilità della finestra AggiungiNumeriSecondari. */
	private AggiungiNumeriSecondari ans;
	
	/** mnf è la variabile usata per gestire la visibilità della finestra ModificaNumeroTelefono. */
	private ModificaNumeroTelefono mnf;
	
	/** anf è la variabile usata per gestire la visibilità della finestra AggiungiNumeroFisso. */
	private AggiungiNumeroTelefono anf;
	
	/** aam è la variabile usata per gestire la visibilità della finestra AggiungiAccountMessaggistica. */
	private AggiungiAccountMessaggistica aam;
	
	/** vcam è la variabile usata per gestire la visibilità della finestra VisualizzaContattoACcountMessaggisticca. */
	private VisualizzaContattoAccountMessaggistica vcam;
	
	/** aam2 è la variabile usata per gestire la visibilità della finestra AggiungiAccountMessaggistica2 . */
	private AggiungiAccountMessaggistica2 aam2;
	
	/** mam è la variabile usata per gestire la visibilità della finestra ModificaAccountMessaggistica . */
	private ModificaAccountMessaggistica mam;
	
	/** cg è la variabile usata per gestire la visibilità della finestra CreaGruppo. */
	private CreaGruppo cg;
	
	/** vcg. è la variabile usata per gestire la visibilità della finestra VisualizzaContattiGruppi */
	private VisualizzaContattiGruppo vcg;
	
	/** acg è la variabile usata per gestire la visibilità della finestra AggiungiContattoGruppo. */
	private AggiungiContattoGruppo acg;
	
	/**
	 * Metodi per la gestione della visibilita della GUI.
	 *
	 * @param in the in
	 * @param cin the cin
	 */
	//metodi:
	public GestioneVisibilitaGUI(LoginFrame in, Controller cin) {
		i = in;
		c = cin;
		in.setVisible(true);
	}
	
	/**
	 * Try login. Il metodo del login.
	 * vengono effettuati dei controlli per essere sicuri di non avere
	 * il nickname e il numero telefonico composto da spazzi o vuoto
	 *
	 * @param username l'username dell'utente
	 * @param num il numero di telefono dell'utente
	 */
	public void tryLogin(String username, String num)
	{
		
		nickname = username;
		numero = num;
		if(!((nickname.isBlank()) || (numero.isBlank())))
		{
			m = new Menu(this);
			i.setVisible(false);
			m.setVisible(true);
		}
	}
	
	/**
	 * Contatti or gruppi. Questo metodo serve per capire se l'utente vuole vedere
	 * i contatti o i gruppi e in quale ordine
	 *
	 * @param x parametro per sapere se si deve aprire la pagina dei contatti o quella dei gruppi
	 * @param y parametro per sapere se i dati devono essere visualizzati in ordine crescente o decrescente
	 */
	public void contattiOrGruppi(boolean x, boolean y)
	{
		con = x;
		cre = y;
		if(con == true)
		{
			if(cre == true)
			{
				r = c.getRubricaOrdinataCresc();
				sc = new SchermataContatti(this, this.c, true);
				m.setVisible(false);
				sc.setVisible(true);
			}
			else
			{
				r = c.getRubricaOrdinataDesc();
				sc = new SchermataContatti(this, this.c, false);
				m.setVisible(false);
				sc.setVisible(true);
			}
		}
		else
		{
			if(cre == true)
			{
				sg = new SchermataGruppi(this, this.c, true);
				m.setVisible(false);
				sg.setVisible(true);
			}
			else
			{
				sg = new SchermataGruppi(this, this.c, false);
				m.setVisible(false);
				sg.setVisible(true);
			}
		}
	}
	
	/**
	 * TrycreaC è il metodo che si occupa di gestire la visibilità della schermata contatti e creac 
	 */
	public void tryCreaC()
	{
		sc.setVisible(false);
		ci = new CreaC(this, this.c);
		ci.setVisible(true);
	}
	
	/**
	 * Crea contatto. Questo metodo si occupa di gestire la visibilità
	 * dalla finestra creac a quella contatti.
	 * Usa un controllo sul nome e cognome per non averli entrambi vuoti o contenenti
	 * soli spazi bianchi
	 *
	 * @param nome: il nome del contatto 
	 * @param cognome: il cognome del contatto
	 * @param numf: il numero fisso del contatto
	 * @param numc: il numero mobile del contatto
	 */
	public void creaContatto(String nome, String cognome, String numf, String numc)
	{
		if ((!nome.isBlank())||(!cognome.isBlank()))
		{
			ci.setVisible(false);
			sc = new SchermataContatti(this, this.c, cre);
			sc.setVisible(true);
		}
	}
	
	/**
	 * Trymodificacontatto è il metodo che gestisce la visibilità dalla finestra
	 * ModificaContatto a SchermataContatti
	 *
	 * @param co il contatto da modificare
	 */
	public void tryModificaContatto(Contatto co)
	{
		mc = new ModificaContatto(this, co, this.r, this.c);
		mc.setVisible(true);
		sc.setVisible(false);
	}
	
	/**
	 * Trymodificacontatto2  è il metodo che gestisce la visibilità dalla 
	 * finestra ModificaContatto a SchermataContatto
	 */
	public void tryModificaContatto2()
	{
		mc.setVisible(false);
		sc= new SchermataContatti(this, this.c, cre);
		sc.setVisible(true);
	}
	
	/**
	 * Tryvisualizzanumeri è il metodo che gestisce la visibilità dalla 
	 * finestra SChermataContatto a VisualizzaContattoNumeri
	 *
	 * @param in è il contatto di cui si vogliono visualizzare i numeri
	 */
	public void tryVisualizzaNumeri(Contatto in)
	{
		sc.setVisible(false);
		vcm = new VisualizzaContattoNumeri(this.c, this, in);
		vcm.setVisible(true);
	}
	
	/**
	 * Tryindietromenu è il metodo che gestisce la visibilità dalla finestra Menù a LoginFrame
	 */
	public void tryIndietroMenu()
	{
		m.setVisible(false);
		i = new LoginFrame(this.c);
		i.setVisible(true);
	}
	
	/**
	 * Tryindietroschermatacontatti è il metodo che gestisce la visibilità
	 *  dalla finestra SchermataContatti a Menù
	 */
	public void tryIndietroSchermataContatti()
	{
		sc.setVisible(false);
		m = new Menu(this);
		m.setVisible(true);
	}
	
	/**
	 * TryindietrocreaC è il metodo che gestisce la visibilità dalla finestra
	 * CreaC a SchermataContatti
	 */
	public void tryIndietroCreaC()
	{
		ci.setVisible(false);
		sc= new SchermataContatti(this, this.c, cre);
		sc.setVisible(true);
	}
	
	/**
	 * Tryindietromodificacontatto è il metodo che gestisce la visibilità dalla 
	 * finestra ModificaContatto a SchermataContatti
	 */
	public void tryIndietroModificaContatto()
	{
		mc.setVisible(false);
		sc = new SchermataContatti(this, this.c, cre);
		sc.setVisible(true);
	}
	
	/**
	 * Tryindietrovisualizzacontattonumeri è il metodo che gestisce la visibilità 
	 * dalla finestra VisualizzaContattoNumeri a SchermataContatti
	 */
	public void tryIndietroVisualizzaContattoNumeri()
	{
		vcm.setVisible(false);
		sc= new SchermataContatti(this, this.c, cre);
		sc.setVisible(true);
	}
	
	/**
	 * Tryaggiunginumerisecondari è il metodo che gestisce la visibilità 
	 * dalla finestra CreaC a AggiungiNumeriSecondari
	 */
	public void tryAggiungiNumeriSecondari()
	{
		ci.setVisible(false);
		ans = new AggiungiNumeriSecondari(this, this.c);
		ans.setVisible(true);
	}
	
	/**
	 * AggiuntaNumeroSecondario. è il metodo che gestisce la visibilità 
	 * dalla finestra AggiungiNumeriSecondari a CreaC.	 *
	 * @param in è la stringa che rappresenta il tipo del numero telefonico
	 * @param in2 è la stringa che rappresenta il numero telefonico
	 */
	public void AggiuntaNumeroSecondario(String in, String in2)
	{
		ans.setVisible(false);
		numeriSecondari.add(in + in2);
		ci.setVisible(true);
	}
	
	/**
	 * TryModificaNumerofisso. è il metodo che gestisce la visibilità 
	 * dalla finestra VisualizzaContattoNumeri a ModificaNumeroTelefono
	 *
	 * @param in è il numero di telefono fisso che si vuole modificare
	 * @param conin è il contatto a cui corrisponde 'in'
	 */
	public void tryModificaNumeroFisso(NumeroTelefonoFisso in, Contatto conin)
	{
		vcm.setVisible(false);
		mnf = new ModificaNumeroTelefono (this, this.c, in, null, conin);
		mnf.setVisible(true);
	}
	
	/**
	 * TryModificaNumeroMobile è il metodo che gestisce la visibilità 
	 * dalla finestra VisualizzaContattoNumeri a ModificaNumeroTelefono
	 *
	 * @param in è il numero di telefono mobile che si vuole modificare
	 * @param conin è il contatto a cui corrisponde 'in'
	 */
	public void tryModificaNumeroMobile(NumeroTelefonoMobile in, Contatto conin)
	{
		vcm.setVisible(false);
		mnf = new ModificaNumeroTelefono (this, this.c, null, in, conin);
		mnf.setVisible(true);
	}
	
	/**
	 * TryIndietroModificaNumero è il metodo che gestisce la visibilità 
	 * dalla finestra ModificaNumeroTelefono a VisualizzaContattoNumeri
	 * @param conin è il contatto a cui corrisponde il numero di telefono
	 */
	public void tryIndietroModificaNumero(Contatto conin)
	{
		mnf.setVisible(false);
		vcm = new VisualizzaContattoNumeri(this.c, this, conin);
		vcm.setVisible(true);
	}
	
	/**
	 * TryAggiungiNumeroTelefono è il metodo che gestisce la visibilità 
	 * dalla finestra VisualizzaContattoNumero a AggiungiNumeroTelefono
	 *
	 * @param conin il contatto a cui corrisponde il numero di telefono
	 * @param scelta: fisso se è un numero fisso, mobile altrimenti
	 */
	public void tryAggiungiNumeroTelefono(Contatto conin, String scelta)
	{
		vcm.setVisible(false);
		anf = new AggiungiNumeroTelefono(this, this.c, scelta, conin);
		anf.setVisible(true);
	}
	
	/**
	 * TryIndietroAggiungiNumeroTelefono è il metodo che gestisce la visibilità 
	 * dalla finestra AggiungiNumeroTelefono a VisualizzaContattoNumeri
	 *
	 * @param conin il contatto al quale corrisponde il numero di telefono
	 */
	public void tryIndietroAggiungiNumeroTelefono(Contatto conin)
	{
		anf.setVisible(true);
		vcm = new VisualizzaContattoNumeri(this.c, this, conin);
		vcm.setVisible(true);
	}
	
	/**
	 * TryIndietroAggiungiNumeriSecondari. è il metodo che gestisce la visibilità 
	 * dalla finestra AggiungiNumeriSecondari a CreaC
	 */
	public void tryIndietroAggiungiNumeriSecondari()
	{
		ans.setVisible(false);
		ci.setVisible(true);
	}
	
	/**
	 * TryAggiungiAccountMessaggistica è il metodo che gestisce la visibilità 
	 * dalla finestra CreaC a AggiungiAccountMessaggistica
	 */
	public void tryAggiungiAccountMessaggistica()
	{
		ci.setVisible(false);
		aam = new AggiungiAccountMessaggistica(this, this.c);
		aam.setVisible(true);
	}
	
	/**
	 * TryIndietroAggiungiAccountMessaggistica è il metodo che gestisce la visibilità 
	 * dalla finestra AggiungiAccountMessaggistica a CreaC
	 *
	 * @param in L'account di messaggistica corrispondente al contatto
	 */
	public void tryIndietroAggiungiAccountMessaggistica(AccountMessaggistica in)
	{
		aam.setVisible(false);
		accountm.add(in);
		ci.setVisible(true);
	}
	
	/**
	 * TryVisualizzaContattoAccountMessaggistica è il metodo che gestisce la visibilità 
	 * dalla finestra SchermataContatti a VisualizzaContattoAccountMessaggistica
	 *
	 * @param coin il contatto a cui corrisponde l'account di messaggistica
	 */
	public void tryVisualizzaContattoAccountMessaggistica(Contatto coin)
	{
		sc.setVisible(false);
		vcam = new VisualizzaContattoAccountMessaggistica(this, this.c, coin);
		vcam.setVisible(true);
	}
	
	/**
	 * TryAggiungiAccountMessaggistica2 è il metodo che gestisce la visibilità 
	 * dalla finestra VisualizzaContattoAccountMessaggistica a SchermataContatti
	 *
	 * @param coin il contatto a cui corrisponde l'account di messaggistica
	 */
	public void tryAggiungiAccountMessaggistica2(Contatto coin)
	{
		vcam.setVisible(false);
		aam2 = new AggiungiAccountMessaggistica2(this, this.c, coin);
		aam2.setVisible(true);
	}
	
	/**
	 * TryIndietroAggiungiAccountMessaggistica2 è il metodo che gestisce la visibilità 
	 * dalla finestra AggiungiAccountMessaggistica2 a VisualizzaContattoAccountMessaggistica
	 *
	 * @param coin il contatto a cui corrisponde l'account di messaggistica
	 */
	public void tryIndietroAggiungiAccountMessaggistica2(Contatto coin)
	{
		aam2.setVisible(false);
		vcam = new VisualizzaContattoAccountMessaggistica(this, this.c, coin);
		vcam.setVisible(true);
	}
	
	/**
	 * TryIndietroVisualizzaContattoAccountMessaggistica è il metodo che gestisce 
	 * la visibilità dalla finestra VisualizzaContattoAccountMessaggistica a SchermataContatti
	 */
	public void tryIndietroVisualizzaContattoAccountMessaggistica()
	{
		vcam.setVisible(false);
		sc = new SchermataContatti(this, this.c, cre);
		sc.setVisible(true);
	}
	
	/**
	 * TryAnnullaAggiungiAccountMessaggistica è il metodo che gestisce la visibilità 
	 * dalla finestra AggiungiAccountMessaggistica a CreaC
	 */
	public void tryAnnullaAggiungiAccountMessaggistica()
	{
		aam.setVisible(false);
		ci.setVisible(true);
	}
	
	/**
	 * TryModificaAccountMessaggistica è il metodo che gestisce la visibilità 
	 * dalla finestra VisualizzaContattoAccountMessaggistica a ModificaAccountMessaggistica
	 *
	 * @param in l'account di messaggistica da modificare
	 */
	public void tryModificaAccountMessaggistica(AccountMessaggistica in)
	{
		vcam.setVisible(false);
		mam = new ModificaAccountMessaggistica(this, this.c, in);
		mam.setVisible(true);
	}
	
	/**
	 * TryOKModificaAccountMessaggistica è il metodo che gestisce la visibilità 
	 * dalla finestra ModificaAccountMessaggistica a VisualizzaContattoAccountMessaggistica
	 *
	 * @param coin il contatto a cui corrisponde l'account di messaggistica
	 */
	public void tryOKModificaAccountMessaggistica(Contatto coin)
	{
		mam.setVisible(false);
		vcam = new VisualizzaContattoAccountMessaggistica(this, this.c, coin);
		vcam.setVisible(true);
	}
	
	/**
	 * TryAnnullaAggiungiAccountMessaggistica2 è il metodo che gestisce la visibilità 
	 * dalla finestra AggiungiAccountMessaggistica2 a VisualizzaContattoAccountMessaggistica
	 */
	public void tryAnnullaAggiungiAccountMessaggistica2()
	{
		aam2.setVisible(false);
		vcam.setVisible(true);
	}
	
	/**
	 * TryAnnullaModificaAccountMessaggistica è il metodo che gestisce la visibilità 
	 * dalla finestra ModificaAccountMessaggistica a VisualizzaContattoAccountMessaggistica
	 */
	public void tryAnnullaModificaAccountMessaggistica()
	{
		mam.setVisible(false);
		vcam.setVisible(true);
	}
	
	/**
	 * TryCreaGruppo. è il metodo che gestisce la visibilità dalla finestra
	 * SchermataGruppi a CreaGruppo
	 */
	public void tryCreaGruppo()
	{
		sg.setVisible(false);
		cg = new CreaGruppo(this, this.c);
		cg.setVisible(true);
	}
	
	/**
	 * TryIndietroSchermataGruppi è il metodo che gestisce la visibilità 
	 * dalla finestra SchermataGruppi a Menù
	 */
	public void tryIndietroSchermataGruppi()
	{
		sg.setVisible(false);
		m.setVisible(true);
	}
	
	/**
	 * TrAnnullaCreaGruppo è il metodo che gestisce la visibilità 
	 * dalla finestra CreaGruppo a SchermataGruppi
	 */
	public void tryAnnullaCreaGruppo()
	{
		cg.setVisible(false);
		sg.setVisible(true);
	}
	
	/**
	 * TrSalvaGruppo è il metodo che gestisce la visibilità 
	 * dalla finestra CreaGruppo a SchermataGruppi
	 */
	public void trySalvaGruppo()
	{
		cg.setVisible(false);
		sg = new SchermataGruppi(this, this.c, cre);
		sg.setVisible(true);
	}
	
	/**
	 * TryVisualizzaContattiGruppo è il metodo che gestisce la visibilità 
	 * dalla finestra SchermataGruppi a VisualizzaContattiGruppi
	 *
	 * @param g il gruppo di cui si voglio visualizzare i contatti
	 */
	public void tryVisualizzaContattiGruppo(Gruppo g)
	{
		sg.setVisible(false);
		vcg = new VisualizzaContattiGruppo(this, this.c, g);
		vcg.setVisible(true);
	}
	
	/**
	 * TryOKVisualizzaContattiGruppo è il metodo che gestisce la visibilità 
	 * dalla finestra VisualizzaContattiGruppo a SchermataGruppi
	 */
	public void tryOKVisualizzaContattiGruppo()
	{
		vcg.setVisible(false);
		sg = new SchermataGruppi(this, this.c, cre);
		sg.setVisible(true);
	}
	
	/**
	 * TryAggiungiContattoGruppo è il metodo che gestisce la visibilità 
	 * dalla finestra VisualizzaContattiGruppo a AggiungiContattiGruppo
	 *
	 * @param gin il gruppo al quale si vogliono aggiungere i contatti
	 */
	public void tryAggiungiContattoGruppo(Gruppo gin)
	{
		vcg.setVisible(false);
		acg = new AggiungiContattoGruppo(this, this.c, gin);
		acg.setVisible(true);
	}
	
	/**
	 * TryOKAggiungiContattoGruppo è il metodo che gestisce la visibilità 
	 * dalla finestra AggiungiContattiGruppo a VisualizzaContattiGruppo
	 *
	 * @param gin il gruppo di cui si devono visualizzare i contatti
	 */
	public void tryOKAggiungiContattoGruppo(Gruppo gin)
	{
		acg.setVisible(false);
		vcg = new VisualizzaContattiGruppo(this, this.c, gin);
		vcg.setVisible(true);
	}
	
	/**
	 * TryIndietroAggiungiContattoGruppo è il metodo che gestisce la visibilità 
	 * dalla finestra AggiungiContattiGruppo a VisualizzaContattiGruppo
	 */
	public void tryIndietroAggiungiContattoGruppo()
	{
		acg.setVisible(false);
		vcg.setVisible(true);
	}
	
	/**
	 * Gets and del set nickname.
	 *
	 * @return nickname
	 */
	public String getNickname() {
		return nickname;
	}
	
	/**
	 * Setta il nickname.
	 *
	 * @param nickname stringa proveniente da LoginFrame
	 */
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	
	/**
	 * Gets and set del numero telefonico.
	 *
	 * @return numero
	 */
	public String getNumero() {
		return numero;
	}
	
	/**
	 * Sett il numero telefonico.
	 *
	 * @param numero proveniente dalla schermata LoginFrame
	 */
	public void setNumero(String numero) {
		this.numero = numero;
	}
	
	/**
	 * Gets and set di 'i' cioè della variabile per la gestione della visibilità
	 * del login frame
	 *
	 * @return i
	 */
	public LoginFrame getI() {
		return i;
	}
	
	/**
	 * Gets and set m variabile usata per la gestione della visibilità della
	 * finestra menù.
	 *
	 * @return the m
	 */
	public Menu getM() {
		return m;
	}
	
	/**
	 * Gets and set dei numeri secondari.
	 *
	 * @return numeri secondari
	 */
	public ArrayList<String> getNumeriSecondari() {
		return numeriSecondari;
	}
	
	/**
	 * Setta i numeri secondari.
	 *
	 * @param numeriSecondari lista di numeri telefonici secondari
	 */
	public void setNumeriSecondari(ArrayList<String> numeriSecondari) {
		this.numeriSecondari = numeriSecondari;
	}
	
	/**
	 * Gets and set degli account.
	 *
	 * @return accountm
	 */
	public ArrayList<AccountMessaggistica> getAccountm() {
		return accountm;
	}
	
	/**
	 * Setta gli accountm.
	 *
	 * @param account lista di account di messaggistica
	 */
	public void setAccountm(ArrayList<AccountMessaggistica> account) {
		accountm = account;
	}
	
}