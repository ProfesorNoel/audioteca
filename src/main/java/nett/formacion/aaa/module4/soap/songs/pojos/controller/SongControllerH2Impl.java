package nett.formacion.aaa.module4.soap.songs.pojos.controller;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import nett.formacion.aaa.module4.soap.songs.entities.SongEntity;
import nett.formacion.aaa.module4.soap.songs.pojos.Song;
import nett.formacion.aaa.module4.soap.songs.repo.IAudiotecaRepository;

public class SongControllerH2Impl implements SongController{

	@Autowired
	private IAudiotecaRepository repo;
	
	private static final Logger LOGGER = LogManager.getLogger(SongControllerH2Impl.class.getName());
	
	
	public SongControllerH2Impl() {
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
		
		List <Song> songs = repo.findByTitle(song.getTitle());
		
		if (songs != null && !songs.isEmpty())
		{
			Song songRecovered = songs.get(0);
			
			songRecovered.setAiredDate(song.getAiredDate());
			songRecovered.setAlbum(song.getAlbum());
			songRecovered.setAuthors(song.getAuthors());
			songRecovered.setTime(song.getTime());
			songRecovered.setTitle(song.getTitle());
						
			this.repo.save(new SongEntity(songRecovered));
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
		return this.repo.findByTitle(title);
	}

	@Override
	public List<Song> getSongsByAuthorName(String authorName) {
		//this.repo.fi
		
		return null;
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
		
		return songList;
	}
}

