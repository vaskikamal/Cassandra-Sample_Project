package com.axia.global.dao.cassandra.impl;

import java.util.HashSet;
import java.util.Set;

import org.apache.log4j.Logger;

import com.axia.global.config.CassandraConnection;
import com.axia.global.dao.ICustomerBUWiseDetailsDAO;
import com.axia.global.dao.model.cassandra.CustomerBUWiseDetails;
import com.datastax.driver.mapping.Mapper;

/**
 * 
 */
public class CustomerBUWiseDetailsCassandraDAOImpl implements ICustomerBUWiseDetailsDAO {

	Logger log = Logger.getLogger(CustomerBUWiseDetailsCassandraDAOImpl.class);
	CassandraConnection conn = new CassandraConnection("127.0.0.1", 9042);
	private Mapper<CustomerBUWiseDetails> mapper;

	public CustomerBUWiseDetailsCassandraDAOImpl() {
		mapper = conn.getManager().mapper(CustomerBUWiseDetails.class);
	}

	/**
	 * saves the data to the table.
	 * 
	 * @param details
	 */
	@Override
	public void saveCustomerBUWiseDetails(CustomerBUWiseDetails details) {
		if (details != null) {
			mapper.save(details);
		} else {
			log.info("saveCustomerBUWiseDetails : Null CustomerBUWiseDetails received. Hence, ignoring");
		}
	}

	@Override
	public CustomerBUWiseDetails getCustomerBUWiseDetailsByCustId(Integer buId, Integer custId) {
		return buId == null ? null : mapper.get(buId, custId);
	}

	@Override
	public void deleteBUWiseDetails(Integer buId, Integer custId) {
		if (buId != null && custId != null) {
			mapper.delete(buId, custId);
		}
	}

	@Override
	public void updateBUWiseDetails(CustomerBUWiseDetails details) {
		saveCustomerBUWiseDetails(details);
	}

	@Override
	public CustomerBUWiseDetails updateBULocationIds(Integer buId, Integer custId, Integer locId) {
		CustomerBUWiseDetails details = null;
		if (buId != null && custId != null) {
			details = getCustomerBUWiseDetailsByCustId(buId, custId);
			Set<Integer> locIds = details.getBu_LocationIds();
			if (locIds != null) {
				details.getBu_LocationIds().add(locId);
			} else {
				Set<Integer> newLocIds = new HashSet<Integer>();
				newLocIds.add(locId);
				details.setBu_LocationIds(newLocIds);
			}
		} else {
			log.warn("Invalid Update. Mandatory attributes not sent");
		}
		saveCustomerBUWiseDetails(details);

		return details;
	}

	@Override
	public Set<Integer> getLocationIds(Integer buId, Integer custId) {
		CustomerBUWiseDetails details = null;
		if (buId == null) {
			details = getCustomerBUWiseDetailsByCustId(buId, custId);

			Set<Integer> locIds = details.getBu_LocationIds();

			if (locIds != null) {
				return details.getBu_LocationIds();
			}
		} else {
			log.warn("Invalid Update. Mandatory attributes not sent");
		}
		return null;
	}
}
