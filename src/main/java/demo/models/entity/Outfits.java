package demo.models.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Entity (name ="outfits")
@AllArgsConstructor
@NoArgsConstructor
@Table(name ="Outfits", schema ="db_test")
@Getter
@Setter
public class Outfits {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonProperty(value = "номер")
    @Column(name="name",nullable = false)
    private String name;

    @JsonProperty(value = "факультет")
    @Column(name="faculty",nullable = false)
    private String faculty;

    /*@JsonIgnore
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "outfits",cascade = CascadeType.ALL)
    private Set <EducationPlan> educationplan;*/

    @JsonIgnore
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "outfits", cascade = CascadeType. ALL)
    private Set<Students> students;

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
    private Set<Subjects> subjects;
}