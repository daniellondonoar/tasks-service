package com.tasks.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "tasks")
public class Tasks {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idtask;
	
	@Column
	private String title;
	
	@Column
	private String description;
	
	@Column
	private Boolean state;
	
	@Column
	private String date_execution;
	
	@Column
	private String time_execution;
	
	@ManyToOne()
	@JoinColumn(name = "iduserone")
	private Users userResponsible;
	
	@ManyToOne()
	@JoinColumn(name = "idusertwo")
	private Users userAssigned;

	public Integer getIdtask() {
		return idtask;
	}

	public void setIdtask(Integer idtask) {
		this.idtask = idtask;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Boolean getState() {
		return state;
	}

	public void setState(Boolean state) {
		this.state = state;
	}

	public String getDate_execution() {
		return date_execution;
	}

	public void setDate_execution(String date_execution) {
		this.date_execution = date_execution;
	}

	public String getTime_execution() {
		return time_execution;
	}

	public void setTime_execution(String time_execution) {
		this.time_execution = time_execution;
	}

	public Users getUserResponsible() {
		return userResponsible;
	}

	public void setUserResponsible(Users userResponsible) {
		this.userResponsible = userResponsible;
	}

	public Users getUserAssigned() {
		return userAssigned;
	}

	public void setUserAssigned(Users usersAssigned) {
		this.userAssigned = usersAssigned;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
	
}
