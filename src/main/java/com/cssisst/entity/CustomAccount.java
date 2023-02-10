package com.cssisst.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class CustomAccount {
	private int accountid;
	private String username;
	private String password;
	private String ownerid;
	private String carid;

}
