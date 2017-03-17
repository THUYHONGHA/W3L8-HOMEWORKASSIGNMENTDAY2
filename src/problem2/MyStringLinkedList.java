package problem2;

public class MyStringLinkedList {
	Node header;

	MyStringLinkedList() {
		header = null;
	}

	public void addFront(String item) {
		if (header == null)
			header = new Node(null, item, null);
		else {
			Node n = new Node(null, item, header);
			header.previous = n;
			header = n;
		}
	}

	// Implement the code

	public void addLast(String item) {
		if (header == null)
			header = new Node(null, item, null);
		else {
			Node last = header;
			while (last.next != null) {
				last = last.next;
			}
			Node newNode = new Node(last, item, null);
			last.next = newNode;
			last = newNode;
		}
	}

	// implement the code
	public void postAddNode(Node n, String value) {
		if (n == null) {
			header = new Node(null, value, null);
		} else {
			Node newNode = new Node(n, value, n.next);
			n.next = newNode;
		}
	}
	// implement the code

	public int size() {
		int size = 0;
		Node temp = header;
		while (temp != null) {
			size++;
			temp = temp.next;
		}
		return size;
	}

	// implement code
	public boolean isEmpty() {
		if (header == null)
			return false;
		return true;
	}

	// implement the code
	public Object getFirst() {
		if (header == null)
			return null;
		return header;
	}

	// implement the code
	public Object getLast() {
		if (header == null) {
			System.out.println("LinkedList is empty.");
			return null;
		}
		Node temp = header;
		while (temp.next != null) {
			temp = temp.next;
		}
		return temp;
	}

	// implement the code
	public void removeFirst() {
		if (header == null)
			return;
		header = header.next;
	}

	// implement the code
	public void removeLast() {
		if (header == null)
			return;
		Node temp = header;
		while (temp.next != null) {
			temp = temp.next;
		}
		temp = temp.previous;
		temp.next = null;
	}

	// implement the code
	public void printMin() {
		if (header == null)
			return;
		Node temp = header;
		String min = temp.value;
		do {
			if (min.compareToIgnoreCase(temp.next.value) > 0) {
				min = temp.next.value;
			}
			temp = temp.next;
		} while (temp.next != null);
		System.out.println(min);
	}

	// implement the code
	public void printMax() {
		if (header == null)
			return;
		Node temp = header;
		String max = temp.value;
		while (temp.next != null) {
			if (max.compareToIgnoreCase(temp.next.value) < 0) {
				max = temp.next.value;
			}
			temp = temp.next;
		}
		System.out.println(max);
	}

	// implement the code
	public void print(Node n) {
		if (n == null)
			return;
		System.out.println(n.value);
		print(n.next);
	}

	public void preAddNode(Node n, String value) {
		Node newNode;
		if (n == null) {
			// List is empty
			newNode = new Node(null, value, null);
		} else if (n.previous == null) {
			// n is the first node
			addFront(value);
		} else {
			newNode = new Node(n.previous, value, n);
			n.previous.next = newNode;
			n.previous = newNode;
		}

	}

	public Node findLast() {
		if (header == null)
			return null;
		else {
			Node temp = header;
			while (temp.next != null)
				temp = temp.next;
			return temp;
		}
	}

	public Node findItem(String str) {
		if (header == null)
			return null;
		else {
			Node temp = header;
			while (temp != null)
				if (str.equals(temp.value))
					return temp;
				else
					temp = temp.next;
			return null;
		}
	}

	public void deleteNode(Node n) {
		if (header != null && n != null) {
			if (n.next == null && n.previous == null) {
				// only one node
				header = null;
				n = null;
				System.out.println("I am here 1");

			} else if (n.previous == null) {
				// remove first node
				n.next.previous = null;
				header = n.next;
				n = null;
				System.out.println("I am here 2");
			} else if (n.next == null) {
				// remove last node
				n.previous.next = null;
				n = null;
				System.out.println("I am here 3");
			} else {
				// general case
				n.next.previous = n.previous;
				n.previous.next = n.next;
				n = null;
				System.out.println("I am here 4");
			}

		}

	}

	public void deleteList() {
		Node tempOne = header;
		Node tempTwo = header;
		while (tempOne != null) {
			tempOne = tempOne.next;
			tempTwo = null;
			tempTwo = tempOne;
		}
		header = null;
	}

	public String toString() {
		String str = "";
		Node temp = header;
		while (temp != null) {
			str = str + "-->[" + temp.value.toString() + "]";
			temp = temp.next;
		}
		str = str + "-->[" + "NULL" + "]";
		return str;
	}

	public void printReverse() {
		String str = "";
		Node temp = findLast();
		while (temp != null) {
			str = str + "==>[" + temp.value.toString() + "]";
			temp = temp.previous;
		}
		str = str + "==>[" + "NULL" + "]";
		System.out.println(str);
	}

	public class Node {
		String value;
		Node next;
		Node previous;

		Node(Node previous, String value, Node next) {
			this.previous = previous;
			this.value = value;
			this.next = next;
		}

		public String toString() {
			return value;
		}
	}

	public static void main(String[] args) {
		MyStringLinkedList mySL = new MyStringLinkedList();
		System.out.println("mySL size: " + mySL.size());
		System.out.println(mySL);
		mySL.printReverse();
		mySL.addLast("Test1 Cake");
		mySL.addLast("Test2 Cake");
		mySL.addLast("Test3 Cake");
		System.out.println("AddLast Test: " + mySL);
		mySL.addFront("Carrot Cake");

		// mySL.printReverse();
		mySL.addFront("Blueberry Muffin");
		System.out.println(mySL);
		mySL.printReverse();
		mySL.addFront("Apple Pie");
		System.out.println(mySL);
		mySL.printReverse();
		mySL.addLast("Orange Juice");
		System.out.println(mySL);
		System.out.println("mySL size: " + mySL.size());
		mySL.printReverse();
		mySL.addLast("Peach Sauce");
		System.out.println(mySL);
		System.out.println("Test: " + mySL);
		mySL.addLast("Pure");
		System.out.println(mySL);
		System.out.print("min: ");
		mySL.printMin();
		System.out.print("max: ");
		mySL.printMax();
		System.out.println("Print all values from a linkedlist: ");
		mySL.print(mySL.header);
		System.out.println("getLast: " + mySL.getLast());
		System.out.println("getFirst: " + mySL.getFirst());
		mySL.removeFirst();
		System.out.println("After remove first: " + mySL);
		mySL.removeLast();
		System.out.println("After remove last : " + mySL);
		mySL.printReverse();
		mySL.deleteNode(mySL.findItem("Apple Pie"));
		System.out.println(mySL);
		mySL.printReverse();
		mySL.deleteNode(mySL.findItem("Peach Sauce"));
		System.out.println(mySL);
		mySL.printReverse();
		mySL.deleteNode(mySL.findItem("Carrot Cake"));
		System.out.println(mySL);
		mySL.printReverse();
		mySL.postAddNode(mySL.findItem("Blueberry Muffin"), "Carrot Cake");
		System.out.println(mySL);
		mySL.printReverse();
		mySL.preAddNode(mySL.findItem("Blueberry Muffin"), "Apple Pie");
		System.out.println(mySL);
		mySL.printReverse();
		mySL.postAddNode(mySL.findItem("Carrot Cake"), "Danish Delight");
		System.out.println(mySL);
		mySL.printReverse();
		mySL.preAddNode(mySL.findItem("Orange Juice"), "Mango Smoothie");
		System.out.println(mySL);
		mySL.printReverse();
		mySL.postAddNode(mySL.findItem("Orange Juice"), "Peach Sauce");
		System.out.println(mySL);
		mySL.printReverse();
		mySL.deleteList();
		System.out.println(mySL);
		mySL.printReverse();

	}

}
