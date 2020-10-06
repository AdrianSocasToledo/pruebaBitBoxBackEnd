package com.prueba.bitbox.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.prueba.bitbox.model.PriceReduction;

@Repository
public interface PriceReductionRepository extends JpaRepository<PriceReduction, Integer>{

}
