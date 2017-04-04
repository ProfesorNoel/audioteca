package nett.formacion.aaa.module4.soap.songs.pojos;

import java.util.Date;
import java.util.List;

public class Song {

	private Date airedDate;
	private String title;
	private String album;
	private String time;
	
	private List <Author> authors;
	
	public Song() {
		super();
	}

	public Date getAiredDate() {
		return airedDate;
	}

	public void setAiredDate(Date airedDate) {
		this.airedDate = airedDate;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAlbum() {
		return album;
	}

	public void setAlbum(String album) {
		this.album = album;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public List<Author> getAuthors() {
		return authors;
	}

	public void setAuthors(List<Author> authors) {
		this.authors = authors;
	}
	
	public String toString()
	{
		StringBuilder sb = new StringBuilder ( "Song -> title: " + this.getTitle() + " - time: " + this.getTime() + " - aired date: " + this.getAiredDate() + " album: " + this.getAlbum());
	
		if (this.getAuthors() != null && !this.getAuthors().isEmpty())
		{
			for (Author author : this.getAuthors())
			{
				sb.append("\n");
				sb.append(author.toString());
			}
		}
		
		return sb.toString();
	}
}
