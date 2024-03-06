package com.avatarsac.retobackend.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;

import com.avatarsac.retobackend.domains.Film;
import com.avatarsac.retobackend.responses.FilmDetailResponse;
import com.avatarsac.retobackend.responses.FilmListResponse;
import com.avatarsac.retobackend.services.FilmService;

import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/v1")
public class FilmController {

	@Autowired
	private FilmService filmServiceImpl;
	
	@GetMapping(value = "/films")
	@CrossOrigin(methods = RequestMethod.GET, origins = {"http://localhost:5173/", "http://localhost:5173/films"})
	public Mono<FilmListResponse> getAllFilms(){
		return filmServiceImpl.getAll();
	}
	
	
	@GetMapping(value = "/films/{id}")
	@CrossOrigin(methods = RequestMethod.GET, origins = "http://localhost:5173/")
	public Mono<FilmDetailResponse> getFilmById(@PathVariable Long id){
		return filmServiceImpl.getById(id);
	}
	
	
}
