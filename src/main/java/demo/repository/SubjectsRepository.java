package demo.repository;

import demo.models.entity.Subjects;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SubjectsRepository  extends JpaRepository<Subjects, Long> {

    @Query(nativeQuery = true, value = "SELECT * from subjects")
    List<Subjects>  getAll ();

    @Query("select sbj from subjects sbj inner join fetch  sbj.outfits out where out.name =:name")
    List<Subjects> subjectsInOutfit(@Param("name") String name) ;
}
