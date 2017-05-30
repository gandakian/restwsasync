package com.amirbhujel.rest;

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "CheckList", namespace = "bharaththippireddy.com")
public class ChecksList {
	
	private List<Check> checks;

	public List<Check> getChecks() {
		return checks;
	}

	public void setChecks(List<Check> checks) {
		this.checks = checks;
	}
	 
	

}
