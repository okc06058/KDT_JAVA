package P1;

public class Main {

	public static void main(String[] args) {
		MyLinkedList<String> list = new MyLinkedList<>();
		list.add("안녕1");
		list.add("안녕2");
		list.add("안녕3");
		list.add("안녕4");
		list.add("안녕5");
		list.add("안녕6");
		
		String value = list.get(3);
		System.out.println(value);
		
		for(int x = 0; x < 6; x++) {
			System.out.println(list.get(x));
		}
	}

}

class Node<E>{
	E value;
	Node<E> next;
}

class MyLinkedList<E>{
	Node<E> first;
	
	void add(E value) {
		Node<E> newNode = new Node<>();
		newNode.value = value;
	
		if (first == null) {
			first = newNode;
			return;
		}
		
		Node<E> temp = first;
		while(true) {
			if(temp.next == null) {
				break;
			}
			temp = temp.next;
		}
		temp.next = newNode;
	}
	
	E get(int index) {
		Node<E> temp = first;
		for (int x = 0 ; x < index ; x++) {
			temp = temp.next;
		}
		return temp.value;		
	}
	
}