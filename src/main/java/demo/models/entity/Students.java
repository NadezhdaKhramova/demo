package demo.models.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import javax.persistence.*;
import java.util.Date;

import static javax.persistence.FetchType.LAZY;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "students", schema ="db_test")
@Entity( name="students")
@EqualsAndHashCode(exclude = "outfits")
@ToString(exclude = "outfits")
public class Students {

    @JsonProperty("Номер")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonProperty("ФИО")
    @Column(name="fio")
    private String  fio;

    @JsonProperty("Дата зачисления")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd@HH:mm:ss")
    @Column(name="dateOfAdmission")
    private Date dateOfAdmission;

    @JsonProperty("Серия и номер паспорта")
    @Column(name="passport", nullable = true)
    private String passport;

    @JsonIgnore
    @ManyToOne (fetch = LAZY )
    @JoinColumn (name ="outfitid")
    private Outfits outfits;
}
