package br.com.jonnatas.serierestful.model;

import java.util.Collections;
import java.util.SortedSet;
import java.util.TreeSet;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * @author root
 *
 */
public class Season implements Comparable<Season> {

	@NotNull
	@JsonIgnore
	private Serie serie;

	@NotNull
	@Min(value = 1)
	private Integer number;

	private SortedSet<Episode> episodes = new TreeSet<>();

	/**
	 * @param serie
	 * @param number
	 * @param episodes
	 */
	public Season(Serie serie, Integer number, SortedSet<Episode> episodes) {
		super();
		this.serie = serie;
		this.number = number;
		this.episodes = episodes;
	}

	/**
	 * @param serie
	 * @param number
	 */
	public Season(Serie serie, Integer number) {
		super();
		this.serie = serie;
		this.number = number;
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
	 * Return an unmodifiableSortSet of episodes
	 * @return
	 */
	public SortedSet<Episode> getEpisodes() {
		return Collections.unmodifiableSortedSet(episodes);
	}

	/**
	 * @param episodes
	 */
	public void setEpisodes(SortedSet<Episode> episodes) {
		this.episodes = episodes;
	}

	/**
	 * Add new epsodie, if epsodies list is null,
	 * the epsodies list will initialized
	 * @param episode
	 */
	public void addEpisode(Episode episode) {
		if (this.episodes == null)
			this.episodes = new TreeSet<>();
		this.episodes.add(episode);
	}

	/**
	 * Return the season epsodes amount
	 * @return
	 */
	public int getEpsodiesAmount() {
		return this.episodes != null ? this.episodes.size() : 0;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((number == null) ? 0 : number.hashCode());
		result = prime * result + ((serie == null) ? 0 : serie.hashCode());
		return result;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Season other = (Season) obj;
		if (number == null) {
			if (other.number != null)
				return false;
		} else if (!number.equals(other.number))
			return false;
		if (serie == null) {
			if (other.serie != null)
				return false;
		} else if (!serie.equals(other.serie))
			return false;
		return true;
	}

	/* (non-Javadoc)
	 * @see java.lang.Comparable#compareTo(java.lang.Object)
	 */
	@Override
	public int compareTo(Season o) {
		return this.number.compareTo(o.getNumber());
	}
}
