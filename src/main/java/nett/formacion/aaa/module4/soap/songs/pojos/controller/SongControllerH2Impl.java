package nett.formacion.aaa.module4.soap.songs.pojos.controller;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import nett.formacion.aaa.module4.soap.songs.entities.AuthorEntity;
import nett.formacion.aaa.module4.soap.songs.entities.SongEntity;
import nett.formacion.aaa.module4.soap.songs.exceptions.SongException;
import nett.formacion.aaa.module4.soap.songs.pojos.Author;
import nett.formacion.aaa.module4.soap.songs.pojos.Song;
import nett.formacion.aaa.module4.soap.songs.repo.IArtistRepository;
import nett.formacion.aaa.module4.soap.songs.repo.IAudiotecaRepository;

public class SongControllerH2Impl implements SongController{

	@Autowired
	private IAudiotecaRepository repo;
	
	@Autowired
	private IArtistRepository repoArtist;
	
	@PersistenceContext
    private EntityManager em;
	
	private static final Logger LOGGER = LogManager.getLogger(SongControllerH2Impl.class.getName());
	
	public SongControllerH2Impl() 
	{
		super();
	}
	
	@Override
	public Song addSong(Song song) {
		
		LOGGER.info("Executing addSong method on " + SongControllerH2Impl.class.getSimpleName());
		return repo.save(new SongEntity(song)).getSong();
	}

	@Override
	public Song updateSong(Song song) {
		
		LOGGER.info("Updating song with title: " + song.getTitle());
		
		List <SongEntity> entities = repo.findByTitle(song.getTitle());
		
		if (entities != null && !entities.isEmpty())
		{
			SongEntity songRecovered = entities.get(0);
			
			songRecovered.setAiredDate(song.getAiredDate());
			songRecovered.setAlbum(song.getAlbum());
			
			songRecovered.setTime(song.getTime());
			songRecovered.setTitle(song.getTitle());
			
			List <Author> authors = song.getAuthors();
			
			if (authors != null && !authors.isEmpty())
			{
				for (Author a : authors)
				{
					songRecovered.getAuthors().add(new AuthorEntity(a));
				}
			}
				
			this.repo.save(songRecovered);
		}
		
		return song;
	}

	@Override
	public Song deleteSong(Song song) {
		
		LOGGER.info("Deleting the song with title :" + song.getTitle());
		
		repo.delete(new SongEntity(song));
		 
		return song;
	}

	@Override
	public List<Song> getSongsByTitle(String title) {
		LOGGER.info("Recovering songs with title: " + title);
		List <SongEntity> entityList = this.repo.findByTitle(title);
		
		List <Song> listSong = new ArrayList <Song> ();
		
		if (entityList != null && !entityList.isEmpty())
		{
			LOGGER.info("Adding recovered songs");
			
			for (SongEntity se : entityList)
			{
				Song s = se.getSong();
				
				listSong.add(s);
				
				LOGGER.info("Added Song: " + s.getTitle());
			}
		}
		else
		{
			LOGGER.info("None song contains title: " + title);
		}
		
		return listSong;
	}

	@Override
	public List<Song> getSongsByAuthorName(String authorName) {
		LOGGER.info("Recovering songs from author: " + authorName);
		List <SongEntity> entityList = this.repo.findByAuthor(authorName);
		
		List <Song> listSong = new ArrayList <Song> ();
		
		if (entityList != null && !entityList.isEmpty())
		{
			LOGGER.info("Adding recovered songs");
			
			for (SongEntity se : entityList)
			{
				Song s = se.getSong();
				
				listSong.add(s);
				
				LOGGER.info("Added Song: " + s.getTitle());
			}
		}
		else
		{
			LOGGER.info("None song from author: " + authorName);
		}
		
		return listSong;
	}

	@Override
	public List<Song> getAllSongs() {
		
		LOGGER.info("Recovering All Songs...");
		
		List <SongEntity> entitySongList = this.repo.findAll();
		
		List <Song> songList = new ArrayList <Song> ();	
		
		if (entitySongList != null && !entitySongList.isEmpty())
		{
			for (SongEntity se: entitySongList)
			{
				songList.add(se.getSong());
			}
		}
		else
		{
			LOGGER.info("None data in the database");
		}
		
		return songList;
	}

	@Override
	public Song deleteSongById(Long songId) throws SongException{
		
		SongEntity se = this.repo.findOne(songId);
		
		if (se == null)
		{
			throw new SongException("DSBI" ,"There is no Song with songId: " + songId);
		}
		
		Song song = se.getSong();
		
		this.repo.delete(se);
		
		return song;
	}

	@Override
	public List<Song> getSongsByYear(Integer year) 
	{
		LOGGER.info("Recovering Songs By Year...");
		
		List <SongEntity> entitySongList = this.repo.findByYear(year);
		
		List <Song> songList = new ArrayList <Song> ();	
		
		if (entitySongList != null && !entitySongList.isEmpty())
		{
			for (SongEntity se: entitySongList)
			{
				Song s = se.getSong();
				songList.add(s);
				
				LOGGER.info("Song: " + s.toString());
			}
		}
		else
		{
			LOGGER.info("None Song for year: " + year);
		}
		
		return songList;
	}

	@Override
	public List<Author> getPopularArtist() 
	{
		LOGGER.info("Recovering popular Artist");
		
		List <AuthorEntity> entityAuthorList = this.repoArtist.findPopularArtist();
		
		List <Author> artisList = new ArrayList <Author> ();	
		
		if (entityAuthorList != null && !entityAuthorList.isEmpty())
		{
			int i = 0;
			
			for (AuthorEntity ae: entityAuthorList)
			{
				Author a = ae.getAuthor();
				
				if (i == 0)
				{
					artisList.add(a);
				}
				else
				{
					//Se consideran Autores repetidos aquellos cuyo nombre coincide
					//No se agregan a la lista
					
					Author artistBefore = artisList.get(i - 1);
					
					if(!artistBefore.getName().equalsIgnoreCase(a.getName()))
					{
						artisList.add(a);
					}
				}
				
				i++;
				
				LOGGER.info("Author: " + a.toString());
			}
		}
		else
		{
			LOGGER.info("There is none Popular Artist");
		}
	
		return artisList;
	}
}

