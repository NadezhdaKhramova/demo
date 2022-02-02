package demo.models.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity (name ="outfits")
@AllArgsConstructor
@NoArgsConstructor
@Table(name ="Outfits", schema ="db_test")
@Getter
@Setter
@EqualsAndHashCode(exclude = {"students","teachers", "subjects"})
@ToString(exclude = {"students","teachers", "subjects"})
public class Outfits {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonProperty("номер")
    @Column(name="name",nullable = false)
    private String name;

    @JsonProperty("факультет")
    @Column(name="faculty",nullable = false)
    private String faculty;

    /*@JsonIgnore
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "outfits",cascade = CascadeType.ALL)
    private Set <EducationPlan> educationplan;*/

    @JsonIgnore
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "outfits", cascade = CascadeType.ALL)
    private List<Students> students;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "curatorid", nullable = false)
    private Teachers teachers;

   @JsonIgnore
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "outfifs_subjects",
            joinColumns = @JoinColumn(name = "outfit_id"),
            inverseJoinColumns = @JoinColumn(name = "subject_id")
    )
    private List<Subjects> subjects;
}