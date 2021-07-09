package com.thondo.whatsappconnect.enums;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public enum ApplicationStatus {
	
	PENDING("Pending"),
	APPROVED("Approved"),
	COMPLETED("Completed");

	private String value;
	ApplicationStatus(String value){
		this.value = value;

	}

	public static boolean contains(String test) {
		for (ApplicationStatus c : ApplicationStatus.values()) {
			if (c.value.equals(test)) {
				return true;
			}
		}
		return false;
	}

	public String getValue() {
		return value;
	}

	public static List<String> getAllStatuses() {
		return Arrays.stream(ApplicationStatus.values())
				.map(ApplicationStatus::getValue).collect(Collectors.toList());
	}
}
