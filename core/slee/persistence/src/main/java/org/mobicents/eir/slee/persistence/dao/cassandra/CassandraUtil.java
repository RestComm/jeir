package org.mobicents.eir.slee.persistence.dao.cassandra;

import me.prettyprint.hector.api.Cluster;
import me.prettyprint.hector.api.Keyspace;
import me.prettyprint.hector.api.factory.HFactory;

/**
 * 
 * @author normandes
 *
 */
public class CassandraUtil {

	private static Keyspace keyspace;
	
	static {
		//TODO: Should be customized.
		//TODO: Validate what happens when connection to Cassandra dies and live again.
		
		/* Let’s first create our Cluster object which represent a Cassandra cluster. */
		Cluster eirCluster = HFactory.getOrCreateCluster("Test Cluster","localhost:9160");
		
		/*
		 * Create a Keyspace object which is a long life component 
		 * and represents the Cassandra keyspace under which we will perform operations.
		 */
		keyspace = HFactory.createKeyspace("eirdb", eirCluster);
	}
	
	public static Keyspace getKeyspace() {
		return keyspace;
	}
}
