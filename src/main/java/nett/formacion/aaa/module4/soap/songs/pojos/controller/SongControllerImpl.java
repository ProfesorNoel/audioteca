package nett.formacion.aaa.module4.soap.songs.pojos.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.UUID;

import nett.formacion.aaa.module4.soap.songs.pojos.Author;
import nett.formacion.aaa.module4.soap.songs.pojos.Song;

public class SongControllerImpl implements SongController{

	public SongControllerImpl() {
		super();
	}
	
	@Override
	public Song addSong(Song song) {
		return this.mockResponseObject();
	}

	@Override
	public Song updateSong(Song song) {
		return this.mockResponseObject();
	}

	@Override
	public Song deleteSong(Song song) {
		return this.mockResponseObject();
	}

	@Override
	public List<Song> getSongsByTitle(String title) {
		return this.mockResponseList();
	}

	@Override
	public List<Song> getSongsByAuthorName(String authorName) {
		return this.mockResponseList();
	}
	
	private List <Song> mockResponseList()
	{
		List <Song> songs = new ArrayList <Song> ();
		
		Random r = new Random(UUID.randomUUID().getMostSignificantBits());
		
		int numberOfSongs = r.nextInt(5) + 1;
		
		for (int i = 0; i < numberOfSongs; i++)
		{
			songs.add(this.mockResponseObject());
		}
		
		return songs;
	}
	
	private Song mockResponseObject()
	{
		Song song = null;
		
		Random r = new Random(UUID.randomUUID().getMostSignificantBits());
		
		song = new Song();
		
		song.setAiredDate(new Date());
		song.setAlbum("The Unlimited ride");
		song.setTime((r.nextInt(40) + 35) + ":" + r.nextInt(60));
		song.setTitle("The Sound of  " + Character.toString((char)(r.nextInt(33) + 65)));
		
		List <Author> authors = new ArrayList <Author> (); 
		
		authors.add(this.randomArtist());
		
		song.setAuthors(authors);
		
		return song;
	}
	
	private Author randomArtist()
	{
		String [] artists = {"ACDC","GAGA","BRUNO MARS","FRANCO BATIATTO","DEPECHE MODE","MICHAEL JACKSON"};
	
		Random r = new Random(UUID.randomUUID().getMostSignificantBits());
		
		Author author = new Author();
		
		author.setName(artists[r.nextInt(artists.length)]);
		
		return author;
	}

	@Override
	public List<Song> getAllSongs() {
		
		return this.mockResponseList();
	}

	@Override
	public Song deleteSongById(Long songId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Song> getSongsByYear(Integer year) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Author> getPopularArtist() {
		// TODO Auto-generated method stub
		return null;
	}
}