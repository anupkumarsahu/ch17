package com.apress.prospring3.ch17.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Version;

@Entity
@Table(name="contact_tel_detail")
public class ContactTelDetail implements Serializable{

	private long id;
	private int version;
	private String telType;
	private String telNumber;
	private Contact contact;
	
	public ContactTelDetail(){
		
	}

	public ContactTelDetail(String telType, String telNumber) {
		this.telType = telType;
		this.telNumber = telNumber;
	}

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID")
	public long getId() {
		return id;
	}

	@Version
	@Column(name="VERSION")
	public int getVersion() {
		return version;
	}

	@Column(name="TEL_TYPE")
	public String getTelType() {
		return telType;
	}

	@Column(name="TEL_NUMBER")
	public String getTelNumber() {
		return telNumber;
	}

	public void setId(long id) {
		this.id = id;
	}

	public void setVersion(int version) {
		this.version = version;
	}

	public void setTelType(String telType) {
		this.telType = telType;
	}

	public void setTelNumber(String telNumber) {
		this.telNumber = telNumber;
	}

	@ManyToOne
	@JoinColumn(name="CONTACT_ID")
	public Contact getContact() {
		return contact;
	}

	public void setContact(Contact contact) {
		this.contact = contact;
	}
	
	public String toString() {
		return "Contact Tel Detail - Id: " + id + ", Contact id: "
		+ getContact().getId() + ", Type: "
		+ telType + ", Number: " + telNumber;
		}
}
