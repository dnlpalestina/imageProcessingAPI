package com.globant.teamsix.models.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@AllArgsConstructor
@Getter
@ToString
public enum StatusEnum {

	CREATED("CREATED", "Created Image status"), IN_PROGRESS("IN_PROGRESS", "In progress Image process status"),
	COMPLETED("COMPLETED", "Completed Image Process status"), FAILED("FAILED", "Failed Image Process status");

	private String statusName;
	private String statusDescription;
	
}
