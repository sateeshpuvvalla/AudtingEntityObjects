package com.audting.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.audting.model.City;
@Repository
public interface CityRepository extends JpaRepository<City, Long> {

}
