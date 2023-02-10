package com.cssisst.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class House {
	private int id;
	private String num;
	private String dep;
	private String type;
	private String area;
	private String sell;
	private String unit;
	private String floor;
	private String direction;
	private String memo;
	private String ownerid;

}
