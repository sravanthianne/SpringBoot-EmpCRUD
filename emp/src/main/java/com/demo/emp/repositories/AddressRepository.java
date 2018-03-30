package com.demo.emp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.emp.domain.Address;

public interface AddressRepository extends JpaRepository<Address, Long>{
}
