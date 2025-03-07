package com.example.demo.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dtos.ShopDTO;
import com.example.demo.service.ShopService;

@RestController
public class ShopController {

	private ShopService shopService;

	public ShopController(ShopService shopService) {
		this.shopService = shopService;
	}
	@PostMapping("/api/shop")
	public ResponseEntity<ShopDTO>createShop(@RequestBody ShopDTO shopDTO){
		return new ResponseEntity<>(shopService.createShop(shopDTO),HttpStatus.CREATED);
	}
	@GetMapping("/api/shops")
	public List<ShopDTO>getAllShops(){
		return shopService.getAllShops();
	}
	@GetMapping("/api/shops/{id}")
	public ResponseEntity<ShopDTO>getShopById(@PathVariable("id")int id){
		return new ResponseEntity<ShopDTO>(shopService.getShopById(id),HttpStatus.ACCEPTED);
	}
	@PutMapping("/api/shop/update/{id}")
	public ResponseEntity<ShopDTO>updateShopById(@RequestBody ShopDTO shopDTO,@PathVariable(name = "id")int id){
		ShopDTO dto = shopService.updateShop(shopDTO, id);
		return new ResponseEntity<ShopDTO>(dto,HttpStatus.ACCEPTED);
	}

	@DeleteMapping("/api/shop/delete/{id}")
	public ResponseEntity<String>performDelete(@PathVariable("id")int id){
		shopService.delete(id);
		return new ResponseEntity<String>("success!",HttpStatus.OK);
	}
}
