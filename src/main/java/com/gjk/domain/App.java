package com.gjk.domain;

import java.util.*;

import javax.persistence.*;

@Entity
public class App {

	@Id
	//@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int appId;
	private int parentAppId;
	private String appName;
	private String appDisplayName;
	
//	@OneToMany(fetch = FetchType.LAZY, mappedBy = "parentApp")
//	private List<App> childAppList;
//	
//	@ManyToOne(fetch = FetchType.LAZY)
//	@JoinColumn(name = "appId", nullable = false)
//	private App parentApp;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "app")
	private List<Param> paramList;

	public int getAppId() {
		return appId;
	}

	public void setAppId(int appId) {
		this.appId = appId;
	}

	public int getParentAppId() {
		return parentAppId;
	}

	public void setParentAppId(int parentAppId) {
		this.parentAppId = parentAppId;
	}

	public String getAppName() {
		return appName;
	}

	public void setAppName(String appName) {
		this.appName = appName;
	}

	public String getAppDisplayName() {
		return appDisplayName;
	}

	public void setAppDisplayName(String appDisplayName) {
		this.appDisplayName = appDisplayName;
	}

	public List<Param> getParamList() {
		return paramList;
	}

	public void setParamList(List<Param> paramList) {
		this.paramList = paramList;
	}
	
	
}
