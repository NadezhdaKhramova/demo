package demo.entity;
import lombok.*;

import javax.persistence.*;
import java.util.Set;

import static javax.persistence.CascadeType.ALL;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table ( name = "Subjects")
public class Subjects {

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Integer id;

   @Column(nullable = false)
   private Integer code;

   @Column(nullable = false)
   private String name;

   @OneToMany(fetch = FetchType.LAZY, mappedBy = "subjects", cascade = ALL)
   private Set<Teachers> teachers;

   @OneToMany(fetch = FetchType.LAZY, mappedBy = "subjects", cascade= ALL)
   private Set<EducationPlan> educationPlan;
}