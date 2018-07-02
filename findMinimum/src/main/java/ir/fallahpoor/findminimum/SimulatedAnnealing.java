package ir.fallahpoor.findminimum;

class SimulatedAnnealing {

    private static final double MIN_X = -2;
    private static final double MAX_X = 2;

    // Parameters of Simulated Annealing algorithm that can be tuned
    private static final double MIN_TEMPERATURE = 1;
    private static final double MAX_TEMPERATURE = 100;
    private static final double COOLING_RATE = 0.02;

    // Tries to find the global minimum of f(x) in range [MIN_X, MAX_X)
    double findMinimum() {

        double temperature = MAX_TEMPERATURE;
        double currentX = MIN_X;
        double bestX = currentX;

        // Loop until system has cooled
        while (temperature > MIN_TEMPERATURE) {

            // Get a randomly generated solution
            double newX = getRandomX();

            double currentEnergy = getEnergy(currentX);
            double newEnergy = getEnergy(newX);

            // Decide if we should accept the neighbour
            if (acceptanceProbability(currentEnergy, newEnergy, temperature) > Math.random()) {
                currentX = newX;
            }

            // Check if new solution is better that current solution
            if (f(currentX) < f(bestX)) {
                bestX = currentX;
            }

            // Cool system
            temperature = temperature * (1 - COOLING_RATE);

        }

        return f(bestX);

    }


    // Returns a random number in range [MIN_X, MAX_X)
    private double getRandomX() {
        return MIN_X + (Math.random() * (MAX_X - MIN_X));
    }

    private double getEnergy(double x) {
        return f(x);
    }

    private double acceptanceProbability(double currentEnergy, double newEnergy, double temperature) {

        if (newEnergy < currentEnergy) {
            // Neighbour point is better that current point and certainly we are gonna select it.
            return 1;
        } else {
            // Neighbour point is worse than current point but there should still be a chance to select neighbour
            // to escape possible local minimum trap
            return Math.exp((currentEnergy - newEnergy) / temperature);
        }

    }

    // The function to find its minimum in range [MIN_X, MAX_X)
    private double f(double x) {
        return Math.pow(x - 0.3, 3) - (5 * x) + Math.pow(x, 2) - 2;
    }

}
