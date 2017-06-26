package com.axia.global.config;

import static java.lang.System.out;

import org.apache.log4j.Logger;

import com.axia.global.constants.CassandraKeySpaceConstants;
import com.datastax.driver.core.Cluster;
import com.datastax.driver.core.Host;
import com.datastax.driver.core.Metadata;
import com.datastax.driver.core.Session;
import com.datastax.driver.mapping.MappingManager;

public class CassandraConnection {
	Logger log = Logger.getLogger(CassandraConnection.class);
	private Cluster cluster;
	private Session session;
	private MappingManager manager;

	private static String keySpace = CassandraKeySpaceConstants.keyspace;

	public CassandraConnection(String node, int port) {
		this.cluster = Cluster.builder().addContactPoint(node).withPort(port).build();
		final Metadata metadata = cluster.getMetadata();
		out.printf("Connected to cluster: %s\n", metadata.getClusterName());
		for (final Host host : metadata.getAllHosts()) {
			out.printf("Datacenter: %s; Host: %s; Rack: %s\n", host.getDatacenter(), host.getAddress(), host.getRack());
		}
		session = cluster.connect(keySpace);
		manager = new MappingManager(session);
	}

	/**
	 * @return the session
	 */
	public Session getSession() {
		return session;
	}

	/**
	 * @return the manager
	 */
	public MappingManager getManager() {
		return manager;
	}
}
