package car.web.rest;

import car.model.Manufacturer;
import car.service.ModelService;
import car.web.rest.dto.ModelDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
@RequiredArgsConstructor
public class ModelValidator  implements Validator {

    private final ModelService modelService;

    @Override
    public boolean supports(Class<?> clazz) { return clazz.isAssignableFrom(ModelDTO.class);}

    @Override
    public void validate (Object target, Errors errors) {
        ModelDTO model = (ModelDTO) target;
        Manufacturer manufacturer = modelService.getManufacturerById(model.getManufacturerId());
        if(manufacturer == null) {
            errors.rejectValue("manufacturerId", "model.manufacturer.missing");
        }
    }
}
