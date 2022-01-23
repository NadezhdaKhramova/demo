package demo.models.entity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

import static javax.persistence.CascadeType.ALL;

@Entity(name = "subjects")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table ( name = "subjects", schema ="db_test")
public class Subjects {

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;

   @Column(nullable = false)
   private Integer code;

   @Column(nullable = false)
   private String name;

   @JsonIgnore
   @OneToMany(fetch = FetchType.LAZY, mappedBy = "subjects", cascade = ALL)
   private Set<Teachers> teachers;

   @JsonIgnore
   @ManyToMany(mappedBy = "subjects")
   private List<Outfits> outfits;

 /*  @OneToMany(fetch = FetchType.LAZY, mappedBy = "subjects", cascade= ALL)
   private Set<EducationPlan> educationPlan;*/
}