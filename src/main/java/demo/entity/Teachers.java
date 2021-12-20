package demo.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import org.hibernate.annotations.BatchSize;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.util.Set;

import static javax.persistence.CascadeType.*;

@Entity
@Table(name ="Teachers")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Teachers {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id",nullable = false)
    private Long id;

    @JsonProperty(value = "ФИО преподавалеля")
    @Column(name="fio",nullable = false)
    private String fio;

    @JsonIgnore
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "teachers",cascade = ALL)
    private Set<Outfits> outfits;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn (name ="subjectid")
    private Subjects subjects;
}