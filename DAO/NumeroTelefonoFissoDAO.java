package DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Model.DBConnection;
import Model.NumeroTelefonoFisso;


/**
 * Classe di collegamento tra il numero telefonico e il database.
 */
public class NumeroTelefonoFissoDAO implements DAO<NumeroTelefonoFisso> {
	
	/** dbc è la variabile di connessione con il database. */
	private DBConnection dbc = DBConnection.getInstance();
	
	/**
	 * classe lanciatrice di eccezioni sql
	 *
	 * @param sql: stringa 
	 * @return numero telefono fisso
	 * @throws SQLException 
	 */
	@Override
	public NumeroTelefonoFisso get(String sql) throws SQLException {
		ResultSet rs = dbc.executeQuery(sql);
		if(rs.next())
		{
			return extract(rs);
		}
		else
		{
			return null;
		}
	}

	/**
	 * Gets the all.
	 *
	 * @param sql the sql
	 * @return the all
	 * @throws SQLException the SQL exception
	 */
	@Override
	public ArrayList<NumeroTelefonoFisso> getAll(String sql) throws SQLException {
		ResultSet rs = dbc.executeQuery(sql);
		ArrayList<NumeroTelefonoFisso> list = new ArrayList<>();
		while(rs.next())
		{
			list.add(extract(rs));
		}
		return list;
	}
	
	/**
	 * Extract.
	 *
	 * @param rs the rs
	 * @return the numero telefono fisso
	 * @throws SQLException the SQL exception
	 */
	private NumeroTelefonoFisso extract(ResultSet rs) throws SQLException
	{
		return new NumeroTelefonoFisso(rs.getString("numero"));
	}


	/**
	 * Update.
	 *
	 * @param obj the obj
	 * @throws SQLException the SQL exception
	 */
	@Override
	public void update(NumeroTelefonoFisso obj) throws SQLException {
		String sql = "UPDATE NumeroTelefono SET numero = " + obj.getNumero() + " WHERE numero = " + obj.getNumero();
		dbc.executeQuery(sql);
	}

	/**
	 * Delete.
	 *
	 * @param obj the obj
	 * @throws SQLException the SQL exception
	 */
	@Override
	public void delete(NumeroTelefonoFisso obj) throws SQLException {
		String sql = "DELETE FROM NumeroTelefono WHERE numero = " + obj.getNumero();
		dbc.execute(sql);
	}

	/**
	 * Insert.
	 *
	 * @param obj the obj
	 * @throws SQLException the SQL exception
	 */
	@Override
	public void insert(NumeroTelefonoFisso obj) throws SQLException {
		String sql = "INSERT INTO NumeroTelefono(numero) VALUES(" + obj.getNumero() + ")";
		dbc.execute(sql);
	}

}
