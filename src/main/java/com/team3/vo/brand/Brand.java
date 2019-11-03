package com.team3.vo.brand;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class Brand {
	
	@Id
	private String history;
	private String brandinfo;
	private String factoryinfo;
	
}
