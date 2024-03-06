package com.avatarsac.retobackend.services;

import com.avatarsac.retobackend.domains.Film;
import com.avatarsac.retobackend.responses.FilmDetailResponse;
import com.avatarsac.retobackend.responses.FilmListResponse;

import reactor.core.publisher.Mono;

public interface FilmService {
	public Mono<FilmListResponse> getAll();
	public Mono<FilmDetailResponse> getById(Long id);
}
