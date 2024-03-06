package com.avatarsac.retobackend.responses;

import java.util.List;

import com.avatarsac.retobackend.domains.Film;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class FilmListResponse {
	private int count;
	private List<Film> results;
	
	public FilmListResponse() {
    }
	
	public int getCount() {
		return count;
	}

	public List<Film> getResults() {
		return results;
	}

	public void setResults(List<Film> results) {
		this.results = results;
	}

	public void setCount(int count) {
		this.count = count;
	}
	
	
}


