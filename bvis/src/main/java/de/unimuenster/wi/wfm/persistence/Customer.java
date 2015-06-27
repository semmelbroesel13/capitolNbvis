package de.unimuenster.wi.wfm.persistence;

import java.util.ArrayList;
import java.util.Collection;
import javax.validation.constraints.*;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;

@Entity
public class Customer extends AbstractEntity {

	private static final long serialVersionUID = 1L;

	@NotNull(message="You have to enter a value for the field 'Name'" )@Size(min=1, message="Name required.")
	protected String name;
	@NotNull(message="You have to enter a value for the field 'E-Mail'" )@Size(min=1, message="E-Mail required.")
	protected String email;
	@NotNull(message="You have to enter a value for the field 'Address'" )@Size(min=1, message="Address required.")
	protected String address;
	protected String phoneNumber;

	@OneToMany(fetch = FetchType.EAGER, cascade = { CascadeType.DETACH,
			CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH }, mappedBy = "customer")
	protected Collection<NegotiationCase> negotiationCases = new ArrayList<NegotiationCase>();

	@OneToMany(fetch = FetchType.EAGER, cascade = { CascadeType.DETACH,
			CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH }, mappedBy = "customer")
	protected Collection<InsuranceContract> insuranceContracts = new ArrayList<InsuranceContract>();

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	
	public Collection<NegotiationCase> getNegotiationCases() {
		return negotiationCases;
	}

	public Collection<InsuranceContract> getInsuranceContracts() {
		return insuranceContracts;
	}

}
