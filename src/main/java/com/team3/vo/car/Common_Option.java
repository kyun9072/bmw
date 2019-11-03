package com.team3.vo.car;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table
public class Common_Option {
	@ManyToOne
	@JoinColumn(name="carSize")
	private CarSize carSize;
	@Id
	private int code;
	private String c_option;
	private int price;
}
