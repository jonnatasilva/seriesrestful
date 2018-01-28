package br.com.jonnatas.serierestful.service.impl;

import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.jonnatas.serierestful.dao.DAOSerie;
import br.com.jonnatas.serierestful.model.Serie;
import br.com.jonnatas.serierestful.service.SerieService;

/**
 * @author root
 *
 */
@Service
public class SerieServiceImpl implements SerieService {
	
	@Autowired
	private DAOSerie daoSerie;

	@Override
	public Set<Serie> findAll() {
		return this.daoSerie.findAll();
	}

	@Override
	public Serie findOne(int id) {
		if(existSerie(id)) {
			return this.daoSerie.findOne(id);
		}
		return null;
	}
	
	@Override
	public Serie save(Serie serie) {
		return this.daoSerie.save(serie);
	}
	
	@Override
	public Serie update(int id, Map<String, Object> json) {
		Serie serie = new Serie(id);
		if(this.existSerie(id)) {
			serie = this.findOne(id);
		}
		try {
			serie.copyFrom(json);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return this.daoSerie.save(serie);
	}

	@Override
	public void deleteAll() {
		this.daoSerie.deleteAll();
	}

	@Override
	public void deleteOne(int id) {
		if(existSerie(id)) {
			this.daoSerie.deleteOne(id);
		}
	}

	@Override
	public boolean existSerie(int id) {
		return this.daoSerie.containSerie(id);
	}
}
