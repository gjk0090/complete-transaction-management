package com.gjk.domain;

import javax.persistence.*;

@Entity
public class Param {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int paramId;
	private String paramName;
	private String paramDisplayName;
	private int paramSequence;
	private String paramProperties;
	private String paramCategory;
	private String paramType;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "appId", nullable = false)
	private App app;

	public int getParamId() {
		return paramId;
	}

	public void setParamId(int paramId) {
		this.paramId = paramId;
	}

	public String getParamName() {
		return paramName;
	}

	public void setParamName(String paramName) {
		this.paramName = paramName;
	}

	public String getParamDisplayName() {
		return paramDisplayName;
	}

	public void setParamDisplayName(String paramDisplayName) {
		this.paramDisplayName = paramDisplayName;
	}

	public int getParamSequence() {
		return paramSequence;
	}

	public void setParamSequence(int paramSequence) {
		this.paramSequence = paramSequence;
	}

	public String getParamProperties() {
		return paramProperties;
	}

	public void setParamProperties(String paramProperties) {
		this.paramProperties = paramProperties;
	}

	public String getParamCategory() {
		return paramCategory;
	}

	public void setParamCategory(String paramCategory) {
		this.paramCategory = paramCategory;
	}

	public String getParamType() {
		return paramType;
	}

	public void setParamType(String paramType) {
		this.paramType = paramType;
	}

	//giving this will add a appId field in json
	public int getAppId() {
		return app.getAppId();
	}


//  Do not give getter for App, it will cause infinite loop in json
//	public App getApp() {
//		return app;
//	}
//	public void setParentApp(App app) {
//		this.app = app;
//	}

	
}
