import java.util.LinkedList;
import java.util.Queue;

public class CircularTour {

    // Define a petrol pump
    static class PetrolPump {
        int petrol;
        int distance;

        PetrolPump(int petrol, int distance) {
            this.petrol = petrol;
            this.distance = distance;
        }
    }

    // Function to find the starting pump index
    public static int findStartingPoint(PetrolPump[] pumps) {
        int start = 0;
        int n = pumps.length;
        int deficit = 0;
        int balance = 0;

        for (int i = 0; i < n; i++) {
            balance += pumps[i].petrol - pumps[i].distance;
            if (balance < 0) {
                deficit += balance;
                start = i + 1;
                balance = 0;
            }
        }

        return (balance + deficit >= 0) ? start : -1;
    }

    public static void main(String[] args) {
        PetrolPump[] pumps = {
                new PetrolPump(6, 4),
                new PetrolPump(3, 6),
                new PetrolPump(7, 3)
        };

        int start = findStartingPoint(pumps);
        if (start != -1)
            System.out.println("Start at petrol pump index: " + start);
        else
            System.out.println("No feasible starting point exists.");
    }
}
