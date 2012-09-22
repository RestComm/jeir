package org.mobicents.eir.slee.persistence.dao.cassandra;

import org.mobicents.eir.slee.persistence.dao.BlackListDAO;
import org.mobicents.eir.slee.persistence.dao.DAOFactory;

/**
 * 
 * @author normandes
 *
 */
public class CassandraDAOFactory extends DAOFactory {

	@Override
	public BlackListDAO getBlackListDAO() {
		return new CassandraBlackListDAO(CassandraUtil.getKeyspace());
	}
	
}
