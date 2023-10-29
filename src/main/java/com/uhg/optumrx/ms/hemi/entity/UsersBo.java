package com.uhg.optumrx.ms.hemi.entity;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.microsoft.azure.spring.data.cosmosdb.core.mapping.Document;
import com.microsoft.azure.spring.data.cosmosdb.core.mapping.PartitionKey;

import lombok.Data;

@Data
@Document(collection="fnd_Users")
public class UsersBo {

	
	@PartitionKey
	private String userId;
	private String userName;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss.SSS", timezone = "UTC")
	private LocalDateTime lastUpdateDate;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss.SSS", timezone = "UTC")
	private LocalDateTime creationDate;
	private String emailAddress;
	private String customerId;
	private String employeeId;
	private String personPartyId;
	private String supplierId;
}
