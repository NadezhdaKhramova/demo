package demo.repository;

import demo.models.entity.Outfits;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OutfitsRepository extends JpaRepository<Outfits,Long> {

    List<Outfits> getAllByName(String name);

    @Query("select out from outfits out join fetch  out.teachers")
    List<Outfits> getAll();

 //   @Query("select  ")

}
