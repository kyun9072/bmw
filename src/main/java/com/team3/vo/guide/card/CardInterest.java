package com.team3.vo.guide.card;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Data;

@Data
@Entity
public class CardInterest {
	@Id
	private int pk;
	@ManyToOne
	@JoinColumn(name="code")
	private Card code;
	private int cardMonth;
	private Float interest;
	
}
