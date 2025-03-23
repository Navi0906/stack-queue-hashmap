import java.util.Stack;

public class StockSpan {
    public static void main(String[] args) {
        int prices[] = {100, 80, 60, 70, 60, 75, 85};
        int n = prices.length;
        int[] span = new int[n];

        calculateSpan(prices, n, span);

        System.out.println("Day\tPrice\tSpan");
        for (int i = 0; i < n; i++) {
            System.out.println((i + 1) + "\t" + prices[i] + "\t" + span[i]);
        }
    }

    public static void calculateSpan(int[] prices, int n, int[] span) {
        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        span[0] = 1;

        for (int i = 1; i < n; i++) {
            // Pop smaller or equal prices
            while (!stack.isEmpty() && prices[i] >= prices[stack.peek()]) {
                stack.pop();
            }

            span[i] = (stack.isEmpty()) ? (i + 1) : (i - stack.peek());
            stack.push(i);
        }
    }


}
