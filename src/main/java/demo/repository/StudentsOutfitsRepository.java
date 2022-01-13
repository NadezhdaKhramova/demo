package demo.repository;

import demo.models.entity.Outfits;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentsOutfitsRepository extends JpaRepository<Outfits,Long> {
        Outfits getByName(Long name);
}

