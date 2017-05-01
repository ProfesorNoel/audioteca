package nett.formacion.aaa.module4.soap.songs.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.data.jpa.repository.Query;
import nett.formacion.aaa.module4.soap.songs.entities.AuthorEntity;

@Transactional
public interface IArtistRepository extends JpaRepository <AuthorEntity, Long>{
	
	@Query(value = "SELECT * FROM Authors WHERE name IN (SELECT name FROM Authors GROUP BY name HAVING COUNT (name) > 1)" , nativeQuery=true)
	List <AuthorEntity> findPopularArtist ();
}
