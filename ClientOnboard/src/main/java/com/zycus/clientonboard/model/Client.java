package com.zycus.clientonboard.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@JsonIgnoreProperties(ignoreUnknown = true)
public class Client implements Serializable {

	private static final long serialVersionUID = -1556989854647085607L;

	@Id
	@Column
	String govtIdNumber;

	@Column
	String name;

	@Column
	int age;

	@Column
	Sex sex;

	@Column
	@Lob
	String permanentAddress;

	@Column
	@Lob
	String currentAddress;

	@Column
	String mail;

	@Column
	Long phone;

	@Column
	String country;

	@Column
	MaritalStatus martialStatus;

	@Column
	String spouseName;

	@Column
	String kidsName;

	@Column
	Date createTime;

	@Column
	Date lastUpdateTime;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public Sex getSex() {
		return sex;
	}

	public void setSex(Sex sex) {
		this.sex = sex;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public Long getPhone() {
		return phone;
	}

	public void setPhone(Long phone) {
		this.phone = phone;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getPermanentAddress() {
		return permanentAddress;
	}

	public void setPermanentAddress(String permanentAddress) {
		this.permanentAddress = permanentAddress;
	}

	public String getCurrentAddress() {
		return currentAddress;
	}

	public void setCurrentAddress(String currentAddress) {
		this.currentAddress = currentAddress;
	}

	public String getGovtIdNumber() {
		return govtIdNumber;
	}

	public void setGovtIdNumber(String govtIdNumber) {
		this.govtIdNumber = govtIdNumber;
	}

	public MaritalStatus getMartialStatus() {
		return martialStatus;
	}

	public void setMartialStatus(MaritalStatus martialStatus) {
		this.martialStatus = martialStatus;
	}

	public String getSpouseName() {
		return spouseName;
	}

	public void setSpouseName(String spouseName) {
		this.spouseName = spouseName;
	}

	public String getKidsName() {
		return kidsName;
	}

	public void setKidsName(String kidsName) {
		this.kidsName = kidsName;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getLastUpdateTime() {
		return lastUpdateTime;
	}

	public void setLastUpdateTime(Date lastUpdateTime) {
		this.lastUpdateTime = lastUpdateTime;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((govtIdNumber == null) ? 0 : govtIdNumber.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Client other = (Client) obj;
		if (govtIdNumber == null) {
			if (other.govtIdNumber != null)
				return false;
		} else if (!govtIdNumber.equals(other.govtIdNumber))
			return false;
		return true;
	}

}
