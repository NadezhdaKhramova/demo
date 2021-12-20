package demo.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import org.hibernate.annotations.BatchSize;

import javax.persistence.*;
import java.util.Date;

import static javax.persistence.FetchType.LAZY;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Students")
@Entity
@EqualsAndHashCode(exclude = "outfits")
@ToString(exclude = "outfits")
public class Students {

    @JsonProperty(value = "Номер")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonProperty(value = "ФИО")
    @Column(name="fio")
    private String  fio;

    @JsonProperty(value = "Дата зачисления")
    @Column(name="dateOfAdmission")
    private Date dateOfAdmission;

    @JsonProperty(value = "Серия и номер паспорта")
    @Column(name="passport",nullable = false)
    private String passport;

    @JsonIgnore
    @ManyToOne (fetch = LAZY)
    @JoinColumn (name ="outfitid")
    private Outfits outfits;
}
