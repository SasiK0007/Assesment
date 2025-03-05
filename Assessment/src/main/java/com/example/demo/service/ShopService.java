package com.example.demo.service;

import java.util.List;

import com.example.demo.dtos.ShopDTO;

public interface ShopService {

	ShopDTO createShop(ShopDTO shopDTO);
	List<ShopDTO>getAllShops();
	ShopDTO getShopById(int id);
	ShopDTO updateShop(ShopDTO shopDTO,int id);
}
