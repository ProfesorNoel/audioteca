package nett.formacion.aaa.module4.soap.songs.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import nett.formacion.aaa.module4.soap.songs.entities.SongEntity;

@Transactional
public interface IAudiotecaRepository extends JpaRepository <SongEntity, Long>{
	
	@Query("SELECT s FROM SongEntity s WHERE s.title LIKE CONCAT('%', :title, '%')")
	List<SongEntity> findByTitle(@Param("title") String title);    
	
	@Query("SELECT s FROM SongEntity s JOIN s.authors a WHERE a.name LIKE CONCAT('%', :authorName, '%')")
	List<SongEntity> findByAuthor(@Param("authorName") String authorName);
	
	@Query("SELECT s FROM SongEntity s WHERE YEAR(s.airedDate) = :year")
	List<SongEntity> findByYear(@Param("year") Integer year);
}
