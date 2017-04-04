package nett.formacion.aaa.module4.soap.songs.pojos.controller;

import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebService;

import org.springframework.stereotype.Controller;

import nett.formacion.aaa.module4.soap.songs.pojos.Song;

@Controller
@WebService
public interface SongController {
	
	@WebMethod
	public Song addSong(Song song);
	
	@WebMethod
	public Song updateSong(Song song);
	
	@WebMethod
	public Song deleteSong (Song song);
	
	@WebMethod
	public List <Song> getSongsByTitle(String title);
	
	@WebMethod
	public List <Song> getSongsByAuthorName(String authorName);
	
	@WebMethod
	public List <Song> getAllSongs();
}
