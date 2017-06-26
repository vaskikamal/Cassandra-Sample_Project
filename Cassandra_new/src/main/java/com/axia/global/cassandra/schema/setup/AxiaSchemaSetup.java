package com.axia.global.cassandra.schema.setup;

/**
 * Class which will be used to setup the keyspaces and tables.
 *
 */
public class AxiaSchemaSetup extends AxiaRunSQLCommands {

	AxiaSchemaSetup(String cqlFile) {
		super(cqlFile);
	}

	/**
	 * Main program to setup keyspaces and tables for axia.
	 * 
	 * @param args
	 */
	public static void main(String args[]) {

		AxiaSchemaSetup setup = new AxiaSchemaSetup("cql/create_schema.cql");
		setup.internalSetup();
		setup.shutdown();
	}
}
