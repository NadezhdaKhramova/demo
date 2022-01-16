package demo.repository;

import demo.models.entity.Teachers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TeachersRepository extends JpaRepository<Teachers,Long> {

    Teachers findByFio(String fio);

    @Query(nativeQuery = true, value = "select * from teachers")
    List<Teachers> getAll();

    @Query("select t from teachers  t join fetch t.outfits " +
            "join t.outfits ou where ou.name = :outfits_name")
    Optional<Teachers> findTeachersByOutfits(@Param("outfits_name") final String outfitsName);

    @Modifying
    @Query("update  teachers t set t.fio = :fio , t.subjects.name = :name where t.id = :id")
    void edit(@Param("fio") String fio, @Param("name") String name, @Param("id") Long id);
}
