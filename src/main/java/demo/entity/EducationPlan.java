package demo.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name ="Educationplan")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EducationPlan {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne (fetch = FetchType.LAZY)
    @JoinColumn (name ="outfitid")
    private Outfits outfits;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn (name ="subjectid")
    private Subjects subjects;
}
