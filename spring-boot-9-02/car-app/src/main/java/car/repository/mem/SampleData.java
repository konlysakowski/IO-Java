package car.repository.mem;

import car.model.Dealership;
import car.model.Manufacturer;
import car.model.Model;

import java.util.ArrayList;
import java.util.List;

class SampleData {

    static List<Dealership> dealerships = new ArrayList<>();

    static List<Manufacturer> manufacturers = new ArrayList<>();

    static List<Model> models = new ArrayList<>();

    static {

        Manufacturer skoda = new Manufacturer(1, "Skoda", "Czech Republic");
        Manufacturer ford = new Manufacturer(2, "Ford", "USA");
        Manufacturer citroen = new Manufacturer(3, "Citroen", "France");
        Manufacturer opel = new Manufacturer(4, "Opel", "Germany");

        Model octavia = new Model(1, "Octavia", "https://cdn.skoda-storyboard.com/2020/11/SKODA-3D-Standard-Logo_sRGB-e1478246875778.png", skoda, (float) 2.0);
        Model fabia = new Model(2, "Fabia", "https://cdn.skoda-storyboard.com/2020/11/SKODA-3D-Standard-Logo_sRGB-e1478246875778.png", skoda, (float) 1.4);

        Model focus = new Model(3, "Focus", "https://www.citypng.com/public/uploads/preview/ford-logo-emblem-hd-png-70175169471401511cpxj0ogw.png", ford, (float) 2.2);
        Model fiesta = new Model(4, "Fiesta", "https://www.citypng.com/public/uploads/preview/ford-logo-emblem-hd-png-70175169471401511cpxj0ogw.png", ford, (float) 1.6);

        Model berlingo = new Model(5, "Berlingo", "https://logos-world.net/wp-content/uploads/2021/08/Citroen-Emblem-700x394.png", citroen, (float) 2.4);
        Model jumpy = new Model(6, "Jumpy", "https://logos-world.net/wp-content/uploads/2021/08/Citroen-Emblem-700x394.png", citroen, (float) 2.0);

        Model astra = new Model(7, "Astra", "https://www.citypng.com/public/uploads/preview/hd-opel-logo-transparent-background-701751694707069gfhsibdnlp.png", opel, (float) 1.2);
        Model insignia = new Model(8, "Insignia", "https://www.citypng.com/public/uploads/preview/hd-opel-logo-transparent-background-701751694707069gfhsibdnlp.png", opel, (float) 3.0);

        bind(octavia, skoda);
        bind(fabia, skoda);

        bind(focus, ford);
        bind(fiesta, ford);

        bind(berlingo, citroen);
        bind(jumpy, citroen);

        bind(astra, opel);
        bind(insignia, opel);

        Dealership autopunkt = new Dealership(1, "Autopunkt", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTNWXrN3dgjBHiUUo3hRCn3NmaTbPbthqgvrg&s");
        Dealership dynamica = new Dealership(2, "Dynamica Caroutlet", "https://caroutlet.pl/wp-content/uploads/2024/04/dynamica-uzywanev3.svg");
        Dealership karo = new Dealership(3, "Karo Auto Komis", "https://komiskaro.pl/f/199d1589/6529/crop/detect/60/v0/w0/h200/L_011-1.png");
        Dealership superauto = new Dealership(4, "Superauto", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSSThx78YXgqyqOL2yccb_4svVGx5dIuP8neg&s");

        bind(autopunkt, fabia);
        bind(karo, fabia);
        bind(karo, octavia);
        bind(karo, focus);

        bind(autopunkt, jumpy);
        bind(superauto, jumpy);
        bind(superauto, astra);
        bind(dynamica, astra);
        bind(dynamica, focus);

        models.add(octavia);
        models.add(fabia);
        models.add(focus);
        models.add(fiesta);
        models.add(berlingo);
        models.add(jumpy);
        models.add(astra);
        models.add(insignia);

        manufacturers.add(skoda);
        manufacturers.add(ford);
        manufacturers.add(citroen);
        manufacturers.add(opel);

        dealerships.add(autopunkt);
        dealerships.add(dynamica);
        dealerships.add(karo);
        dealerships.add(superauto);

    }

    private static void bind(Dealership c, Model m) {
        c.addModel(m);
        m.addDealership(c);
    }

    private static void bind(Model m, Manufacturer d) {
        d.addModel(m);
        m.setManufacturer(d);
    }

}
