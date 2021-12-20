package demo.repository;

import demo.entity.Outfits;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OutfitsRepository extends JpaRepository<Outfits,Long> {
    List<Outfits> getAllByFacultyNotNullAndNameNotNull();

    @Query(nativeQuery = true, value = "g   ")
    List<Outfits> getNameAndFaculty();
}
