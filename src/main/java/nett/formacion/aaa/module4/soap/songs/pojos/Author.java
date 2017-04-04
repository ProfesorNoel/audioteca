package nett.formacion.aaa.module4.soap.songs.pojos;

import java.util.Date;

public class Author {

	private AuthorType type;
	private String name;
	private Date firstPerformance;
	private Boolean isActive = false;
	
	public Author() {
		super();
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
	}

	public Date getFirstPerformance() {
		return firstPerformance;
	}

	public void setFirstPerformance(Date firstPerformance) {
		this.firstPerformance = firstPerformance;
	}

	public Boolean getIsActive() {
		return isActive;
	}

	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}
	
	public String toString()
	{
		return "Author -> name: " + this.getName() + " - type: " + this.getType().toString() + " - active: " + this.isActive + " - first performance: " + this.getFirstPerformance().toString();  
	}
	
}
