package com.challenge.starwars.api.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.challenge.starwars.api.model.Planeta;
import com.challenge.starwars.api.response.Response;
import com.challenge.starwars.api.services.PlanetaService;

@RestController
@RequestMapping(path = "/api/planetas")
public class PlanetaController {
	
	@Autowired
	private PlanetaService planetaService;

	@GetMapping
	public ResponseEntity<Response<List<Planeta>>> listarTodos() {
		return ResponseEntity.ok(new Response<List<Planeta>>(this.planetaService.listarPlanetas()));
	}

	@GetMapping(path = "/id/{id}")
	public ResponseEntity<Response<Optional<Planeta>>> buscarPorId(@PathVariable(name = "id") String id) {
		return ResponseEntity.ok(new Response<Optional<Planeta>>(this.planetaService.buscarPorId(id)));
	}
	
	@GetMapping(path = "/nome/{nome}")
	public ResponseEntity<Response<Planeta>> buscarPorNome(@PathVariable(name = "nome") String nome) {
		return ResponseEntity.ok(new Response<Planeta>(this.planetaService.buscarPorNome(nome)));
	}

	@PostMapping
	public ResponseEntity<Response<Planeta>> cadastrar(@Valid @RequestBody Planeta planeta, BindingResult result) {
		if (result.hasErrors()) {
			List<String> errors = new ArrayList<String>();
			result.getAllErrors().forEach(erro -> errors.add(erro.getDefaultMessage()));
			return ResponseEntity.badRequest().body(new Response<Planeta>(errors));
		}
		return ResponseEntity.ok(new Response<Planeta>(this.planetaService.cadastrar(planeta)));
	}

	@DeleteMapping(path = "/{id}")
	public ResponseEntity<Response<Integer>> remover(@PathVariable(name = "id") String id) {
		this.planetaService.remover(id);
		return ResponseEntity.ok(new Response<Integer>(1));
	}
}