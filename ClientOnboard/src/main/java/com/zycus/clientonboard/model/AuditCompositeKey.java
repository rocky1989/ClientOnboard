package com.zycus.clientonboard.model;

import java.io.Serializable;
import java.util.UUID;

public class AuditCompositeKey implements Serializable {
	
	private static final long serialVersionUID = -1003104460843900096L;

	private UUID requestId;
	private String govtIdNumber;

	public UUID getRequestId() {
		return requestId;
	}

	public void setRequestId(UUID requestId) {
		this.requestId = requestId;
	}

	public String getGovtIdNumber() {
		return govtIdNumber;
	}

	public void setGovtIdNumber(String govtIdNumber) {
		this.govtIdNumber = govtIdNumber;
	}

}
