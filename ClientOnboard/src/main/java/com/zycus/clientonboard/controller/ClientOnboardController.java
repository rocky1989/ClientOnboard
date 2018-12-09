package com.zycus.clientonboard.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.zycus.clientonboard.model.Client;
import com.zycus.clientonboard.service.ClientService;

@RestController
public class ClientOnboardController {

	@Autowired
	ClientService clientService;

	@PostMapping(value = "/onBoard", consumes = { "application/json" })
	public ResponseEntity<String> onBoard(@Validated(RequestValidator.class) @RequestBody Client client,
			HttpServletRequest request) {

		clientService.saveClient(client, request);

		return new ResponseEntity<String>("Login detail has been generated for the client " + "'" + client.getName()
				+ "'" + "\n" + "Request ID - " + request.getAttribute("requestId") + "\n" + "Login Id - "
				+ client.getGovtIdNumber(), HttpStatus.OK);
	}

	@RequestMapping("/getClientById")
	public Client getClientById(@RequestParam String govtIdNumber) {
		return clientService.getClientById(govtIdNumber);
	}

	@RequestMapping("/getClients")
	public List<Client> getClients() {
		return clientService.getClients();
	}

}
