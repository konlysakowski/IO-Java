package car.web.rest.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class ModelDTO {
    private String name;
    private String brandLogo;
    private int manufacturerId;
    private float engine;

}
