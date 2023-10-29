package com.uhg.optumrx.ms.hemi.bo;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class UsersDTO {

	private String userId;
	private String userName;
	private LocalDateTime lastUpdateDate;
	private LocalDateTime creationDate;
	private String emailAddress;
	private String customerId;
	private String employeeId;
	private String personPartyId;
	private String supplierId;
}
