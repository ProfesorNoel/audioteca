package nett.formacion.aaa.module4.soap.songs.ws;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.h2.server.web.WebServlet;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

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
