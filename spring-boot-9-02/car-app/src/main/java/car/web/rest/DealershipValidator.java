package car.web.rest;

import car.model.Dealership;
import car.service.DealershipService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
@RequiredArgsConstructor
public class DealershipValidator implements Validator {

    private final DealershipService dealershipService;

    public boolean supports(Class<?> clazz) {
        return clazz.isAssignableFrom(Dealership.class);
    }

    @Override
    public void validate(Object target, Errors errors) {
        Dealership validatedDealership = (Dealership) target;

        boolean duplicated = dealershipService.getAllDealerships().stream()
                .anyMatch(dealership -> dealership.getName().equalsIgnoreCase(validatedDealership.getName()));
        if (duplicated) {
            errors.rejectValue("name", "dealership.name.duplicated");
        }
    }
}
