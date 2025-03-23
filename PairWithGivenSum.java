import java.util.HashSet;

public class PairWithGivenSum {

    public static boolean hasPairWithSum(int[] arr, int target) {
        HashSet<Integer> set = new HashSet<>();

        for (int num : arr) {
            int complement = target - num;

            if (set.contains(complement)) {
                System.out.println("Pair found: (" + complement + ", " + num + ")");
                return true;
            }
            set.add(num);
        }

        System.out.println("No pair found with sum " + target);
        return false;
    }

    public static void main(String[] args) {
        int[] arr = {8, 7, 2, 5, 3, 1};
        int target = 10;

        hasPairWithSum(arr, target);
    }
}
