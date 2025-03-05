package com.example.demo.dtos;

import lombok.Data;

@Data
public class ShopDTO {
	private int shopId;
	private String shopCategory;
	private String shopName;
	private String customers;
	private String shopStatus;
	private String leaseStatus;
}
