package com.avatarsac.retobackend.responses;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@JsonIgnoreProperties(ignoreUnknown = true)
public class FilmDetailResponse {
	 private String title;
	 private String opening_crawl;
	 private String director;
	 private String producer;
	 private String release_date;
	 private List<CharacterItem> characters;
	 
	 public FilmDetailResponse() {
		 
	 }
	 
	 public FilmDetailResponse(String title, String opening_crawl, String director, List<CharacterItem> characters, String producer, String release_date) {
		 this.title = title;
		 this.opening_crawl = opening_crawl;
		 this.director = director;
		 this.characters = characters;
		 this.producer = producer;
		 this.release_date = release_date;
	 }

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getOpening_crawl() {
		return opening_crawl;
	}

	public void setOpening_crawl(String opening_crawl) {
		this.opening_crawl = opening_crawl;
	}

	public String getDirector() {
		return director;
	}

	public void setDirector(String director) {
		this.director = director;
	}

	public List<CharacterItem> getCharacters() {
		return characters;
	}

	public void setCharacters(List<CharacterItem> characters) {
		this.characters = characters;
	}

	public String getProducer() {
		return producer;
	}

	public void setProducer(String producer) {
		this.producer = producer;
	}

	public String getRelease_date() {
		return release_date;
	}

	public void setRelease_date(String release_date) {
		this.release_date = release_date;
	}
	
	
	 
}

