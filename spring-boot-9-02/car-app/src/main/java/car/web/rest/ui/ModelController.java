package car.web.rest.ui;

import car.model.Dealership;
import car.model.Manufacturer;
import car.service.DealershipService;
import car.service.ModelService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequiredArgsConstructor
@Slf4j
public class ModelController {

    private final DealershipService dealershipService;
    private final ModelService modelService;

    @GetMapping("/models")
    String getModels(
            Model model,
            @RequestParam(value = "dealershipsId", required = false) Integer dealershipId,
            @RequestParam(value = "manufacturerId", required = false) Integer manufacturerId) {
        log.info("about to display models list in dealership {}", dealershipId);
        if(dealershipId!=null){
            Dealership dealership = dealershipService.getDealershipById(dealershipId);
            List<car.model.Model> models = dealershipService.getModelsInDealership(dealership);
            model.addAttribute("models", models);
            model.addAttribute("name", "Models in dealership '" + dealership.getName() + "'");
        } else if(manufacturerId!=null) {
            Manufacturer manufacturer = modelService.getManufacturerById(manufacturerId);
            List<car.model.Model> models = modelService.getModelsByManufacturer(manufacturer);
            model.addAttribute("models", models);
            model.addAttribute("name", "Models manufactured by '" + manufacturer.getCountry() + "'");
        } else {
            List<car.model.Model> models = modelService.getAllModels();
            model.addAttribute("models", models);
            model.addAttribute("name", "Models");
        }

        return "modelsView";
    }
}
