package car.config;

import car.service.ModelService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.actuate.info.Info;
import org.springframework.boot.actuate.info.InfoContributor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CarInfoContributor implements InfoContributor {

    private final ModelService modelService;


    @Override
    public void contribute(Info.Builder builder) {
        builder.withDetail("models", modelService.getAllModels().size());
    }
}
