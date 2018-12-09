package com.zycus.clientonboard.dao;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Repository;

import com.zycus.clientonboard.model.Audit;
import com.zycus.clientonboard.model.Client;

@Repository
public class ClientDaoImpl implements ClientDao{
	@PersistenceContext
	private EntityManager em;
	
	@Override
	public Client getClientById(String govtIdNumber) {
		return em.find(Client.class, govtIdNumber);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Client> getClients() {
		return em.createQuery("select c from Client c").getResultList();
	}

	@Override
	public void saveClient(Client client) {

		Client savedClient = getClientById(client.getGovtIdNumber());

		if (savedClient == null) {
			client.setCreateTime(new Date());
			em.merge(client);
		} else {
			savedClient.setLastUpdateTime(new Date());
			savedClient.setAge(client.getAge());
			savedClient.setCountry(client.getCountry());
			savedClient.setCurrentAddress(client.getCurrentAddress());
			savedClient.setGovtIdNumber(client.getGovtIdNumber());
			savedClient.setKidsName(client.getKidsName());
			savedClient.setMail(client.getMail());
			savedClient.setName(client.getName());
			savedClient.setPermanentAddress(client.getPermanentAddress());
			savedClient.setPhone(client.getPhone());
			savedClient.setSex(client.getSex());
			savedClient.setSpouseName(client.getSpouseName());
			em.persist(savedClient);
		}


	}

	@Override
	public void saveAudit(Client client, HttpServletRequest request) {

		Audit audit = new Audit();
		audit.setGovtIdNumber(client.getGovtIdNumber());
		audit.setRequestId((UUID) request.getAttribute("requestId"));
		audit.setTime(new Date());
		em.merge(audit);
	}

}
