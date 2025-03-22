import java.util.Stack;

public class QueueStacks {
    public static void main(String[] args) {
        QueueUsingStacks queue = new QueueUsingStacks();

        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);

        queue.display();

        System.out.println("Dequeued: " + queue.dequeue());
        queue.display();

        System.out.println("Front element: " + queue.peek());
    }
}

class QueueUsingStacks {
    Stack<Integer> stack1 = new Stack<>();
    Stack<Integer> stack2 = new Stack<>();

    // Enqueue operation
    public void enqueue(int data) {
        stack1.push(data);
        System.out.println(data + " enqueued to queue.");
    }

    // Dequeue operation
    public int dequeue() {
        if (isEmpty()) {
            System.out.println("Queue is empty.");
            return -1;
        }

        if (stack2.isEmpty()) {
            // Transfer all elements from stack1 to stack2
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }
        return stack2.pop();
    }

    // Peek operation (view front element)
    public int peek() {
        if (isEmpty()) {
            System.out.println("Queue is empty.");
            return -1;
        }
        if (stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }
        return stack2.peek();
    }

    // Check if queue is empty
    public boolean isEmpty() {
        return stack1.isEmpty() && stack2.isEmpty();
    }

    // Display queue elements
    public void display() {
        if (isEmpty()) {
            System.out.println("Queue is empty.");
            return;
        }

        // Display elements in correct order
        System.out.print("Queue elements: ");
        Stack<Integer> tempStack = new Stack<>();

        // Print stack2 (front of queue)
        for (int i = stack2.size() - 1; i >= 0; i--) {
            System.out.print(stack2.get(i) + " ");
        }

        // Print stack1 (back of queue)
        for (int i = 0; i < stack1.size(); i++) {
            tempStack.push(stack1.get(i));
        }
        while (!tempStack.isEmpty()) {
            System.out.print(tempStack.pop() + " ");
        }
        System.out.println();
    }
}


