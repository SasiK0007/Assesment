package com.example.demo.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "shop")
public class Shop {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int shopId;
	private String shopCategory;
	private String shopName;
	private String customers;
	private String shopStatus;
	private String leaseStatus;
}
