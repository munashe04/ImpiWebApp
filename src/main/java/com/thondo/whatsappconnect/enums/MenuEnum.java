package com.thondo.whatsappconnect.enums;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public enum MenuEnum {

	REGISTRATION("Registration"),
	ORDER("Order"),
	REGISTRATION_APPROVAL("Registration Approval");



	private String value;
	MenuEnum(String value){
		this.value = value;

	}


	public String getValue() {
		return value;
	}

	public static List<String> getAllStatuses() {
		return Arrays.stream(MenuEnum.values())
				.map(MenuEnum::getValue).collect(Collectors.toList());
	}
}
