package car.web.rest;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import car.model.Dealership;
import car.service.DealershipService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@Slf4j
public class DealershipRest {

    private final DealershipService dealershipService;

    @GetMapping("/dealerships")
    List<Dealership> getDealerships() {
        log.info("about to retrieve dealerships list");
        List<Dealership> dealerships = dealershipService.getAllDealerships();
        log.info("{} dealerships found", dealerships.size());
        return dealerships;
    }
}
