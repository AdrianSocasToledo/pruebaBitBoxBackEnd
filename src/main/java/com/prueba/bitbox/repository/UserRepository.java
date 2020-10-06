package com.prueba.bitbox.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.prueba.bitbox.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

}
