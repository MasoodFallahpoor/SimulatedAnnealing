package ir.fallahpoor.tsp;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Tour {

    private List<City> tour;
    private double distance;

    public Tour() {

        tour = new ArrayList<>();

        for (int i = 0; i < CityRepository.getNumberOfCities(); i++) {
            tour.add(null);
        }

    }

    public Tour(List<City> tour) {
        this.tour = new ArrayList<>(tour);
    }

    public List<City> getTour() {
        return tour;
    }

    public void setTour(List<City> tour) {
        this.tour = tour;
    }

    public void generateTour() {

        for (int i = 0; i < CityRepository.getNumberOfCities(); i++) {
            setCity(i, CityRepository.getCity(i));
        }

        Collections.shuffle(tour);

    }

    public void setCity(int i, City city) {
        tour.set(i, city);
        distance = 0;
    }

    public City getCity(int index) {
        return tour.get(index);
    }

    public int getSize() {
        return tour.size();
    }

    public double getDistance() {

        if (distance == 0) {

            for (int i = 0; i < getSize(); i++) {

                City fromCity = getCity(i);
                City toCity;

                if (i + 1 < getSize()) {
                    toCity = getCity(i + 1);
                } else {
                    toCity = getCity(0);
                }

                distance += fromCity.distanceTo(toCity);

            }

            return distance;

        } else {
            return distance;
        }

    }

    @Override
    public String toString() {

        StringBuilder stringBuilder = new StringBuilder();

        for (City city : tour) {
            stringBuilder.append(city).append("->");
        }

        return stringBuilder.toString();

    }

}
