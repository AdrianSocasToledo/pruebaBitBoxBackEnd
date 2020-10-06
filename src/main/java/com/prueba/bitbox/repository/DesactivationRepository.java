package com.prueba.bitbox.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.prueba.bitbox.model.Desactivation;

@Repository
public interface DesactivationRepository extends JpaRepository<Desactivation, Integer>{

}
