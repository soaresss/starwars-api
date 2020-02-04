package com.challenge.starwars.api.services;

import java.util.List;
import java.util.Optional;

import com.challenge.starwars.api.model.Planeta;

public interface PlanetaService {
	
	List<Planeta> listarPlanetas();
	
	Optional<Planeta> buscarPorId(String id);
	
	Planeta buscarPorNome(String nome);
	
	Planeta cadastrar(Planeta planeta);
	
	void remover(String id);

}
