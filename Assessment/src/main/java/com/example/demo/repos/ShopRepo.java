package com.example.demo.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entities.Shop;
import java.util.List;


public interface ShopRepo extends JpaRepository<Shop,Integer>{

}
