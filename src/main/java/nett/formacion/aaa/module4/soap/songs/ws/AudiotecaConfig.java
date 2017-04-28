package nett.formacion.aaa.module4.soap.songs.ws;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.h2.server.web.WebServlet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;

import nett.formacion.aaa.module4.soap.songs.pojos.controller.SongController;
import nett.formacion.aaa.module4.soap.songs.pojos.controller.SongControllerH2Impl;

@Configuration
public class AudiotecaConfig {

	private static final Logger LOGGER = LogManager.getLogger(AudiotecaConfig.class.getName());
	
	public AudiotecaConfig() {
		super();
	}
	
	@Bean
	public SongController getSongController()
	{
		LOGGER.info("Buiding a SongControllerH2Impl instance from " + this.getClass().getSimpleName());
		
		//return new SongControllerImpl();
		
		return new SongControllerH2Impl();
	}
	
	@Bean
	public ServletRegistrationBean h2servletRegistration() {
	    ServletRegistrationBean registration = new ServletRegistrationBean(new WebServlet());
	    registration.addUrlMappings("/h2-console/*");
	    return registration;
	}
}
