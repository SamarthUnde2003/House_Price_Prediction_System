package org.controller;

import org.model.locationmodel;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class propertymodel extends locationmodel{
	private int pid;
	private String pname;
	private int page;
	private int parea;
	private int pbath;
	private int pbed;
}
