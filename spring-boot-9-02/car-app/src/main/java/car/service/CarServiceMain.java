package car.service;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import car.model.Dealership;

import java.util.List;

public class CarServiceMain {

    public static void main(String[] args) {
        System.out.println("Let's find dealerships!");

        ApplicationContext context = new AnnotationConfigApplicationContext("car");
        DealershipService service = context.getBean(DealershipService.class);
        DealershipService service2 = context.getBean(DealershipService.class);

        List<Dealership> dealerships = service.getAllDealerships();
        System.out.println(dealerships.size() + " dealerships found:");
        dealerships.forEach(System.out::println);

        String foo = context.getBean(String.class);
        System.out.println("foo string: " + foo);
    }
}
