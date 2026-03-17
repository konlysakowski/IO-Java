package car.web.rest.ui;

import car.model.Dealership;
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
public class DealershipController {

    private final DealershipService dealershipService;
    private final ModelService modelService;

    @GetMapping("/dealerships")
    String getDealerships(
            Model model,
            @RequestParam(value = "modelId", required = false) Integer modelId) {
        log.info("about to display dealerships list selling model {}", modelId);
        if(modelId!=null){
            Model model = modelService.getModelById(modelId);
        }
        List<Dealership> dealerships = dealershipService.getAllDealerships();
        model.addAttribute("dealerships", dealerships);

        return "dealershipsView";
    }
}
