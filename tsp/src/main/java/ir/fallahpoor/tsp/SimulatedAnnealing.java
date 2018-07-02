package ir.fallahpoor.tsp;

import java.util.Random;

class SimulatedAnnealing {

    private static final double MIN_TEMPERATURE = 1;
    private static final double MAX_TEMPERATURE = 10000;
    private static final double COOLING_RATE = 0.02;

    void findBestTour() {

        double temperature = MAX_TEMPERATURE;

        Tour currentTour = new Tour();
        currentTour.generateTour();

        Tour bestTour = new Tour(currentTour.getTour());

        System.out.println("Initial tour distance : " + currentTour.getDistance());

        while (temperature > MIN_TEMPERATURE) {

            Tour newTour = getNewTour(currentTour);

            double currentEnergy = currentTour.getDistance();
            double newEnergy = newTour.getDistance();

            if (acceptanceProbability(currentEnergy, newEnergy, temperature) > Math.random()) {
                currentTour = new Tour(newTour.getTour());
            }

            if (currentTour.getDistance() < bestTour.getDistance()) {
                bestTour = currentTour;
            }

            temperature = temperature * (1 - COOLING_RATE);

        }

        System.out.println("Best tour distance : " + bestTour.getDistance());

    }

    private Tour getNewTour(Tour currentTour) {

        Tour tour = new Tour(currentTour.getTour());
        Random random = new Random();

        int randomIndex1 = random.nextInt(tour.getSize());
        int randomIndex2 = random.nextInt(tour.getSize());

        City city1 = tour.getCity(randomIndex1);
        City city2 = tour.getCity(randomIndex2);

        tour.setCity(randomIndex1, city2);
        tour.setCity(randomIndex2, city1);

        return tour;

    }

    private double acceptanceProbability(double currentEnergy, double newEnergy, double temperature) {

        if (newEnergy < currentEnergy) {
            return 1;
        } else {
            return Math.exp((currentEnergy - newEnergy) / temperature);
        }

    }

}
