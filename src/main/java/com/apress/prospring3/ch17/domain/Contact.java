package com.apress.prospring3.ch17.domain;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.persistence.Version;

import org.hibernate.annotations.Type;
import org.joda.time.DateTime;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

@Entity
@Table(name="contact")
public class Contact implements Serializable{
	private long id;
	private int version;
	private String firstName;
	private String lastName;
	private DateTime birthDate;
	private String description;
	private byte[] photo;

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="ID")
	public long getId() {
		return id;
	}
	
	@Version
	@Column(name="VERSION")
	public int getVersion() {
		return version;
	}
	
	@Column(name="FIRST_NAME")
	public String getFirstName() {
		return firstName;
	}
	
	@Column(name="LAST_NAME")
	public String getLastName() {
		return lastName;
	}
	
	@Column(name="BIRTH_DATE")
	@Type(type="org.joda.time.contrib.hibernate.PersistentDateTime")
	@DateTimeFormat(iso=ISO.DATE)
	public DateTime getBirthDate() {
		return birthDate;
	}
	
	@Column(name="DESCRIPTION")
	public String getDescription() {
		return description;
	}
	
	@Basic(fetch=FetchType.LAZY)
	@Lob
	@Column(name="PHOTO")
	public byte[] getPhoto() {
		return photo;
	}

	@Transient
	public String getBirthDateString(){
		String birthDateString = "";
		if(birthDateString != null){
			birthDateString = org.joda.time.format.DateTimeFormat.forPattern("yyyy-MM-dd").print(birthDate);
		}
		return birthDateString;
	}
	
	public String toString(){
		return "Contact - Id: " + id + ", First name: " + firstName
				+ ", Last name: " + lastName + ", Birthday: " + birthDate
				+ ", Description: " + description;
	}

	public void setId(long id) {
		this.id = id;
	}

	public void setVersion(int version) {
		this.version = version;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public void setBirthDate(DateTime birthDate) {
		this.birthDate = birthDate;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setPhoto(byte[] photo) {
		this.photo = photo;
	}
	
//	@OneToMany(mappedBy="contact", cascade=CascadeType.ALL, orphanRemoval=true)
//	public Set<ContactTelDetail> getContactTelDetails() {
//		return contactTelDetails;
//	}

//	public void setContactTelDetails(Set<ContactTelDetail> contactTelDetails) {
//		this.contactTelDetails = contactTelDetails;
//	}
	
//	public void addContactTelDetail(ContactTelDetail contactTelDetail){
//		contactTelDetail.setContact(this);
//		getContactTelDetails().add(contactTelDetail);
//	}
	
//	public void removeContactTelDetail(ContactTelDetail contactTelDetail){
//		getContactTelDetails().remove(contactTelDetail);
//	}

//	@ManyToMany
//	@JoinTable(name = "contact_hobby_detail",
//	joinColumns = @JoinColumn(name = "CONTACT_ID"),
//	inverseJoinColumns = @JoinColumn(name = "HOBBY_ID"))
//	public Set<Hobby> getHobbies() {
//		return hobbies;
//	}
//
//	public void setHobbies(Set<Hobby> hobbies) {
//		this.hobbies = hobbies;
//	}
	
	
}

