
package Controller;

import java.util.ArrayList;
import java.util.LinkedHashSet;

import Model.AccountMessaggistica;
import Model.Contatto;
import Model.Gruppo;
import Model.NumeroTelefonoFisso;
import Model.NumeroTelefonoMobile;
import Model.Rubrica;

/**
 * La Classe Controller.
 */
public class Controller {
	
	/** 'r' è la variabile della nostra rubrica. */
	Rubrica r;
	/**
	 * inizializzazione della rubrica
	 */
	public Controller()
	{
		r= new Rubrica("Rubrica");
	}
	
	
	/**
	 * addContatto è la funzione che aggiunge il contatto inserito dall'utente nella classe CreaC delle GUI nella rubrica .
	 *
	 * @param nome del contatto aggiunto
	 * @param cognome del contatto aggiunto
	 * @param eta the eta
	 * @param sesso del contatto aggiunto
	 * @param residenza del contatto aggiunto
	 * @param email del contatto aggiunto
	 * @param numf : numero fisso del contatto aggiunto
	 * @param numb : numero mobile del contatto aggiunto
	 * @param numeriS the numeri S
	 * @param am the am
	 */
	public void addContatto(String nome, String cognome, String eta, String sesso, String residenza, String email, String numf, String numb, ArrayList<String> numeriS, ArrayList<AccountMessaggistica> am)
	{
		/**
		 *@if questo controllo serve a non far aggiungere alla rubrica gli utenti ai quali non è stato inserito 
		 *il numero di telefono fisso e quello mobile e almeno una variabile tra il nome e il cognome.
		 *la modifica avviene in place.
		 */
		if ((((!nome.isBlank())||(!cognome.isBlank()))&&(!numf.isBlank())&&(!numb.isBlank())))
		{
			r.aggiungiContatto(nome, cognome, eta, sesso, residenza, email, this.r, numf, numb, numeriS, am);
		}
		
		/**
		 *  Metodo che aggiunge un gruppo all'array list gruppi
		 *  
		 *  @param nome: nome del gruppo
		 *  @param in: l'array list dei contatti che dovranno essere presenti nel gruppo
		 */
	}
	public void addGruppo(String nome, ArrayList<Contatto> in)
	{
		r.aggiungiGruppo(nome, this.r, in);
	}
	
	/** 
	 * Get dei contatti dalla rubrica
	 * @return contatti: l'array list dei contatti
	 */
	public ArrayList<Contatto> getRubricaContatti()
	{
		return r.contatti;
	}
	/** 
	 * Get dei gruppi dalla rubrica
	 * @return gruppi: l'array list dei gruppi
	 */
	
	public ArrayList<Gruppo> getRubricaGruppi()
	{
		return r.gruppi;
	}
	/** 
	 * Get degli account di messaggistica dalla rubrica
	 * @return l'array di account generato dalla funzione getAccount()
	 */
	public ArrayList<AccountMessaggistica> getContattoAccountMessaggistica(Contatto in)
	{
		return in.getAccountm();
	}
	/**
	 * Metodo che chiama la funzione "getRubricaOrdinataDesc" 
	 * che ordinerà l'array di contatti in ordine alfabetico decrescente.
	 *
	 * @return ritorna la rubrica ordinata in maniera decrescente
	 */
	public Rubrica getRubricaOrdinataDesc()
	{
		r.mostraContattiPer("Decrescente");
		return r;
	}
	
	/**
	 * Metodo che chiama la funzione "getRubricaOrdinataCresc" 
	 * che ordinerà l'array di contatti in ordine alfabetico crescente.
	 *
	 * @return ritorna la rubrica ordinata in maniera crescente
	 */
	public Rubrica getRubricaOrdinataCresc()
	{
		r.mostraContattiPer("Crescente");
		return r;
	}
	
	/**
	 *Metodo che chiama la funzione "getNumeritelefonicif()" che restituisce i numeri telefonici fissi di un contatto passato come parametro
	 *
	 * @param in: è il contatto selezionato tramite l'interfaccia grafica dall'utente
	 * @return i numeri telefono fissi del contatto passato come parametro
	 */
	public ArrayList<NumeroTelefonoFisso> getContattiNumeriTelefonoFissi(Contatto in)
	{
		return in.getNumeritelefonicif();
	}
	
	/**
	 * Metodo che chiama la funzione "getNumeritelefonicim()" che restituisce i numeri telefonici mobili di un contatto passato come parametro
	 *
	 * @param in: è il contatto selezionato tramite l'interfaccia grafica dall'utente
	 * @return i numeri telefono mobili del contatto passato come parametro
	 */
	public ArrayList<NumeroTelefonoMobile> getContattiNumeriTelefonoMobili(Contatto in)
	{
		return in.getNumeritelefonicim();
	}
	/**
	 * 
	 * @param coin: contatto passato in input al quale si vuole aggiungere un numero telefonico
	 * @param ntfin: numero telefonico fisso, passato in input da aggiungere al contatto
	 * @param nmtin: numero telefonico mobile, passato in input da aggiungere al contatto
	 * @return true se il numero inserito dall'utente è valido, false altrimenti
	 */
	public boolean addNumeroContatto(Contatto coin, NumeroTelefonoFisso ntfin, NumeroTelefonoMobile nmtin)
	{
		for(int i = 0; i < r.contatti.size(); i++)
		{
			if(r.contatti.get(i) == coin)
			{
				if(ntfin == null)
				{
					if(isNumeric(nmtin.getNumero()) == true)
					{
						r.contatti.get(i).setNumeritelefonicifm(nmtin);
						return true;
					}
					else
					{
						return false;
					}
				}
				else if(nmtin == null)
				{
					if(isNumeric(ntfin.getNumero()) == true)
					{
						r.contatti.get(i).setNumeritelefonicif(ntfin);
						return true;
					}
					else
					{
						return false;
					}
				}
			}
		}
		return true;
	}
	/**
	 * Il metodo aggiunge l'account messaggistica passato come parametro
	 * al contatto passato come parametro
	 * @param cin: contatto passato in input
	 * @param amin: account di messaggistica passato in input
	 */
	public void addAccountMessaggisticaContatto(Contatto cin, AccountMessaggistica amin)
	{
		for(int i = 0; i < r.contatti.size(); i++)
		{
			if(r.contatti.get(i) == cin)
			{
				r.contatti.get(i).setAccountm(amin);
			}
		}
	}
	/**
	* Il metodo aggiunge al gruppo messaggistica passato come parametro
	 * l'array di contatti passato come parametro
	 * @param gin: gruppo passato in input
	 * @param cin: array di contatti passato in input
	 */
	public void addContattoGruppo(Gruppo gin, ArrayList<Contatto> cin)
	{
		for(int i = 0; i < cin.size(); i++)
		{
			gin.setContatti(cin.get(i));
		}
	}
	/**
	 * 
	 * @param scelta: la tipologia di ricerca che si vuole effetturare:
	 * La ricerca si può effettuare per: nome, account messaggistica, email e numero telefonico
	 * @param search: la stringa che l'utente ha inserito e che vuole cercare nella rubrica
	 * @return c: il contatto trovato.
	 */
	public ArrayList<Contatto> ricercaPer(String scelta, ArrayList<Contatto> in, String search)
	{
		ArrayList<Contatto> c = new ArrayList<>();
		
		switch(scelta)
		{
			case "Nome":
				for(int i = 0; i < in.size(); i++)
				{
					if(search.equals(in.get(i).getNome()))
					{
						c.add(in.get(i));
					}
				}
				break;
			case "Email":
				for(int i = 0; i < in.size(); i++)
				{
					if(search.equals(in.get(i).getEmail()))
					{
						c.add(in.get(i));
					}
				}
				break;
			case "Account di messaggistica":
				for(int i = 0; i < in.size(); i++)
				{
					for(int j = 0; j < in.get(i).getAccountm().size(); j++)
					{
						if(search.equals(in.get(i).getAccountm().get(i).getNickname()))
						{
							c.add(in.get(i));
						}
					}
				}
				break;
			case "Numero di telefono":
				for(int i = 0; i < in.size(); i++)
				{
					for(int j = 0; j < in.get(i).getNumeritelefonicif().size(); j++)
					{
						if(search.equals(in.get(i).getNumeritelefonicif().get(i).getNumero()))
						{
							c.add(in.get(i));
						}
					}
					for(int j = 0; j < in.get(i).getNumeritelefonicim().size(); j++)
					{
						if(search.equals(in.get(i).getNumeritelefonicim().get(i).getNumero()))
						{
							c.add(in.get(i));
						}
					}
				}
		}
		LinkedHashSet<Contatto> hashSet = new LinkedHashSet<>(c);
		ArrayList<Contatto> noDuplicati = new ArrayList<>(hashSet);
		return c;
	}
	/**
	 * isNumeric verifica se una stringa è composta da soli numeri, tramite la funzione Double.parseDouble().
	 * se è composta da soli numeri ritorna true
	 * in caso contrario genera un eccezione che viene gestita dal catch e ritorna false
	 * @param str: la stringa da elaborare
	 * @return true se la stringa è composta da soli numeri, false altrimenti
	 */
	public boolean isNumeric(String str) { 
		  try {  
		    Double.parseDouble(str);  
		    return true;
		  } catch(NumberFormatException e){  
		    return false;  
		  }  
		}
}
