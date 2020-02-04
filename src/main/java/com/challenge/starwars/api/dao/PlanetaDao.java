package com.challenge.starwars.api.dao;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.challenge.starwars.api.model.Planeta;

public interface PlanetaDao extends MongoRepository<Planeta, String>{

	Planeta findByNome(String nome);
}
