package br.com.jonnatas.serierestful.model;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * @author root
 *
 */
public class Episode implements Comparable<Episode> {
	
	@NotNull
	@JsonIgnore
	private Season season;
	
	@NotNull
	@Min(value = 1)
	private Integer number;
	
	private String title;
	
	/**
	 * @param season
	 * @param number
	 * @param title
	 */
	public Episode(Season season, Integer number, String title) {
		super();
		this.season = season;
		this.number = number;
		this.title = title;
	}
	
	/**
	 * @param season
	 * @param number
	 */
	public Episode(Season season, Integer number) {
		super();
		this.season = season;
		this.number = number;
	}

	/**
	 * @param number
	 * @param title
	 */
	public Episode(Integer number, String title) {
		super();
		this.number = number;
		this.title = title;
	}
	
	/**
	 * @return
	 */
	public Integer getNumber() {
		return number;
	}

	/**
	 * @param number
	 */
	public void setNumber(Integer number) {
		this.number = number;
	}

	/**
	 * @return
	 */
	public String getTitle() {
		return title;
	}
	
	/**
	 * @param title
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((number == null) ? 0 : number.hashCode());
		result = prime * result + ((season == null) ? 0 : season.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Episode other = (Episode) obj;
		if (number == null) {
			if (other.number != null)
				return false;
		} else if (!number.equals(other.number))
			return false;
		if (season == null) {
			if (other.season != null)
				return false;
		} else if (!season.equals(other.season))
			return false;
		return true;
	}

	@Override
	public int compareTo(Episode o) {
		return this.number.compareTo(o.getNumber());
	}

}
