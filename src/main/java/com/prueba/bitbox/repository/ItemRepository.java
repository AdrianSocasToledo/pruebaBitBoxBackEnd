package com.prueba.bitbox.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.prueba.bitbox.model.Item;

@Repository
public interface ItemRepository extends JpaRepository<Item, Integer>{

}
