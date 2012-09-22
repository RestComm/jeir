package org.mobicents.eir.slee.persistence.dao;

import org.mobicents.eir.slee.persistence.dao.cassandra.CassandraDAOFactory;

/**
 * 
 * @author normandes
 *
 */
public abstract class DAOFactory {

	private static DAOFactory instance;
	
	public static DAOFactory getDAOFactory() {
		if (instance == null) {
			//TODO: Should be injected to be able to change
			instance = new CassandraDAOFactory();
		}
		return instance;
	}

	public abstract BlackListDAO getBlackListDAO();
	
}
