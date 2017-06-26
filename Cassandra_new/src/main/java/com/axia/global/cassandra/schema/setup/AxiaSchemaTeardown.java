package com.axia.global.cassandra.schema.setup;

public class AxiaSchemaTeardown extends AxiaRunSQLCommands {

	AxiaSchemaTeardown(String cqlFile) {
		super(cqlFile);
	}

	public static void main(String args[]){
		
		AxiaSchemaTeardown setup = new AxiaSchemaTeardown("cql/drop_schema.cql");
		setup.internalSetup();
		setup.shutdown();
	}
}
