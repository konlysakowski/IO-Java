package car.web.rest;

import car.model.Dealership;
import car.model.Model;
import car.service.DealershipService;
import car.service.ModelService;
import car.web.rest.dto.ModelDTO;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.util.List;

@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/webapi")
public class ModelRest {

    private final DealershipService dealershipService;
    private final ModelService modelService;
    private final MessageSource messageSource;
    private final LocaleResolver localeResolver;

    @GetMapping("/models")
    List<Model> getModels() {
        log.info("about to retrieve models list");
        List<Model> models = modelService.getAllModels();
        log.info("{} models found", models.size());
        return models;
    }

    @GetMapping("/models/{id}")
    ResponseEntity<Model> getModel(@PathVariable("id") int id) {
        log.info("about to retrieve model with id {}", id);
        Model model = modelService.getModelById(id);
        log.info("{} model found", model);
        if(model!=null){
            return ResponseEntity.ok(model);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @GetMapping("/dealership/{dealershipId}/models")
    ResponseEntity<List<Model>> getModelsSoldAtDealership(@PathVariable("dealershipId") int dealershipId) {
        log.info("about to retrieve models sold at dealership {}", dealershipId);
        Dealership dealership = dealershipService.getDealershipById(dealershipId);
        if(dealership==null){
            return ResponseEntity.notFound().build();
        } else {
            List<Model> models = dealershipService.getModelsInDealership(dealership);
            log.info("there's {} models sold at dealership {}", models.size(), dealership.getName());
            return ResponseEntity.ok(models);
        }
    }

    @PostMapping("/model")
    ResponseEntity<?> addModel(@RequestBody @Valid ModelDTO modelDTO, Errors errors) {
        log.info("about to add new model {}", modelDTO);
        if(errors.hasErrors()) {
            return ResponseEntity.badRequest().build();
        }
        Model model = new Model();
        model.setName(modelDTO.getName());
        model.setBrandLogo(modelDTO.getBrandLogo());
        model.setEngine(modelDTO.getEngine());
        model.setManufacturer(modelService.getManufacturerById(modelDTO.getManufacturerId()));

        model = modelService.addModel(model);
        log.info("new model added: {}", model);
        return ResponseEntity
                //.status(HttpStatus.CREATED)
                .created(
                        ServletUriComponentsBuilder
                                .fromCurrentRequestUri()
                                .path("/" + model.getId())
                                .build()
                                .toUri())
                .body(model);
    }

}
