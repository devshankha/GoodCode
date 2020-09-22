//this is code to implement a generic stack

class Stack<T> {
	private int top = -1;
	T[] arr;
	public Stack(int size) {
		//see how this is implemented
		arr = (T[]) new Object[size];
		
	}
	void push (T item) {
		arr[++top] = item;
	}
	
	T pop() {
		return arr[top--];
	}
	
}
public class GenericStack {
	public static void main(String[] args) {
		Stack<String> s1 = new Stack(5);
		s1.push("A");
		s1.push("B");
		s1.push("C");
		s1.push("D");
		System.out.println(s1.pop());
		System.out.println(s1.pop());
		System.out.println(s1.pop());
		System.out.println(s1.pop());
	}

}
