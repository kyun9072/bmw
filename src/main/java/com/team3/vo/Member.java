
package com.team3.vo;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class Member {
	
	@Id
	private String username;
	private String password;
	
	private String email;
	private String name;
	private String phone;
	private int b_year;
	private int b_month;
	private int b_day;
	@Enumerated(EnumType.STRING)
	private Role role;
}
