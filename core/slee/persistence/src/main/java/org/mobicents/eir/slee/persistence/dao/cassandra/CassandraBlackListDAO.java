/*
 * TeleStax, Open Source Cloud Communications  Copyright 2012. 
 * and individual contributors
 * by the @authors tag. See the copyright.txt in the distribution for a
 * full listing of individual contributors.
 *
 * This is free software; you can redistribute it and/or modify it
 * under the terms of the GNU Lesser General Public License as
 * published by the Free Software Foundation; either version 2.1 of
 * the License, or (at your option) any later version.
 *
 * This software is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this software; if not, write to the Free
 * Software Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA
 * 02110-1301 USA, or see the FSF site: http://www.fsf.org.
 */

package org.mobicents.eir.slee.persistence.dao.cassandra;

import me.prettyprint.cassandra.serializers.StringSerializer;
import me.prettyprint.cassandra.service.template.ColumnFamilyResult;
import me.prettyprint.cassandra.service.template.ColumnFamilyTemplate;
import me.prettyprint.cassandra.service.template.ThriftColumnFamilyTemplate;
import me.prettyprint.hector.api.Keyspace;
import me.prettyprint.hector.api.exceptions.HectorException;

import org.mobicents.eir.slee.persistence.dao.BlackListDAO;
import org.mobicents.eir.slee.persistence.dao.DAOException;
import org.mobicents.eir.slee.persistence.model.BlackList;

/**
 * 
 * @author normandes
 *
 */
public class CassandraBlackListDAO extends CassandraDAOFactory implements BlackListDAO {

	private ColumnFamilyTemplate<String, String> template;
	
	public CassandraBlackListDAO(Keyspace keyspace) {
		template = new ThriftColumnFamilyTemplate<String, String>(keyspace, "blacklist", StringSerializer.get(), StringSerializer.get());		
	}

	@Override
	public BlackList getByImei(String imei) throws DAOException {
		BlackList bl = null;
		ColumnFamilyResult<String, String> res = null;
		try {
			res = template.queryColumns(imei);
		} catch (HectorException e) {
			throw new DAOException("Error accessing persistence system. Please check if it is up and running", e);
		}
		if (res.hasResults()) {
			String imsi = res.getString("imsi");
			bl = new BlackList(imei, imsi);
		}
		
		return bl;
	}

}
