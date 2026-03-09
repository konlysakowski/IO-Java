package car.model;

import java.util.ArrayList;
import java.util.List;

public class Model {

    private int id;
    private String name;
    private String brandLogo;//url
    private Manufacturer manufacturer;
    private float engine;//rating
    private List<Dealership> dealerships = new ArrayList<>();

    public Model(int id, String name, String brandLogo, Manufacturer manufacturer, float engine) {
        this.id = id;
        this.name = name;
        this.brandLogo = brandLogo;
        this.manufacturer = manufacturer;
        this.engine = engine;
    }

    public Model() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBrandLogo() {
        return brandLogo;
    }

    public void setBrandLogo(String brandLogo) {
        this.brandLogo = brandLogo;
    }

    public Manufacturer getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(Manufacturer manufacturer) {
        this.manufacturer = manufacturer;
    }

    public float getEngine() {
        return engine;
    }

    public void setEngine(float engine) {
        this.engine = engine;
    }

    public List<Dealership> getDealerships() {
        return dealerships;
    }

    public void setDealerships(List<Dealership> dealerships) {
        this.dealerships = dealerships;
    }

    public void addDealership(Dealership d) {
        this.dealerships.add(d);
    }


   /* @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Movie movie = (Movie) o;

        if (id != movie.id) return false;
        if (Float.compare(movie.rating, rating) != 0) return false;
        if (title != null ? !title.equals(movie.title) : movie.title != null) return false;
        return poster != null ? poster.equals(movie.poster) : movie.poster == null;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (title != null ? title.hashCode() : 0);
        result = 31 * result + (poster != null ? poster.hashCode() : 0);
        result = 31 * result + (rating != +0.0f ? Float.floatToIntBits(rating) : 0);
        return result;
    }*/

    @Override
    public String toString() {
        return "Model{" +
                "name='" + name + '\'' +
                ", manufacturer=" + manufacturer +
                ", engine=" + engine +
                '}';
    }
}
