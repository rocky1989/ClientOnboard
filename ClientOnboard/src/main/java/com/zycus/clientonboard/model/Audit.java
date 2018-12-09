package com.zycus.clientonboard.model;

import java.io.Serializable;
import java.util.Date;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;

@Entity
@IdClass(AuditCompositeKey.class)
public class Audit implements Serializable {

	private static final long serialVersionUID = 8975378212267810795L;

	@Id
	private UUID requestId;

	@Column
	private String govtIdNumber;

	@Column
	private Date time;

	public Audit() {

	}

	public Audit(UUID requestId, String govtIdNumber, Date time) {
		this.requestId = requestId;
		this.govtIdNumber = govtIdNumber;
		this.time = time;
	}

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

	public Date getTime() {
		return time;
	}

	public void setTime(Date time) {
		this.time = time;
	}

}
