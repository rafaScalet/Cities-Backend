package com.cities.backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cities.backend.entities.City;

public interface CitiesRepository extends JpaRepository<City, Integer> { }
