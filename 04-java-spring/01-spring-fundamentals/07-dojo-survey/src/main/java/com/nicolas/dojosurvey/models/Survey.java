package com.nicolas.dojosurvey.models;

public class Survey {
	
	public String name;
	public String location;
	public String language;
	public String comment;
	
	public Survey(String name, String location, String language, String comment) {
		this.name = name;
		this.setLocation(location);
		this.setLanguage(language);
		this.setComment(comment);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}
	
}
