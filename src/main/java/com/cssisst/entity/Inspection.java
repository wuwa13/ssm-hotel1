package com.cssisst.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Inspection {
	private int id;
	private String person;
	private String itype;
	private String itime ;
	private String conductor;
	private String party;
	private String iresult;
	private String memo;
}
