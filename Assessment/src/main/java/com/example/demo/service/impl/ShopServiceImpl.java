package com.example.demo.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.example.demo.dtos.ShopDTO;
import com.example.demo.entities.Shop;
import com.example.demo.repos.ShopRepo;
import com.example.demo.service.ShopService;
@Service
public class ShopServiceImpl implements ShopService {

	private ShopRepo shopRepo;
	
	public ShopServiceImpl(ShopRepo shopRepo) {
		this.shopRepo = shopRepo;
	}

	@Override
	public ShopDTO createShop(ShopDTO shopDTO) {
		// TODO Auto-generated method stub
		Shop shop = mapTOEntity(shopDTO);
		Shop savings = shopRepo.save(shop);
		ShopDTO dto = mapToDTO(shop);
		return dto;
	}

	private ShopDTO mapToDTO(Shop shop) {
		ShopDTO shopDTO = new ShopDTO();
		shopDTO.setCustomers(shop.getCustomers());
		shopDTO.setLeaseStatus(shop.getLeaseStatus());
		shopDTO.setShopCategory(shop.getShopCategory());
		shopDTO.setShopId(shop.getShopId());
		shopDTO.setShopName(shop.getShopName());
		shopDTO.setShopStatus(shop.getShopStatus());
		return shopDTO;
	}
	private Shop mapTOEntity(ShopDTO shopDTO) {
		Shop shop = new Shop();
		shop.setCustomers(shopDTO.getCustomers());
		shop.setLeaseStatus(shopDTO.getLeaseStatus());
		shop.setShopCategory(shopDTO.getShopCategory());
		shop.setShopId(shopDTO.getShopId());
		shop.setShopName(shopDTO.getShopName());
		shop.setShopStatus(shopDTO.getShopStatus());
		return shop;
	}

	@Override
	public List<ShopDTO> getAllShops() {
		// TODO Auto-generated method stub
		List<Shop>shop = shopRepo.findAll();
		return shop.stream().map(shp->mapToDTO(shp)).collect(Collectors.toList());
	}

	@Override
	public ShopDTO getShopById(int id) {
		// TODO Auto-generated method stub
		 Shop ax = shopRepo.findById(id).orElse(null);
		 return mapToDTO(ax);
		
	}

	@Override
	public ShopDTO updateShop(ShopDTO shopDTO, int id) {
		// TODO Auto-generated method stub
		Shop shop = shopRepo.findById(id).orElseThrow(null);
		shop.setCustomers(shopDTO.getCustomers());
		Shop updatedShop = shopRepo.save(shop);
		return mapToDTO(updatedShop);
	}

	@Override
	public void deletePostById(int id) {
		// TODO Auto-generated method stub
		Optional<Shop> shop = shopRepo.findById(id);
        shopRepo.delete(new Shop());
	}

}
