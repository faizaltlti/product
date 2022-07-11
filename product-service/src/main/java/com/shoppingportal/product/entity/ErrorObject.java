package com.shoppingportal.product.entity;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ErrorObject {

	private Integer statusCode;
	
	private String message;
	
	private Date timestamp;
}
