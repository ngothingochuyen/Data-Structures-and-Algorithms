package lab3;

import java.util.Scanner;

public class LinkeA {
	public static class LinkedList<T extends Number> {
		public static void main(String[] args) {
			Scanner sc = new Scanner(System.in);
			LinkedList<Integer> linkedList = new LinkedList<Integer>();
			int n = sc.nextInt();
			int m = sc.nextInt();
			for (int i = 0; i < m; i++) {
				String rq = sc.next();
				if (rq.equals("insertAt")) {
					int index = sc.nextInt();
					int num = sc.nextInt();
					linkedList.insertAt(index, num);
				} else if (rq.equals("getAt")) {
					int index = sc.nextInt();
					System.out.println(linkedList.getAt(index));
				} else
					System.out.println("null");
			}
		}

		static private class LinkedNode<U extends Number> {
			U number;
			LinkedNode<U> next;

			public LinkedNode(U number) {
				this.number = number;
			}
		}

		LinkedNode<T> head = null;

		public void insertAt(int index, T number) {
			if (index < 0)
				return;
			LinkedNode<T> newNode = new LinkedNode<>(number);
			if (index == 0) {
				newNode.next = head;
				head = newNode;
				return;
			}
			LinkedNode<T> current = head;
			for (int i = 0; i < index - 1 && current != null; i++) {
				current = current.next;
			}
			if (current == null)
				return;
			newNode.next = current.next;
			current.next = newNode;
		}

		public T getAt(int index) {
			if (index < 0)
				return null;
			LinkedNode<T> current = head;
			for (int i = 0; i < index && current != null; i++) {
				current = current.next;
			}
			return (current != null) ? current.number : null;
		}

	}
}