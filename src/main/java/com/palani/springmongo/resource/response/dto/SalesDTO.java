package com.palani.springmongo.resource.response.dto;

import com.palani.springmongo.util.PaymentTypeEnum;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class SalesDTO {
	
	 private String saleId;
	 private int numberOfItems;
	 private String paymentType;
	 private double saleAmount;

}
