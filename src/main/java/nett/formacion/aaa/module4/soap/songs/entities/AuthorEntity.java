package nett.formacion.aaa.module4.soap.songs.entities;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import nett.formacion.aaa.module4.soap.songs.pojos.Author;
import nett.formacion.aaa.module4.soap.songs.pojos.AuthorType;

@Entity
@Table(name = "authors")
public class AuthorEntity {

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private Long authorId;

	@Transient
	private Author author;
	
	@Enumerated
	private AuthorType type;
	private String name;
	private Date firstPerformance;
	private Boolean isActive = false;
	
	/*@ManyToOne
	@JoinColumn(name = "songId", nullable=true)*/
	
	
	@ManyToOne(optional=false)
	@JoinColumn(name="songId", referencedColumnName="songId")
	private SongEntity songEntity;
	
	public AuthorEntity() {
		super();
	}

	private void buildAuthor()
	{
		if (this.author == null)
		{
			Author a = new Author ();
			
			a.setFirstPerformance(this.firstPerformance);
			a.setIsActive(this.isActive);
			a.setName(this.name);
			a.setType(this.getType());
			
			this.author = a;
		}
	}
	
	
	public AuthorEntity(Author author) {
		super();
		this.firstPerformance = author.getFirstPerformance();
		this.isActive = author.getIsActive();
		this.name = author.getName();
		this.type = author.getType();
		
		this.author = author;
			
	}

	public Long getAuthorId() {
		return authorId;
	}

	public void setAuthorId(Long authorId) {
		this.authorId = authorId;
	}

	public Author getAuthor() 
	{
		this.buildAuthor();
		return author;
	}

	public void setAuthor(Author author) {
		this.author = author;
	}

	public AuthorType getType() {
		return type;
	}

	public void setType(AuthorType type) {
		this.type = type;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
		this.author.setName(name);
	}

	public Date getFirstPerformance() {
		return firstPerformance;
	}

	public void setFirstPerformance(Date firstPerformance) {
		this.firstPerformance = firstPerformance;
		this.author.setFirstPerformance(firstPerformance);
	}

	public Boolean getIsActive() {
		return isActive;
	}

	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
		this.author.setIsActive(isActive);
	}

	public SongEntity getSongEntity() {
		return songEntity;
	}

	public void setSongEntity(SongEntity songEntity) {
		this.songEntity = songEntity;
	}
}
