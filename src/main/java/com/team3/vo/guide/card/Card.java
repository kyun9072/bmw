package com.team3.vo.guide.card;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class Card {
	@Id
	private int code;
	private String card;

	
}
