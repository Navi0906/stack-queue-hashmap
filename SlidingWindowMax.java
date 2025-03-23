import java.util.*;

public class SlidingWindowMax {

    public static void slidingWindowMax(int[] nums, int k) {
        Deque<Integer> deque = new LinkedList<>();

        for (int i = 0; i < nums.length; i++) {
            // Remove elements out of this window
            if (!deque.isEmpty() && deque.peek() <= i - k) {
                deque.poll();
            }

            // Remove smaller elements in k range as they are useless
            while (!deque.isEmpty() && nums[deque.peekLast()] < nums[i]) {
                deque.pollLast();
            }

            // Add current element at the back of the deque
            deque.offer(i);

            // The front of the deque is the largest element of the current window
            if (i >= k - 1) {
                System.out.print(nums[deque.peek()] + " ");
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 3, -1, -3, 5, 3, 6, 7};
        int k = 3;
        System.out.println("Sliding window maximums:");
        slidingWindowMax(nums, k);
    }
}
