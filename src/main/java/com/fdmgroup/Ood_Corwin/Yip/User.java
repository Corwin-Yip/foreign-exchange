package com.fdmgroup.Ood_Corwin.Yip;

import java.util.Map;

public class User {
	private String name;
	private Map<String,Double> wallet;
	
	public User() {
		
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Map<String, Double> getWallet() {
		return wallet;
	}

	public void setWallet(Map<String, Double> wallet) {
		this.wallet = wallet;
	}
}
