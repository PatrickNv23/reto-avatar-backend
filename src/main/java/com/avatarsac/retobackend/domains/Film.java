package com.avatarsac.retobackend.domains;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Film {
	private String title;
	private String opening_crawl;
	private String director;
}
