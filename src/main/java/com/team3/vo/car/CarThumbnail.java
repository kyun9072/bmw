package com.team3.vo.car;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table
public class CarThumbnail {
	@Id	
	private int db_no;
	private String car_type;
	private String car_name;
	private String img_path;
}
