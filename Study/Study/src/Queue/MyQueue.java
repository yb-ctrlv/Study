package Queue;

public class MyQueue<T> {

	java.util.Stack<T> stackNewest, stackOldest;
	public MyQueue() {
		stackNewest = new java.util.Stack<T>();
		stackOldest = new java.util.Stack<T>();
	}
	public int size() {
		return stackNewest.size() + stackOldest.size();
	}
	
	public void add(T value) {
		stackNewest.push(value);
	}
	private void shiftStacks() {
		if(stackOldest.isEmpty()) {
			while(!stackNewest.isEmpty()) {
				stackOldest.push(stackNewest.pop());
			}
		}
	}
	
	public T peek() {
		shiftStacks();
		return stackOldest.peek();
	}
	
	public T remove() {
		shiftStacks();
		return stackOldest.pop();
	}
}
