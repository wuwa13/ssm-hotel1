package com.cssisst.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Maintain {
	private int id;
	private String thing;
	private String status;
	private String homesnumber;
	private String sdate;
	private String rdate;
	private double tcost;
	private double scost;
	private String maintainer;
	private String smemo;

}
