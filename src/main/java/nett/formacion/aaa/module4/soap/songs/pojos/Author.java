package nett.formacion.aaa.module4.soap.songs.pojos;

import java.util.Date;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "author")
@XmlAccessorType(XmlAccessType.NONE)
@XmlType (propOrder={"name","type","firstPerformance","isActive"})
public class Author {

	@XmlElement (name ="type", required = true)
	private AuthorType type;
	@XmlElement (name ="name", required = true)
	private String name;
	@XmlElement (name ="firstPerformance", required = false)
	private Date firstPerformance;
	@XmlElement (name ="isActive", required = false)
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
