package demo.repository;

import demo.entity.Students;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentsRepository extends JpaRepository<Students,Long> {
    Students findByFio(String fio);

    //List<Students> getStudentsBy

    @Query(nativeQuery = true, value = "Select * from Students ")
    List<Students> getTest();

    @Query(nativeQuery = true, value = "select outfits.name, students.fio, students.dateofadmission from students inner join outfits on students.outfitid = outfits.id where outfits.name = :name; ")
    List<Students>  fetchStudentsFioDateOfAdmissionAndOutfitsName(@Param("name")String name);

   /* @Query
    List<Students> getFioDateOfAdmissionAndOutfitsName() ;*/

 }
