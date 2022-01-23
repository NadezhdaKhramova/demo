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

    Teachers getById (Long id);

    @Query(nativeQuery = true, value = "select * from teachers")
    List<Teachers> getAll();

    @Query("select t from teachers  t inner join fetch t.outfits " +
            "where t.fio =: fio")
          //  "join t.outfits ou where ou.name = :outfits_name")
    List<Teachers> findTeachersInOutfits(@Param("fio") final String fio);

    @Modifying
    @Query("update  teachers t set t.fio = :fio , t.subjects.name = :name where t.id = :id")
    void edit(@Param("fio") String fio, @Param("name") String name, @Param("id") Long id);

    @Query(nativeQuery = true, value = "select teachers.fio, outfits.name from teachers inner join outfits "+
            " where teachers.id = outfits.curatorid and teachers.name =?1")
        //  "join t.outfits ou where ou.name = :outfits_name")
    List<Teachers> findTeachersInOutfitsDop(@Param("fio") final String fio);
}
