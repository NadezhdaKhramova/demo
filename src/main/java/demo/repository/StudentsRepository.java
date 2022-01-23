package demo.repository;

import demo.models.entity.Students;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Repository
public interface StudentsRepository extends JpaRepository<Students, Long> {

    Students findByFio(String fio);

    Students getById(Long id);

    Students findByDateOfAdmission(Date date);

    @Query(nativeQuery = true, value = "Select * from Students ")
    List<Students> getTest();

    @Query("select stu from students  stu join fetch stu.outfits where stu.fio = :student_fio")
    Students getStudentsByFio(@Param("student_fio") final String fio);

 /*   @Query(nativeQuery = true, value = "select outfits.name, students.fio, students.dateofadmission from students inner join outfits on students.outfitid = outfits.id where outfits.name = :name; ")
    List<Students>  fetchStudentsFioDateOfAdmission(@Param("name")String name);

    @Query("select new demo.models.entity.Students (stu.fio, stu.dateOfAdmission, out.name) " +
            "from students stu " +
            "join stu.outfits out " +
            "where out.name = :outfit_name ")
    Collection<Object> findStudentsByOutfitName(@Param("outfit_name") long outfitName);*/

    Optional<Students> findById(final long studentId);

    @Query("select stu from students  stu inner join  fetch stu.outfits " +
            "join stu.outfits ou where ou.name = :outfit_name")
    List<Students> findStudentsByOutfitsName(@Param("outfit_name") final String outfitName);

   /* @Modifying
    @Query(value = "insert into Students stu"+ //join fetch stu.outfits out " +
            "(fio, dateOfAdmission, passport, (select out.id from outfits out where  out.name = :outfit_name)) " +
            "select :fio, :dateOfAdmission, :passport, :numberOutfit  from students")
    void insertStudentInOutfit(@Param("fio") String fio, @Param("dateOfAdmission") Date dateOfAdmission,
                               @Param("passport") String passport, @Param("outfit_name") String outfit_name);*/

    @Modifying
    @Query("update students stu set " +
            "stu.fio = :fio ,stu.dateOfAdmission = :dateOfAdmission," +
            "stu.passport = :passport, stu.outfits.name =:name  where stu.id = :id")
    void edit(@Param("fio") String fio, @Param("dateOfAdmission") Date dateOfAdmission,
                     @Param("passport") String passport, @Param("name") String name, @Param("id") Long id);

    @Modifying
    @Query(nativeQuery = true, value = "insert into students (fio, dateOfAdmission, passport, outfitid)"+
            " values ( ?1, ?2, ?3, (select id from outfits where outfits.name =?4) " )
    void insertStudentInOutfitDop(String fio,  Date dateOfAdmission, String passport, String outfit_name);

}
