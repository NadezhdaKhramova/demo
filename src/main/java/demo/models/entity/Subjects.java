package demo.models.entity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
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
@EqualsAndHashCode(exclude = {"outfits", "teachers"})
@ToString(exclude = {"outfits", "teachers"})
@Table ( name = "subjects", schema ="db_test")
public class Subjects {

   @JsonProperty("порядковый номер")
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;

   @JsonProperty("код предмета")
   @Column(nullable = false)
   private Integer code;

   @JsonProperty("название предмета")
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