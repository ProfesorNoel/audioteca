package nett.formacion.aaa.module4.soap.songs.pojos.controller;

import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebService;

import org.springframework.stereotype.Controller;

import nett.formacion.aaa.module4.soap.songs.exceptions.SongException;
import nett.formacion.aaa.module4.soap.songs.pojos.Author;
import nett.formacion.aaa.module4.soap.songs.pojos.Song;

@Controller
@WebService
public interface SongController {
	
	@WebMethod (operationName="addSong")
	public Song addSong(Song song);
	
	@WebMethod (operationName="updateSong")
	public Song updateSong(Song song);
	
	@WebMethod (operationName="deleteSong")
	public Song deleteSong (Song song);
	
	@WebMethod (operationName="deleteSongById")
	public Song deleteSongById (Long songId) throws SongException;
	
	@WebMethod (operationName="getSongsByTitle")
	public List <Song> getSongsByTitle(String title);
	
	@WebMethod (operationName="getSongsByAuthorName")
	public List <Song> getSongsByAuthorName(String authorName);
	
	@WebMethod (operationName="getAllSongs")
	public List <Song> getAllSongs();
	
	@WebMethod (operationName="getSongsByYear")
	public List <Song> getSongsByYear(Integer year);
	
	@WebMethod (operationName="getPopularArtist")
	public List <Author> getPopularArtist();
}
