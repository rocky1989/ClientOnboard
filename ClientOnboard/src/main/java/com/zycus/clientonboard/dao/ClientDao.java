package com.zycus.clientonboard.dao;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.zycus.clientonboard.model.Client;

public interface ClientDao {

	public Client getClientById(String govtIdNumber);

	void saveClient(Client client);

	List<Client> getClients();

	void saveAudit(Client client, HttpServletRequest request);
}
