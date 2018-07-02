package ir.fallahpoor.findminimum;

public class Main {

    public static void main(String[] args) {

        SimulatedAnnealing simulatedAnnealing = new SimulatedAnnealing();
        System.out.println("Global minimum guess of f(x) is : " + simulatedAnnealing.findMinimum());

    }
}
