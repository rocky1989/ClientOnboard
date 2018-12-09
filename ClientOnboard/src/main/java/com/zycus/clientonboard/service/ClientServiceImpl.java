package com.zycus.clientonboard.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zycus.clientonboard.dao.ClientDao;
import com.zycus.clientonboard.model.Client;

@Service
public class ClientServiceImpl implements ClientService{
	
	@Autowired
	ClientDao clientDao;
	
	@Override
	public Client getClientById(String govtIdNumber) {
		return clientDao.getClientById(govtIdNumber);
	}
	
	@Override
	public List<Client> getClients() {
		return clientDao.getClients();
	}

	@Override	
	@Transactional
	public void saveClient(Client client, HttpServletRequest request) {
		clientDao.saveClient(client);
		clientDao.saveAudit(client, request);
	}

}
