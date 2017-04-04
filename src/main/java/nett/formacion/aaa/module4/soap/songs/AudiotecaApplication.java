package nett.formacion.aaa.module4.soap.songs;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * H2 Console: http://localhost:8080/h2-console/
 * 
 * WSDL: http://localhost:8080/services/audioteca?wsdl
 * @author mamoghli
 *
 */

@SpringBootApplication
@EnableJpaRepositories
public class AudiotecaApplication {

	public static void main(String[] args) {
		SpringApplication.run(AudiotecaApplication.class, args);
	}
}
