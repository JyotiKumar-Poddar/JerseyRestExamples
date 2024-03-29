package com.org.webapp.modal;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Activity {

	private String id;
	private String description;
	private int duration;
    
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	@XmlElement(name="desc")
	public void setDescription(String description) {
		this.description = description;
	}

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	@Override
	public String toString() {
		return "Activity [id=" + id + ", description=" + description
				+ ", duration=" + duration + "]";
	}
	
	

}
