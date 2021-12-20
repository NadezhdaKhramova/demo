package demo.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name ="Outfits")
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

    @JsonIgnore
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "outfits",cascade = CascadeType.ALL)
    private Set <EducationPlan> educationplan;

    @JsonIgnore
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "outfits", cascade = CascadeType. ALL)
    private Set<Students> students;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "curatorid", nullable = false)
    private Teachers teachers;
}