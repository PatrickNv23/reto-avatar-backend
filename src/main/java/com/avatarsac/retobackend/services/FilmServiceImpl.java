package com.avatarsac.retobackend.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.avatarsac.retobackend.responses.FilmDetailResponse;
import com.avatarsac.retobackend.responses.FilmListResponse;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import com.avatarsac.retobackend.responses.CharacterItem;

@Service
public class FilmServiceImpl implements FilmService {

	private static final String BASE_URL = "https://swapi.dev/api/";
	private static final String ENDPOINT_FILMS = "films";

	@Autowired
	private WebClient.Builder webClientBuilder;

	@Override
	public Mono<FilmListResponse> getAll() {
		return webClientBuilder.build().get().uri(BASE_URL+ENDPOINT_FILMS).retrieve()
				.bodyToMono(FilmListResponse.class);
	}

	@Override
	public Mono<FilmDetailResponse> getById(Long id) {
		Mono<Map> movieDetailsMono = webClientBuilder.build()
                .get()
                .uri(BASE_URL+ENDPOINT_FILMS+"/"+id)
                .retrieve()
                .bodyToMono(Map.class);
		
		 return movieDetailsMono.flatMap(movieDetails -> {
	            List<String> characterUrls = (List<String>) movieDetails.get("characters");

	            List<Mono<CharacterItem>> characterMonos = characterUrls.stream()
	                    .map(characterUrl -> webClientBuilder.build().get()
	                            .uri(characterUrl)
	                            .retrieve()
	                            .bodyToMono(CharacterItem.class))
	                    .collect(ArrayList::new, ArrayList::add, ArrayList::addAll);

	            return Flux.merge(characterMonos)
	                    .collectList()
	                    .map(characters -> new FilmDetailResponse(
	                            (String) movieDetails.get("title"),
	                            (String) movieDetails.get("opening_crawl"),
	                            (String) movieDetails.get("director"),
	                            characters,
	                            (String) movieDetails.get("producer"),
	                            (String) movieDetails.get("release_date")));
	                            
	        });
	}
}
