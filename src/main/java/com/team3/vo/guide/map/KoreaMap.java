package com.team3.vo.guide.map;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class KoreaMap {
	private int code;
	private String cido;
	@Column(name = "cidocode")
	private int cidoCode;
	
	private String cigungoo;
	@Id
	@Column(name = "cigungoocode",nullable = true)
	private int cigungooCode;
	private String eupmyundong;
	
	
}
