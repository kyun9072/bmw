package com.team3.vo.car;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table
public class CarSize {
	@Id
	private String carSize;
	private String carImg;
	
}
