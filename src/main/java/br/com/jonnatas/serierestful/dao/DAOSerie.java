package br.com.jonnatas.serierestful.dao;

import java.util.Set;

import br.com.jonnatas.serierestful.model.Serie;

/**
 * @author root
 *
 */
public interface DAOSerie {

	/**
	 * Find all
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
	 * Record or update
	 * @param serie
	 * @return
	 */
	Serie save(Serie serie);

	/**
	 * Delete all
	 */
	void deleteAll();

	/**
	 * Delete one by id
	 * @param id
	 */
	void deleteOne(int id);
	
	/**
	 * Verify if id there are in repository 
	 * @param id
	 * @return
	 */
	public boolean containSerie(int id);

}
