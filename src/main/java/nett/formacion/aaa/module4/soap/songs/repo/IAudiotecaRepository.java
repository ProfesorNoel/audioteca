package nett.formacion.aaa.module4.soap.songs.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import nett.formacion.aaa.module4.soap.songs.entities.SongEntity;
import nett.formacion.aaa.module4.soap.songs.pojos.Song;

@Transactional
public interface IAudiotecaRepository extends JpaRepository <SongEntity, Long>{
	
	List<Song> findByTitle(String title);    
	//List<Song> findByAuthors(String author);
}
