package br.com.jonnatas.serierestful.controller;

import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.jonnatas.serierestful.model.Serie;
import br.com.jonnatas.serierestful.service.SerieService;

/**
 * @author root
 *
 */
@RestController
@RequestMapping(value = "/series")
public class SerieController {

	@Autowired
	private SerieService serieService;

	/**
	 * @return
	 */
	@GetMapping
	public Set<Serie> findAllSeries() {
		return this.serieService.findAll();
	}

	/**
	 * @param id
	 * @return
	 */
	@GetMapping(value = "/{id}")
	public Serie findOne(@PathVariable("id") int id) {
		try {
			return this.serieService.findOne(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * @param serie
	 * @return
	 */
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Serie save(@RequestBody Serie serie) {
		return this.serieService.save(serie);
	}

	/**
	 * @param id
	 * @param json
	 * @param request
	 * @return
	 */
	@PutMapping(value = "/{id}")
	public Serie update(@PathVariable("id") int id, @RequestBody Map<String, Object> json, HttpServletRequest request) {
		return this.serieService.update(id, json);
	}

	/**
	 * 
	 */
	@DeleteMapping
	public void deleteAll() {
		this.serieService.deleteAll();
	}

	/**
	 * @param id
	 */
	@DeleteMapping(value = "/{id}")
	public void deleteOne(@PathVariable("id") int id) {
		this.serieService.deleteOne(id);
	}
}
