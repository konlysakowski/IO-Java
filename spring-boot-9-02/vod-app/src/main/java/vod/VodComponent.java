package vod;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import vod.model.Cinema;
import vod.service.CinemaService;

@Component
@Slf4j
public class VodComponent {
    public VodComponent(CinemaService cinemaService) {

    }
}
