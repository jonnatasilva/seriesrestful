package br.com.jonnatas.serierestful.dao.impl;

import java.util.HashSet;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

import org.springframework.stereotype.Repository;

import br.com.jonnatas.serierestful.dao.DAOSerie;
import br.com.jonnatas.serierestful.model.Episode;
import br.com.jonnatas.serierestful.model.Season;
import br.com.jonnatas.serierestful.model.Serie;

/**
 * @author root
 *
 */
@Repository
public class DAOSerieStub implements DAOSerie {

	private Set<Serie> series = new HashSet<>();
	private Integer countId = 2;

	public DAOSerieStub() {
		initializeSeries();
	}

	@Override
	public Set<Serie> findAll() {
		return this.series;
	}

	@Override
	public Serie findOne(int id) {
		return this.series.stream().filter(serie -> {
			return serie.equals(new Serie(id));
		}).findFirst().get();
	}

	@Override
	public boolean containSerie(int id) {
		return this.series.contains(new Serie(id));
	}

	@Override
	public Serie save(Serie serie) {
		if (serie.getId() == null || serie.getId() <= 0) {
			serie.setId(++countId);
		} else {
			this.series.remove(new Serie(serie.getId()));
		}
		this.series.add(serie);
		return serie;
	}

	@Override
	public void deleteAll() {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteOne(int id) {
		this.series.remove(new Serie(id));
	}

	private void initializeSeries() {
		Serie got = new Serie(1, "Game Of Thrones",
				"Há muito tempo, em um tempo esquecido, uma força destruiu o equilíbrio das estações. Em uma terra onde os verões podem durar vários anos e o inverno toda uma vida, as reivindicações e as forças sobrenaturais correm as portas do Reino dos Sete Reinos. A irmandade da Patrulha da Noite busca proteger o reino de cada criatura que pode vir de lá da Muralha, mas já não tem os recursos necessários para garantir a segurança de todos. Depois de um verão de dez anos, um inverno rigoroso promete chegar com um futuro mais sombrio. Enquanto isso, conspirações e rivalidades correm no jogo político pela disputa do Trono de Ferro, o símbolo do poder absoluto.",
				"D.B Weiss, David Benioff");
		got.setSeasons(createSeasonGOT(got));
		this.series.add(got);

		Serie mrRobot = new Serie(2, "Mr. Robot",
				"Elliot (Rami Malek) é um jovem programador que trabalha como engenheiro de segurança virtual durante o dia, e como hacker vigilante durante a noite. Elliot se vê numa encruzilhada quando o líder (Christian Slater) de um misterioso grupo de hacker o recruta para destruir a firma que ele é pago para proteger. Motivado pelas suas crenças pessoais, ele luta para resistir à chance de destruir os CEOs da multinacional que ele acredita estarem controlando - e destruindo - o mundo.",
				"Sam Esmail");

		mrRobot.setSeasons(createSeasonMrRobot(mrRobot));
		this.series.add(mrRobot);
	}

	private SortedSet<Season> createSeasonMrRobot(Serie mrRobot) {
		SortedSet<Season> seasons = new TreeSet<>();
		Season season1 = new Season(mrRobot, 1);
		season1.setEpisodes(createEpsodesSeason1MrRobot(season1));
		seasons.add(season1);

		Season season2 = new Season(mrRobot, 2);
		season2.setEpisodes(createEpsodesSeason2MrRobot(season2));
		seasons.add(season2);

		Season season3 = new Season(mrRobot, 3);
		season3.setEpisodes(createEpsodesSeason3MrRobot(season3));
		seasons.add(season3);
		return seasons;
	}

	private SortedSet<Season> createSeasonGOT(Serie got) {
		SortedSet<Season> seasons = new TreeSet<>();
		Season season1 = new Season(got, 1);
		season1.setEpisodes(createEpsodesSeason1GOT(season1));
		seasons.add(season1);

		Season season2 = new Season(got, 2);
		season2.setEpisodes(createEpsodesSeason2GOT(season2));
		seasons.add(season2);

		Season season3 = new Season(got, 3);
		season3.setEpisodes(createEpsodesSeason3GOT(season3));
		seasons.add(season3);
		return seasons;

	}

	private SortedSet<Episode> createEpsodesSeason1GOT(Season season) {
		SortedSet<Episode> eps = new TreeSet<>();
		eps.add(new Episode(season, 1, "Winter Is Coming"));
		eps.add(new Episode(season, 2, "The Kingsroad"));
		eps.add(new Episode(season, 3, "Lord Snow"));
		eps.add(new Episode(season, 4, "Cripples, Bastards, and Broken Things"));
		eps.add(new Episode(season, 5, "The Wolf and the Lion"));
		eps.add(new Episode(season, 6, "A Golden Crown"));
		eps.add(new Episode(season, 7, "You Win or You Die"));
		eps.add(new Episode(season, 8, "The Pointy End"));
		eps.add(new Episode(season, 9, "Baelor"));
		eps.add(new Episode(season, 10, "Fire and Blood"));
		return eps;
	}

	private SortedSet<Episode> createEpsodesSeason2GOT(Season season) {
		SortedSet<Episode> eps = new TreeSet<>();
		eps.add(new Episode(season, 1, "The North Remembers"));
		eps.add(new Episode(season, 2, "The Night Lands"));
		eps.add(new Episode(season, 3, "What Is Dead May Never Die"));
		eps.add(new Episode(season, 4, "Garden of Bones"));
		eps.add(new Episode(season, 5, "The Ghost of Harrenhal"));
		eps.add(new Episode(season, 6, "The Old Gods and the New"));
		eps.add(new Episode(season, 7, "A Man Without Honor"));
		eps.add(new Episode(season, 8, "The Prince of Winterfell"));
		eps.add(new Episode(season, 9, "Blackwater"));
		eps.add(new Episode(season, 10, "Valor Morghulis"));
		return eps;
	}

	private SortedSet<Episode> createEpsodesSeason3GOT(Season season) {
		SortedSet<Episode> eps = new TreeSet<>();
		eps.add(new Episode(season, 1, "Valar Dohaeris"));
		eps.add(new Episode(season, 2, "Dark Wings, Dark Words"));
		eps.add(new Episode(season, 3, "Walk of Punishment"));
		eps.add(new Episode(season, 4, "And Now His Watch is Ended"));
		eps.add(new Episode(season, 5, "Kissed by Fire"));
		eps.add(new Episode(season, 6, "The Climb"));
		eps.add(new Episode(season, 7, "The Bear and the Maiden Fair"));
		eps.add(new Episode(season, 8, "Second Sons"));
		eps.add(new Episode(season, 9, "The Rains of Castamere"));
		eps.add(new Episode(season, 10, "Mhysa"));
		return eps;
	}

	private SortedSet<Episode> createEpsodesSeason1MrRobot(Season season) {
		SortedSet<Episode> eps = new TreeSet<>();
		eps.add(new Episode(season, 1, "eps1.0_hellofriend.mov"));
		eps.add(new Episode(season, 2, "eps.1.1_ones-and-zer0es.mpeg"));
		eps.add(new Episode(season, 3, "eps.1.2_d3bug.mkv"));
		eps.add(new Episode(season, 4, "eps.1.3_da3m0ns.mp4"));
		eps.add(new Episode(season, 5, "eps1.4_3xpl0its.wmv"));
		eps.add(new Episode(season, 6, "eps.1.5_br4ve-trave1er.asf"));
		eps.add(new Episode(season, 7, "eps1.6_v1ew-s0urce.flv"));
		eps.add(new Episode(season, 8, "eps1.7_wh1ter0se.m4v"));
		eps.add(new Episode(season, 9, "eps1.8_m1rr0r1ng.qt"));
		eps.add(new Episode(season, 10, "eps1.9_zer0-day.avi"));
		return eps;
	}

	private SortedSet<Episode> createEpsodesSeason2MrRobot(Season season) {
		SortedSet<Episode> eps = new TreeSet<>();
		eps.add(new Episode(season, 1, "eps2.0unm4sk-pt1.tc"));
		eps.add(new Episode(season, 2, "eps2.0_unm4ask-pt2.tc"));
		eps.add(new Episode(season, 3, "eps2.1_k3rnel-pan1c.ksd"));
		eps.add(new Episode(season, 4, "eps2.2_init1.asec"));
		eps.add(new Episode(season, 5, "eps2.3logic-b0mb.hc"));
		eps.add(new Episode(season, 6, "eps2.4m4ster-s1ave.aes"));
		eps.add(new Episode(season, 7, "eps2.5h4ndshake.sme"));
		eps.add(new Episode(season, 8, "eps2.6succ3ss0r.p12"));
		eps.add(new Episode(season, 9, "eps2.7init5.fve"));
		eps.add(new Episode(season, 10, "eps2.8h1dden?pr0cess.axx"));
		eps.add(new Episode(season, 11, "eps2.9pyth0n?pt1.p7z"));
		eps.add(new Episode(season, 12, "eeps2.9pyth0n?pt2.p7z"));
		return eps;
	}

	private SortedSet<Episode> createEpsodesSeason3MrRobot(Season season) {
		SortedSet<Episode> eps = new TreeSet<>();
		eps.add(new Episode(season, 1, "eps3.0_power-saver-mode.h"));
		eps.add(new Episode(season, 2, "eps3.1_undo.gz"));
		eps.add(new Episode(season, 3, "eps3.2_legacy.so"));
		eps.add(new Episode(season, 4, "eps3.3_metadata.par2"));
		eps.add(new Episode(season, 5, "eps3.4_runtime-error.r00"));
		eps.add(new Episode(season, 6, "eps3.5_kill-process.inc"));
		eps.add(new Episode(season, 7, "eps3.6_fredrick+tanya.chk"));
		eps.add(new Episode(season, 8, "eps3.7_dont-delete-me.ko"));
		eps.add(new Episode(season, 9, "eps3.8_stage3.torrent"));
		eps.add(new Episode(season, 10, "shutdown -r"));
		return eps;
	}

}