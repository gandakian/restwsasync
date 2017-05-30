package com.amirbhujel.rest;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "check", namespace = "bharaththippireddy.com")
public class Check {
	private String checkNumber;
	private String accountNumber;
	private Double amount;

	public String getCheckNumber() {
		return checkNumber;
	}

	public void setCheckNumber(String checkNumber) {
		this.checkNumber = checkNumber;
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

}
