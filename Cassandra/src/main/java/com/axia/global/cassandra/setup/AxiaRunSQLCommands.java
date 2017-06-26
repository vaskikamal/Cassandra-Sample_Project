package com.axia.global.cassandra.setup;

import static java.lang.System.out;

import org.slf4j.LoggerFactory;

import com.axia.global.utils.FileUtils;
import com.datastax.driver.core.Cluster;
import com.datastax.driver.core.Host;
import com.datastax.driver.core.Metadata;
import com.datastax.driver.core.Session;
import com.datastax.driver.core.exceptions.InvalidQueryException;

public abstract class AxiaRunSQLCommands {

	private static org.slf4j.Logger logger = LoggerFactory.getLogger(AxiaRunSQLCommands.class);

	private Cluster cluster;
	private Session session;
	private String CQL_FILE;

	/**
	 * Constructor.
	 * 
	 * @param cqlFile
	 *            file to cql queries.
	 */
	public AxiaRunSQLCommands(final String cqlFile) {

		logger.info("Running file " + cqlFile);

		this.CQL_FILE = cqlFile;

		// later to change code to read from property file
		String contactPointsStr = System.getProperty("contactPoints");
		if (contactPointsStr == null) {
			contactPointsStr = "127.0.0.1";
		}
		// create a cassandra cluster config.
		cluster = Cluster.builder().addContactPoints(contactPointsStr.split(",")).build();
		// retrieve metadata about clusters.
		final Metadata metadata = cluster.getMetadata();
		out.printf("Connected to cluster: %s\n", metadata.getClusterName());
		for (final Host host : metadata.getAllHosts()) {
			out.printf("Datacenter: %s; Host: %s; Rack: %s\n", host.getDatacenter(), host.getAddress(), host.getRack());
		}
		// connect to cluster.
		session = cluster.connect();
	}

	/**
	 * scope is defaulted.
	 * 
	 */
	void internalSetup() {
		this.runfile();
	}

	/**
	 * executes the cql file.
	 */
	void runfile() {

		String readFileIntoString = FileUtils.readFileIntoString(CQL_FILE);

		String[] commands = readFileIntoString.split(";");

		for (String command : commands) {
			String cql = command.trim();
			if (commands.length == 1) {
				cql = cql.concat(";");
			}
			if (cql.isEmpty()) {
				continue;
			}

			if (cql.toLowerCase().startsWith("drop")) {
				this.runAllowFail(cql);
			} else {
				this.run(cql);
			}
		}
	}

	void runAllowFail(String cql) {
		try {
			run(cql);
		} catch (InvalidQueryException e) {
			logger.warn("Ignoring exception - " + e.getMessage());
		}
	}

	void run(String cql) {
		logger.info("Running : " + cql);
		session.execute(cql);
	}

	void sleep(int i) {
		try {
			Thread.sleep(i);
		} catch (Exception e) {
		}
	}

	void shutdown() {
		session.close();
		cluster.close();
	}
}
