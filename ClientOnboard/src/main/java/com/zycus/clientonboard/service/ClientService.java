package com.zycus.clientonboard.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.zycus.clientonboard.model.Client;

public interface ClientService {
	
	public Client getClientById(String govtIdNumber);

	void saveClient(Client client, HttpServletRequest request);

	List<Client> getClients();
}
