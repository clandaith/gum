package com.clandaith.gum.entities;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "game_systems")
public class GameSystem {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	@Column(name = "game_company_id")
	private Integer gameCompanyId;
	private String name;
	private String website;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "date_added")
	private Date dateAdded = new Date();

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "date_updated")
	private Date dateUpdated = new Date();
	private String description;

	@OneToMany(mappedBy = "gameSystem", cascade = CascadeType.ALL)
	private List<GamePlay> gamePlays;

	@JsonIgnore
	@ManyToOne()
	@JoinColumn(name = "game_company_id", insertable = false, updatable = false)
	private GameCompany gameCompany;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getGameCompanyId() {
		return gameCompanyId;
	}

	public void setGameCompanyId(Integer gameCompanyId) {
		this.gameCompanyId = gameCompanyId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getWebsite() {
		return website;
	}

	public void setWebsite(String website) {
		this.website = website;
	}

	public Date getDateAdded() {
		return dateAdded;
	}

	public void setDateAdded(Date dateAdded) {
		this.dateAdded = dateAdded;
	}

	public Date getDateUpdated() {
		return dateUpdated;
	}

	public void setDateUpdated(Date dateUpdated) {
		this.dateUpdated = dateUpdated;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<GamePlay> getGamePlays() {
		return gamePlays;
	}

	public void setGamePlays(List<GamePlay> gamePlays) {
		this.gamePlays = gamePlays;
	}

	public GameCompany getGameCompany() {
		return gameCompany;
	}

	public void setGameCompany(GameCompany gameCompany) {
		this.gameCompany = gameCompany;
	}
}
