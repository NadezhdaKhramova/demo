package demo.repository;

import demo.entity.Teachers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TeachersRepository extends JpaRepository<Teachers,Long> {
    Teachers findByFio(String fio);

    @Query(nativeQuery = true, value = "select * from teachers")
    List<Teachers> getAll();
}
