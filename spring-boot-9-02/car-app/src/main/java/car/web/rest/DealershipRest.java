package car.web.rest;


import car.model.Model;
import car.service.ModelService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import car.model.Dealership;
import car.service.DealershipService;
import org.springframework.web.servlet.LocaleResolver;

import java.util.List;
import java.util.Locale;

@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/webapi")
public class DealershipRest {

    private final DealershipService dealershipService;
    private final ModelService modelService;
    private final MessageSource messageSource;
    private final LocaleResolver localeResolver;
    //private final DealershipValidator validator;

    @GetMapping("/dealerships")
    List<Dealership> getDealerships(
            @RequestParam(value = "phrase", required = false) String phrase,
            @RequestHeader(value = "custom-header", required = false) String customHeader,
            @CookieValue(value = "some-cookie", required = false) String someCookie
     ){
        log.info("about to retrieve dealerships list");
        log.info("phrase param: {}", phrase);
        log.info("custom-header param: {}", customHeader);
        log.info("some-cookie param: {}", someCookie);

        if(phrase!=null && phrase.equals("foo")){
            throw new IllegalArgumentException("Foo!");
        }

        List<Dealership> dealerships = dealershipService.getAllDealerships();
        log.info("{} dealerships found", dealerships.size());
        return dealerships;
    }

    @GetMapping("/dealerships/{id}")
    ResponseEntity<Dealership> getDealership(@PathVariable("id") int id) {
        log.info("about to retrieve dealership with id {}", id);
        Dealership dealership = dealershipService.getDealershipById(id);
        log.info("{} dealership found", dealership);
        if(dealership!=null){
            return ResponseEntity.ok(dealership);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @GetMapping("/models/{modelId}/dealerships")
    ResponseEntity<List<Dealership>> getDealershipsSellingModel(@PathVariable("modelId") int modelId) {
        log.info("about to retrieve dealerships selling model {}", modelId);
        Model model = modelService.getModelById(modelId);
        if(model==null){
            return ResponseEntity.notFound().build();
        } else {
            List<Dealership> dealerships = dealershipService.getDealershipByModels(model);
            log.info("there's {} dealerships selling model {}", dealerships.size(), model.getName());
            return ResponseEntity.ok(dealerships);
        }
    }

    @PostMapping("/dealerships")
    ResponseEntity<?> addDealership(@Validated @RequestBody Dealership dealership, Errors errors, HttpServletRequest request) {
        log.info("about to add new dealership {}", dealership);

        if(errors.hasErrors()) {
            Locale locale = localeResolver.resolveLocale(request);
            String errorMessage = errors.getAllErrors().stream()
                    .map(oe->messageSource.getMessage(oe.getCode(), new Object[0], locale))
                    .reduce("errors:\n", (accu, oe)->accu+oe+"\n");

            return ResponseEntity.badRequest().body(errorMessage);
        }


        dealership = dealershipService.addDealership(dealership);
        log.info("new dealership added {}", dealership);
        return ResponseEntity.status(HttpStatus.CREATED).body(dealership);
    }
}

