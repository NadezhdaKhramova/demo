package demo.models.DTO;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class TeachersOutfitsDTO {

    @JsonProperty("nameOutfit")
    private String name;

    @JsonProperty("fioTeacher")
    private String fio;


}
