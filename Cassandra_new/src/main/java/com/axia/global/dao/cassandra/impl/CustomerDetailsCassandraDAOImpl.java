package com.axia.global.dao.cassandra.impl;

import static java.lang.System.out;

import java.util.List;

import com.axia.global.dao.ICustomerDetailsDAO;
import com.axia.global.dao.model.cassandra.CustomerDetails;
import com.axia.global.utils.JacksonMapper;
import com.datastax.driver.core.Cluster;
import com.datastax.driver.core.Host;
import com.datastax.driver.core.Metadata;
import com.datastax.driver.core.ResultSet;
import com.datastax.driver.core.Row;
import com.datastax.driver.core.Session;
import com.datastax.driver.core.Statement;
import com.datastax.driver.core.querybuilder.QueryBuilder;
import com.datastax.driver.mapping.MappingManager;

/**
 * 
 */
public class CustomerDetailsCassandraDAOImpl implements ICustomerDetailsDAO {

	private Cluster cluster;
	private Session session;

	private JacksonMapper mapper = new JacksonMapper();

	private static String keySpace = "axiaglobal";
	private static String customerDetailsTable = "customer_details";

	public CustomerDetailsCassandraDAOImpl(String node, int port) {
		this.cluster = Cluster.builder().addContactPoint(node).withPort(port).build();
		final Metadata metadata = cluster.getMetadata();
		out.printf("Connected to cluster: %s\n", metadata.getClusterName());
		for (final Host host : metadata.getAllHosts()) {
			out.printf("Datacenter: %s; Host: %s; Rack: %s\n", host.getDatacenter(), host.getAddress(), host.getRack());
		}
		session = cluster.connect(keySpace);
	}

	@Override
	public void saveCustomerDetails(CustomerDetails details) {

		Statement exampleQuery = QueryBuilder.insertInto(keySpace, customerDetailsTable)
				.value("customerID", details.getCustomerID()).value("customerName", details.getCustomerName())
				.value("headOfficeAddress1", details.getHeadOfficeAddress1())
				.value("customerMobNo", details.getCustomerMobNo())

				.value("customerLocationIds", mapper.getJsonReadings(details.getCustomerLocationIds()))
				.value("customerBUIds", mapper.getJsonReadings(details.getCustomerBUIds())).ifNotExists();
		session.execute(exampleQuery);

	}
	
	@Override
	public CustomerDetails getCustomerDetails(String custId) {
		Statement getCustomerQuery = QueryBuilder.select().from(keySpace, customerDetailsTable)
				.where(QueryBuilder.eq("customerID", custId));

		ResultSet resultSet = session.execute(getCustomerQuery);

		CustomerDetails custDetails = new CustomerDetails();

		Row row = resultSet.one();
		if (row == null) {
			throw new RuntimeException("Invalid Customer UID " + custId + " not available.");
		} else {
			custDetails.setCustomerID(row.getString("customerID"));
			custDetails.setCustomerName(row.getString("customerName"));
			custDetails.setHeadOfficeAddress1(row.getString("headOfficeAddress1"));
			custDetails.setCustomerMobNo(row.getString("customerMobNo"));
			custDetails.setCustomerLocationIds(mapper.readJsonReadingsAsSet(row.getString("customerLocationIds")));
			custDetails.setCustomerBUIds(mapper.readJsonReadingsAsSet(row.getString("customerBUIds")));

		}
		return custDetails;
	}

	@Override
	public void deleteCustomerDetails(String custId) {
		Statement getCustomerQuery = QueryBuilder.delete().from(keySpace, customerDetailsTable)
				.where(QueryBuilder.eq("customerID", custId));
		session.execute(getCustomerQuery);
	}

	@Override
	public void updateCustomerDetails(CustomerDetails details) {
		Statement updateCustomerDetails = QueryBuilder.update(keySpace, customerDetailsTable)
				.with(QueryBuilder.set("customerName", details.getCustomerName()))
				.and(QueryBuilder.set("headOfficeAddress1", details.getHeadOfficeAddress1()))
				.and(QueryBuilder.set("customerMobNo", details.getCustomerMobNo()))
				.and(QueryBuilder.set("customerLocationIds", mapper.getJsonReadings(details.getCustomerLocationIds())))
				.and(QueryBuilder.set("customerBUIds", mapper.getJsonReadings(details.getCustomerBUIds())))
				.where(QueryBuilder.eq("customerID", details.getCustomerID()));
		session.execute(updateCustomerDetails);
	}

	@Override
	public void saveListCustomerDetails(List<CustomerDetails> custDetails) {
		if (custDetails != null && !custDetails.isEmpty()) {
			for (CustomerDetails e : custDetails) {
				saveCustomerDetails(e);
			}
		}
	}

	@Override
	public void updateLocationIds(String custId, String LocId) {

		CustomerDetails details = getCustomerDetails(custId);
		// update details with new LocID
		details.getCustomerLocationIds().add(LocId);
		Statement updateLocDetails = QueryBuilder.update(keySpace, customerDetailsTable)
				.with(QueryBuilder.set("customerLocationIds", mapper.getJsonReadings(details.getCustomerLocationIds())))
				.where(QueryBuilder.eq("customerID", details.getCustomerID()));
		session.execute(updateLocDetails);
	}

	@Override
	public void updateBUIds(String custId, String BuId) {
		CustomerDetails details = getCustomerDetails(custId);
		// update details with new LocID
		details.getCustomerBUIds().add(BuId);
		Statement updateBUDetails = QueryBuilder.update(keySpace, customerDetailsTable)
				.with(QueryBuilder.set("customerBUIds", mapper.getJsonReadings(details.getCustomerBUIds())))
				.where(QueryBuilder.eq("customerID", details.getCustomerID()));
		session.execute(updateBUDetails);
	}

	@Override
	public void deleteLocationIds(String custId, String LocId) {
		CustomerDetails details = getCustomerDetails(custId);
		// update details with new LocID
		details.getCustomerLocationIds().remove(LocId);
		Statement deleteLocDetails = QueryBuilder.update(keySpace, customerDetailsTable)
				.with(QueryBuilder.set("customerLocationIds", mapper.getJsonReadings(details.getCustomerLocationIds())))
				.where(QueryBuilder.eq("customerID", details.getCustomerID()));
		session.execute(deleteLocDetails);
	}

	@Override
	public void deleteBUIds(String custId, String buId) {
		CustomerDetails details = getCustomerDetails(custId);
		// update details with new LocID
		details.getCustomerBUIds().add(buId);
		Statement deleteLocDetails = QueryBuilder.update(keySpace, customerDetailsTable)
				.with(QueryBuilder.set("customerBUIds", mapper.getJsonReadings(details.getCustomerBUIds())))
				.where(QueryBuilder.eq("customerID", details.getCustomerID()));
		session.execute(deleteLocDetails);
	}

	/**
	 * @param keySpace
	 *            the keySpace to set
	 */
	public void setKeySpace(String keySpace) {
		this.keySpace = keySpace;
	}

}
