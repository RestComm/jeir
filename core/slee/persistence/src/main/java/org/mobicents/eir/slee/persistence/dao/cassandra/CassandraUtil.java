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
