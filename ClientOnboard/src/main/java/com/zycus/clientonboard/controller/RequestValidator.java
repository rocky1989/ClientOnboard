package com.zycus.clientonboard.controller;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.zycus.clientonboard.exception.ClientOnboardException;
import com.zycus.clientonboard.model.Client;
import com.zycus.clientonboard.model.MaritalStatus;

@Component
public class RequestValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return Client.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		Client client = (Client) target;

			assertMandatoryFieldsArePresent(client);
			assertAgeIsValid(client);
			assertSpouseNameIsPresentforMarried(client);

	}

	private void assertMandatoryFieldsArePresent(Client client) {
		if ((client.getName() == null || client.getName().isEmpty()) || client.getAge() == 0 || client.getSex() == null
				|| (client.getPermanentAddress() == null || client.getPermanentAddress().isEmpty())
				|| (client.getCurrentAddress() == null || client.getCurrentAddress().isEmpty())
				|| (client.getMail() == null || client.getMail().isEmpty()) || client.getPhone() == null
				|| (client.getGovtIdNumber() == null || client.getGovtIdNumber().isEmpty())
				|| (client.getCountry() == null || client.getCountry().isEmpty()) || client.getMartialStatus() == null)
			throw new ClientOnboardException(
					"Mandatory fields name, age, sex, permanent address, current address, mail id, phone number, govt id number, country, marital status can not be null or blank");

	}

	private void assertAgeIsValid(Client client) {
		if (client.getCountry().equalsIgnoreCase("India") && client.getAge() >= 45)
			throw new ClientOnboardException("For indian clients, age should be less than 45");
		if (client.getCountry().equalsIgnoreCase("USA") && client.getAge() >= 50)
			throw new ClientOnboardException("For US clients, age should be less than 50");
	}

	private void assertSpouseNameIsPresentforMarried(Client client) {
		if (client.getMartialStatus() == MaritalStatus.Married
				&& (client.getSpouseName() == null || client.getSpouseName().isEmpty()))
			throw new ClientOnboardException("Spouse name is mandatory for married client");

	}
}
