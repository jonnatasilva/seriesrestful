package br.com.jonnatas.serierestful.service;

import java.util.Map;
import java.util.Set;

import br.com.jonnatas.serierestful.model.Serie;

public interface SerieService {
	
	/**
	 * Find all series
	 * @return
	 */
	Set<Serie> findAll();
	
	/**
	 * Find one by id
	 * @param id
	 * @return
	 */
	Serie findOne(int id);
	
	/**
	 * Record or update a new serie
	 * @param serie
	 * @return
	 */
	Serie save(Serie serie);
	
	
	/**
	 * Update serie from a json object 
	 * @param id
	 * @param json
	 * @return
	 */
	Serie update(int id, Map<String, Object> json);
	
	/**
	 * Delete all series
	 */
	void deleteAll();
	
	/**
	 * Delete serie by id
	 * @param id
	 */
	void deleteOne(int id);

	/**
	 * Verify serie exist by id
	 * @param id
	 * @return
	 */
	boolean existSerie(int id);
	
}