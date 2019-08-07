package com.palani.springmongo.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
 
import lombok.Data;
 
@Data
@Document(collection = "sales")
public class Sales {
	
	@Id
	private String id;
	private String paymentType;
	private int numberOfItems;
	private double saleAmount;
	
	
}
