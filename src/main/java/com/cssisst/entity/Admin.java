package com.cssisst.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Admin {
	private int id;
	private String name;
	private String password;
	private String sex;
	private int age;
	private String tel;
	private String phone;
	private String addr;
	private String memo;
}
