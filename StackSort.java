import java.util.Stack;

public class StackSort {

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(30);
        stack.push(-5);
        stack.push(18);
        stack.push(14);
        stack.push(-3);

        System.out.println("Original Stack:");
        display(stack);

        sortStack(stack);

        System.out.println("Sorted Stack:");
        display(stack);
    }

    // Main function to sort stack
    public static void sortStack(Stack<Integer> stack) {
        if (!stack.isEmpty()) {
            int temp = stack.pop();
            sortStack(stack); // Sort the remaining stack
            insertInSortedOrder(stack, temp); // Insert the popped element back in sorted order
        }
    }

    // Helper function to insert element in sorted order
    private static void insertInSortedOrder(Stack<Integer> stack, int element) {
        if (stack.isEmpty() || element > stack.peek()) {
            stack.push(element);
        } else {
            int temp = stack.pop();
            insertInSortedOrder(stack, element);
            stack.push(temp);
        }
    }

    // Display stack from top to bottom
    public static void display(Stack<Integer> stack) {
        Stack<Integer> temp = new Stack<>();
        while (!stack.isEmpty()) {
            temp.push(stack.pop());
        }
        while (!temp.isEmpty()) {
            int val = temp.pop();
            System.out.print(val + " ");
            stack.push(val);
        }
        System.out.println();
    }


}
