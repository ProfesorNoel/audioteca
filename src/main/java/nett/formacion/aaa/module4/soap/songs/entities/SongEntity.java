package nett.formacion.aaa.module4.soap.songs.entities;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import nett.formacion.aaa.module4.soap.songs.pojos.Author;
import nett.formacion.aaa.module4.soap.songs.pojos.Song;

@Entity
@Table(name = "songs")
public class SongEntity {

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private Long songId;
	
	private Date airedDate;
	private String title;
	private String album;
	private String time;
	
	/*@OneToMany(targetEntity=AuthorEntity.class, cascade = CascadeType.ALL, fetch=FetchType.EAGER)
	@JoinColumn(name="songId")*/
	
	//@OneToMany(mappedBy="songs", cascade = CascadeType.ALL, fetch=FetchType.EAGER )
	
	@OneToMany(mappedBy = "songEntity", targetEntity=AuthorEntity.class, fetch=FetchType.EAGER, cascade=CascadeType.ALL)
	private List <AuthorEntity> authors = new ArrayList <AuthorEntity> ();
	
	//@ManyToOne
	@Transient
	private Song song;
	
	public SongEntity() {
		super();
	}
	
	private void buildSong()
	{
		if (this.song == null)
		{
			Song s = new Song();
			
			s.setTitle(this.title);
			s.setTime(this.time);
			s.setAlbum(this.album);
			s.setAiredDate(this.airedDate);
			
			List <AuthorEntity> authorsList = this.authors;
			
			if (authorsList != null && !authorsList.isEmpty())
			{
				for (AuthorEntity ae : authorsList)
				{
					Author a = new Author();
					a.setName(ae.getName());
					a.setIsActive(ae.getIsActive());
					a.setFirstPerformance(ae.getFirstPerformance());
					a.setType(ae.getType());
					
					s.addAuthor(a);
				}
			}
			
			this.song = s;
		}
	}
	
	public SongEntity(Song song) {
		this.song = song;
		this.airedDate = song.getAiredDate();
		this.album = song.getAlbum();
		this.time = song.getTime();
		this.title = song.getTitle();
		
		if (song.getAuthors() != null && !song.getAuthors().isEmpty())
		{
			for (Author a : song.getAuthors())
			{
				AuthorEntity ae = new AuthorEntity (a);
				ae.setSongEntity(this);
				
				this.authors.add(ae);
			}
		}
		
		this.song = song;
	}

	public Long getSongId() {
		return songId;
	}

	public void setSongId(Long songId) {
		this.songId = songId;
	}

	public Song getSong() {
		
		this.buildSong();
		
		return song;
	}

	public void setSong(Song song) {
		this.song = song;
	}

	public Date getAiredDate() {
		return this.getAiredDate();
	}

	public String getTitle() {
		return this.getTitle();
	}

	public String getAlbum() {
		return this.getAlbum();
	}

	public String getTime() {
		return this.getTime();
	}

	public List<AuthorEntity> getAuthors() {
		return authors;
	}

	public void setAuthors(List<AuthorEntity> authors) {

		this.authors = authors;
	}

	public void setAiredDate(Date airedDate) {
		this.airedDate = airedDate;
		
		if(song != null)	
			this.song.setAiredDate(airedDate);
	}

	public void setTitle(String title) {
		this.title = title;
		
		if(song != null)	
			this.song.setTitle(title);
	}

	public void setAlbum(String album) {
		this.album = album;
	
		if(song != null)	
			this.song.setAlbum(album);
	}

	public void setTime(String time) {
		this.time = time;
		
		if(song != null)	
			this.song.setTime(time);
	}
}
