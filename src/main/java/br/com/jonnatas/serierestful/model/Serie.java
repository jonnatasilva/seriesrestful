package br.com.jonnatas.serierestful.model;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.util.Collections;
import java.util.Map;
import java.util.SortedSet;
import java.util.TreeSet;

import org.hibernate.validator.constraints.NotEmpty;

/**
 * @author root
 *
 */
public class Serie implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8262739112351435670L;

	private Integer id;

	@NotEmpty
	private String title;

	@NotEmpty
	private String description;

	@NotEmpty
	private String authors;

	private SortedSet<Season> seasons = new TreeSet<>();
	
	public Serie() {
		
	}
	
	/**
	 * @param id
	 */
	public Serie(Integer id) {
		this.id = id;
	}

	/**
	 * @param id
	 * @param title
	 * @param description
	 * @param authors
	 * @param seasons
	 */
	public Serie(Integer id, String title, String description, String authors, SortedSet<Season> seasons) {
		super();
		this.id = id;
		this.title = title;
		this.description = description;
		this.authors = authors;
		this.seasons = seasons;
	}
	
	/**
	 * @param id
	 * @param title
	 * @param description
	 * @param authors
	 */
	public Serie(Integer id, String title, String description, String authors) {
		super();
		this.id = id;
		this.title = title;
		this.description = description;
		this.authors = authors;
	}
	
	/**
	 * @param title
	 * @param description
	 * @param authors
	 * @param seasons
	 */
	public Serie(String title, String description, String authors, SortedSet<Season> seasons) {
		super();
		this.title = title;
		this.description = description;
		this.authors = authors;
		this.seasons = seasons;
	}

	/**
	 * @param title
	 * @param description
	 * @param authors
	 */
	public Serie(String title, String description, String authors) {
		super();
		this.title = title;
		this.description = description;
		this.authors = authors;
	}

	/**
	 * @return
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * @param id
	 */
	public void setId(Integer id) {
		this.id = id;
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

	/**
	 * @return
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * @return
	 */
	public String getAuthors() {
		return authors;
	}

	/**
	 * @param authors
	 */
	public void setAuthors(String authors) {
		this.authors = authors;
	}

	/**
	 * @return
	 */
	public SortedSet<Season> getSeasons() {
		return Collections.unmodifiableSortedSet(seasons);
	}

	/**
	 * @param seasons
	 */
	public void setSeasons(SortedSet<Season> seasons) {
		this.seasons = seasons;
	}
	
	/**
	 * @param season
	 */
	public void addSeason(Season season) {
		if(this.seasons == null)
			this.seasons = new TreeSet<>();
		this.seasons.add(season);
	}
	
	/**
	 * Return the serie seasons amount 
	 * @return
	 */
	public int getSeasonsAmount() {
		return this.seasons != null ? this.seasons.size() : 0;
	}
	
	/**
	 * That setup the value to declared fields, using map entry
	 * @param object
	 * @throws Exception
	 */
	public void copyFrom(Map<String, Object> object) throws Exception {
		object.forEach((k, v) -> {
			Field field;
			try {
				field = this.getClass().getDeclaredField(k);
				field.set(this, v);
			} catch (NoSuchFieldException | SecurityException | IllegalArgumentException | IllegalAccessException e) {
				try {
					throw e;
				} catch (Exception e1) {
					System.err.println("It wasnt possible throw excpetion" + e1.getMessage());
				}
			}
			
		});
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		Serie other = (Serie) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
}