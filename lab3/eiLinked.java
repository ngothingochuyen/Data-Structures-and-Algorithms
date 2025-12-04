package lab3;

import java.io.*;
import java.util.*;

public class eiLinked<T extends Number> {

	static InputReader rd = new InputReader(System.in);

	static private class LinkedNode<U extends Number> {
		U number;
		LinkedNode<U> next;

		LinkedNode(U number) {
			this.number = number;
		}
	}

	LinkedNode<T> head = null;
	LinkedNode<T> tail = null;
	private int count = 0;
	private double sum = 0.0;

	private int compare(T n1, T n2) {
		long l1 = n1.longValue();
		long l2 = n2.longValue();
		if (l1 != l2)
			return (l1 < l2 ? -1 : 1);
		return Double.compare(n1.doubleValue(), n2.doubleValue());
	}

	public int size() {
		return count;
	}

	public void add(T number) {
		LinkedNode<T> newNode = new LinkedNode<>(number);

		if (head == null) {
			head = tail = newNode;
		} else {
			tail.next = newNode;
			tail = newNode;
		}
		count++;
		sum += number.doubleValue();
	}

	public int firstIndexOf(T number) {
		int idx = 0;
		LinkedNode<T> current = head;
		while (current != null) {
			if (compare(current.number, number) == 0)
				return idx;
			current = current.next;
			idx++;
		}
		return -1;
	}

	public int lastIndexOf(T number) {
		int idx = 0, last = -1;
		LinkedNode<T> current = head;
		while (current != null) {
			if (compare(current.number, number) == 0)
				last = idx;
			current = current.next;
			idx++;
		}
		return last;
	}

	public void removeFirst(T number) {
		if (head == null)
			return;

		if (compare(head.number, number) == 0) {
			sum -= head.number.doubleValue();
			head = head.next;
			count--;
			if (head == null)
				tail = null;
			return;
		}

		LinkedNode<T> current = head;
		while (current.next != null) {
			if (compare(current.next.number, number) == 0) {
				sum -= current.next.number.doubleValue();
				if (current.next == tail)
					tail = current;
				current.next = current.next.next;
				count--;
				return;
			}
			current = current.next;
		}
	}

	public void removeAt(int index) {
		if (index < 0 || head == null || index >= count)
			return;

		if (index == 0) {
			sum -= head.number.doubleValue();
			head = head.next;
			count--;

			if (head == null)
				tail = null;
			return;
		}

		LinkedNode<T> current = head;
		for (int i = 0; i < index - 1 && current.next != null; i++) {
			current = current.next;
		}

		if (current.next != null) {
			sum -= current.next.number.doubleValue();
			if (current.next == tail)
				tail = current;
			current.next = current.next.next;
			count--;
		}
	}

	public void insertAt(int index, T number) {
		if (index < 0 || index > count)
			return;

		LinkedNode<T> newNode = new LinkedNode<>(number);

		if (index == 0) {
			newNode.next = head;
			head = newNode;

			if (tail == null)
				tail = newNode;
		} else if (index == count) {
			tail.next = newNode;
			tail = newNode;
		} else {
			LinkedNode<T> current = head;
			for (int i = 0; i < index - 1; i++)
				current = current.next;

			newNode.next = current.next;
			current.next = newNode;
		}
		count++;
sum += number.doubleValue();
	}

	public T getAt(int index) {
		if (index < 0 || index >= count)
			return null;
		LinkedNode<T> current = head;
		for (int i = 0; i < index; i++)
			current = current.next;
		return current.number;
	}

	public double sum() {
		return sum;
	}

	public double average() {
		return count == 0 ? 0 : sum / count;
	}

	public static void main(String[] args) {
		StringBuilder sb = new StringBuilder();
		Scanner rd = new Scanner(System.in);
		int n = rd.nextInt(), m = rd.nextInt();
		eiLinked<Integer> linkedList = new eiLinked<>();

		for (int i = 0; i < n; i++)
			linkedList.add(rd.nextInt());
		rd.nextLine();

		for (int i = 0; i < m; i++) {
			String cmp = rd.next();
			switch (cmp) {
			case "insertAt":
				int index = rd.nextInt();
				int value = rd.nextInt();
				linkedList.insertAt(index, value);
				break;
			case "getAt":
				sb.append(linkedList.getAt(rd.nextInt())).append("\n");
				break;
			case "firstIndexOf":
				sb.append(linkedList.firstIndexOf(rd.nextInt())).append("\n");
				break;
			case "lastIndexOf":
				sb.append(linkedList.lastIndexOf(rd.nextInt())).append("\n");
				break;
			case "sum":
				sb.append(linkedList.sum()).append("\n");
				break;
			case "removeAt":
				linkedList.removeAt(rd.nextInt());
				break;
			case "removeFirst":
				linkedList.removeFirst(rd.nextInt());
				break;
			default:
				sb.append(linkedList.average()).append("\n");
				break;
			}
		}
		System.out.println(sb);
	}

	static class InputReader {
		StringTokenizer tokenizer;
		BufferedReader reader;
		String token;
		String temp;

		public InputReader(InputStream stream) {
			tokenizer = null;
			reader = new BufferedReader(new InputStreamReader(stream));
		}

		public InputReader(FileInputStream stream) {
			tokenizer = null;
			reader = new BufferedReader(new InputStreamReader(stream));
		}

		public String nextLine() throws IOException {
			return reader.readLine();
		}

		public String next() {
			while (tokenizer == null || !tokenizer.hasMoreTokens()) {
				try {
					if (temp != null) {
						tokenizer = new StringTokenizer(temp);
						temp = null;
					} else {
						tokenizer = new StringTokenizer(reader.readLine());
					}
				} catch (IOException e) {
				}
			}
			return tokenizer.nextToken();
		}

		public double nextDouble() {
			return Double.parseDouble(next());
		}

		public int nextInt() {
			return Integer.parseInt(next());
		}

		public long nextLong() {
			return Long.parseLong(next());
		}
	}
}