package com.team3.vo.car;


import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table
public class Car {
	
	@Id
	private String car_model;
	@ManyToOne
	@JoinColumn(name="carSize")
	private CarSize carSize;
	private int car_year;
	private String img;
	private String mileage;
	private int price;
	private String detail;
	private String model3d;
	@ManyToOne
	@JoinColumn(name="db_no")
	private CarThumbnail db_no;
}

