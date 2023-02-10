package com.cssisst.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Notice {
	private int id;
	private String content;
	private String ndate;
	private String title;
	private String uper;
}
