package com.gjk.domain;

import java.util.*;

import javax.persistence.*;

@Entity
public class App {

	@Id
	//@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int appId;
	private String appName;
	private String appDisplayName;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "app")
	private List<Param> paramList;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "parentApp")
	private List<App> childAppList;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "parentAppId", nullable = true)
	private App parentApp;
	
	public App() {
		super();
	}

	public App(int appId) {
		super();
		this.appId = appId;
	}

	public App(int appId, String appName, String appDisplayName, List<App> childAppList, App parentApp, List<Param> paramList) {
		super();
		this.appId = appId;
		this.appName = appName;
		this.appDisplayName = appDisplayName;
		this.childAppList = childAppList;
		this.parentApp = parentApp;
		this.paramList = paramList;
	}

	public int getAppId() {
		return appId;
	}

	public void setAppId(int appId) {
		this.appId = appId;
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

	public List<App> getChildAppList() {
		return childAppList;
	}

	public void setChildAppList(List<App> childAppList) {
		this.childAppList = childAppList;
	}
	
	public int getParentAppId() {
		if(parentApp == null){
			return 0;
		}
		return parentApp.getAppId();
	}
	
}
