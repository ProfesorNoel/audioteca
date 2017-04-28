package nett.formacion.aaa.module4.soap.songs.pojos;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "song")
@XmlAccessorType(XmlAccessType.NONE)
@XmlType (propOrder={"title","album","time","airedDate","authors"})
public class Song {

	@XmlElement (name ="airedDate", required = false)
	private Date airedDate;
	@XmlElement (name ="title", required = true)
	private String title;
	@XmlElement (name ="album", required = false)
	private String album;
	@XmlElement (name ="time", required = true)
	private String time;
	
	@XmlElementWrapper(name="authors", required = false)
	@XmlElement (name ="author")
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
	
	public void addAuthor(Author author)
	{
		if (this.authors == null)
		{
			this.authors = new ArrayList <Author> ();
			
			this.authors.add(author);
		}
	}
	
}
