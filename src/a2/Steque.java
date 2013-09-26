package a2;

public class Steque<T> {
	int count = 0;
	Node<T> first;
	Node<T> last;
	
	public boolean isEmpty() {
		return count == 0;
	}
	
	private class Node<T> {
		T item;
		Node next;
		public Node(T item, Node next) {
			this.item = item;
			this.next = next;
		}
		public Node(T item) {
			this(item, null);
		}
	}

	public void push(T item) {
		Node<T> n = new Node<T>(item, first);
		if (isEmpty()) {
			first = last = n;
		} else {
			first = n;
		}
		count++;
	}

	@Override
	public String toString() {
		Node<T> curr = first;
		StringBuilder sb = new StringBuilder();
		while (curr != null) {
			sb.append(curr.item+" ");
			curr = curr.next;
		}
		return sb.toString();
	}

	public T pop() {
		T popped = first.item;
		first = first.next;
		count--;
		return popped;
	}

	public void enqueue(T item) {
		if(isEmpty()) {
			push(item);
		} else {
			last.next = new Node<T>(item);
			last = last.next;
			count++;
		}
		
	}

	public void catenate(Steque<T> other) {
		last.next = other.first;
		last = other.last;
		count += other.count;
		
	}
	
	
}
