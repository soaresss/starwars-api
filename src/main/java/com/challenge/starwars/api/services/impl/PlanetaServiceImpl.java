package com.challenge.starwars.api.services.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.challenge.starwars.api.dao.PlanetaDao;
import com.challenge.starwars.api.model.Planeta;
import com.challenge.starwars.api.services.PlanetaService;

@Service
public class PlanetaServiceImpl implements PlanetaService {

	@Autowired
	private PlanetaDao planetaDao;
	
	@Override
	public List<Planeta> listarPlanetas() {
		return this.planetaDao.findAll();
	}

	@Override
	public Optional<Planeta> buscarPorId(String id) {
		return this.planetaDao.findById(id);
	}

	@Override
	public Planeta cadastrar(Planeta planeta) {
		return this.planetaDao.save(planeta);
	}

	@Override
	public void remover(String id) {
		this.planetaDao.deleteById(id);
	}

	@Override
	public Planeta buscarPorNome(String nome) {
		return this.planetaDao.findByNome(nome);
	}
}
