package ir.fallahpoor.tsp;

import java.util.ArrayList;
import java.util.List;

public class CityRepository {

    private static final int NUMBER_OF_CITIES = 20;
    private static final int MAX_X_COORDINATE = 100;
    private static final int MAX_Y_COORDINATE = 100;
    private static final List<City> cities = new ArrayList<>();

    static {
        for (int i = 0; i < NUMBER_OF_CITIES; i++) {
            int x = (int) (Math.random() * MAX_X_COORDINATE);
            int y = (int) (Math.random() * MAX_Y_COORDINATE);
            CityRepository.addCity(new City(x, y));
        }

    }

    private CityRepository() {
    }

    public static void addCity(City city) {
        cities.add(city);
    }

    public static City getCity(int index) {
        return cities.get(index);
    }

    public static int getNumberOfCities() {
        return cities.size();
    }

}
