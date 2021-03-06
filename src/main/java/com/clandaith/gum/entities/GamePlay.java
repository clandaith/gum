package com.clandaith.gum.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "game_plays")
public class GamePlay {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	@Column(name = "user_id")
	private Integer userId;

	@Column(name = "game_system_id")
	private Integer gameSystemId;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "date_played")
	private Date datePlayed = new Date();

	@Column(name = "opponent_id")
	private Integer opponentId;

	private boolean winner;

	@JsonIgnore
	@ManyToOne()
	@JoinColumn(name = "user_id", insertable = false, updatable = false)
	private User user;

	@JsonIgnore
	@ManyToOne()
	@JoinColumn(name = "game_system_id", insertable = false, updatable = false)
	private GameSystem gameSystem;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Integer getGameSystemId() {
		return gameSystemId;
	}

	public void setGameSystemId(Integer gameSystemId) {
		this.gameSystemId = gameSystemId;
	}

	public Date getDatePlayed() {
		return datePlayed;
	}

	public void setDatePlayed(Date datePlayed) {
		this.datePlayed = datePlayed;
	}

	public Integer getOpponentId() {
		return opponentId;
	}

	public void setOpponentId(Integer opponentId) {
		this.opponentId = opponentId;
	}

	public boolean isWinner() {
		return winner;
	}

	public void setWinner(boolean winner) {
		this.winner = winner;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
}
