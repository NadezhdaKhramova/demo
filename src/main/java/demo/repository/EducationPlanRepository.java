package demo.repository;

import demo.models.entity.EducationPlan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EducationPlanRepository extends JpaRepository<EducationPlan,Long> {

    EducationPlan getById (Long id);

    /*@Query("select out.name, sub.name from  educationPlan  ep join fetch ep.outfits  out " +
            "join fetch ep.subjects sub" )
    List<EducationPlan> outfitsSubjects();*/

}
