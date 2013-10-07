package a3;
import edu.princeton.cs.algs4.Stack;

public class TwoStackQueue<T> {
	Stack<T> inbox;
	Stack<T> outbox;
	
	public TwoStackQueue() {
		inbox = new Stack<T>();
		outbox = new Stack<T>();
	}
	
	public boolean isEmpty() {
		return inbox.isEmpty() && outbox.isEmpty();
	}

	public void enqueue(T item) {
		inbox.push(item);
	}

	public T dequeue() {
		if (outbox.isEmpty()) {
			while(inbox.size() > 0) {
				outbox.push(inbox.pop());
			}
		}
		return outbox.pop();
	}

}
