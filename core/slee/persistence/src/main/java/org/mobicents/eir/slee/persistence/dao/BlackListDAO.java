package org.mobicents.eir.slee.persistence.dao;

import org.mobicents.eir.slee.persistence.model.BlackList;

/**
 * 
 * @author normandes
 *
 */
public interface BlackListDAO {

	public BlackList getByImei(String imei);
	
}
