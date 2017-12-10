package com.sia.Hib02;

import java.util.HashSet;
import java.util.Set;

public class User {
	private int id;
	private String name;
	private ProtienData protienData;
	private Set<UserHistory> history=new HashSet<>();
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public ProtienData getProtienData() {
		return protienData;
	}
	public void setProtienData(ProtienData protienData) {
		this.protienData = protienData;
	}
	public Set<UserHistory> getHistory() {
		return history;
	}
	public void setHistory(Set<UserHistory> history) {
		this.history = history;
	}
	
}
