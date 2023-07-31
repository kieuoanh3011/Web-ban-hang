package edu.poly.shop.model;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerDto {
	private Integer customerId;
	private String name;
	private String email;
	private String password;
	private String phone;
	private Date registeredDate;
	private short status;
}
