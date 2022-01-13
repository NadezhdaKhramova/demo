package demo.repository;

import demo.models.entity.Students;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Repository
public interface StudentsRepository extends JpaRepository<Students,Long> {

    Students findByFio( String fio);

    @Query(nativeQuery = true, value = "Select * from Students ")
    List<Students> getTest();

    @Query("select stu from students  stu join fetch stu.outfits where stu.fio = :student_fio")
    Optional<Students> getAll(@Param("student_fio") final String fio);

 /*   @Query(nativeQuery = true, value = "select outfits.name, students.fio, students.dateofadmission from students inner join outfits on students.outfitid = outfits.id where outfits.name = :name; ")
    List<Students>  fetchStudentsFioDateOfAdmission(@Param("name")String name);

    @Query("select new demo.models.entity.Students (stu.fio, stu.dateOfAdmission, out.name) " +
            "from students stu " +
            "join stu.outfits out " +
            "where out.name = :outfit_name ")
    Collection<Object> findStudentsByOutfitName(@Param("outfit_name") long outfitName);*/

    Optional<Students> findById(final long studentId);

    @Query("select stu from students  stu join fetch stu.outfits " +
            "join stu.outfits ou where ou.name = :outfit_name")
    Optional<Students> findStudentsByOutfitsName(@Param("outfit_name") final String outfitName);

    @Modifying
    @Query(nativeQuery = true, value = "insert into stu Students join fetch stu.outfits " +
            "(fio, dateOfAdmission, passport, (select out.id from Outfits out where  out.name = :outfit_name)) " +
            "select :fio, :dateOfAdmission, :passport, :numberOutfit  from Students")
    void insertStudentInOutfit(@Param("fio") String fio, @Param("dateOfAdmission") Date dateOfAdmission,
                               @Param("passport") String passport, @Param("outfit_name") String outfit_name);
}


