package com.GitHub.POJO;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown=true)
public class responsePOJO {
	
	/*public class Owner {
		private String login;
		private String type;
		
		public String getLogin() {
			return login;
		}
		public void setLogin(String login) {
			this.login = login;
		}
		
		public String getType() {
			return type;
		}
		public void setType(String type) {
			this.type = type;
		}*/
	
	private Integer id;
	private String name;
	private String owner;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getOwner() {
		return owner;
	}
	public void setOwner(String owner) {
		this.owner = owner;
	}
	public String getFull_name() {
		return full_name;
	}
	public void setFull_name(String full_name) {
		this.full_name = full_name;
	}
	private String full_name;
	
	
	

}
