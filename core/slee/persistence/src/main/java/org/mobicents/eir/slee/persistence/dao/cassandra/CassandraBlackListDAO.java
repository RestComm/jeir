package org.mobicents.eir.slee.persistence.dao.cassandra;

import me.prettyprint.cassandra.serializers.StringSerializer;
import me.prettyprint.cassandra.service.template.ColumnFamilyResult;
import me.prettyprint.cassandra.service.template.ColumnFamilyTemplate;
import me.prettyprint.cassandra.service.template.ThriftColumnFamilyTemplate;
import me.prettyprint.hector.api.Keyspace;

import org.mobicents.eir.slee.persistence.dao.BlackListDAO;
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
	public BlackList getByImei(String imei) {
		BlackList bl = null;
		ColumnFamilyResult<String, String> res = template.queryColumns(imei);
		if (res.hasResults()) {
			String imsi = res.getString("imsi");
			bl = new BlackList(imei, imsi);
		}
		
		return bl;
	}

}
