package lab6;

import java.util.Scanner;

public class EiuBusor {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		String dataType = sc.next();

		switch (dataType) {
		case "int":
			Integer[] intArray = new Integer[N];
			for (int i = 0; i < N; i++) {
				intArray[i] = sc.nextInt();
			}
			bubbleSort(intArray);
			printArray(intArray);
			break;

		case "long":
			Long[] longArray = new Long[N];
			for (int i = 0; i < N; i++) {
				longArray[i] = sc.nextLong();
			}
			bubbleSort(longArray);
			printArray(longArray);
			break;

		case "float":
			Float[] floatArray = new Float[N];
			for (int i = 0; i < N; i++) {
				floatArray[i] = sc.nextFloat();
			}
			bubbleSort(floatArray);
			printArray(floatArray);
			break;

		case "double":
			Double[] doubleArray = new Double[N];
			for (int i = 0; i < N; i++) {
				doubleArray[i] = sc.nextDouble();
			}
			bubbleSort(doubleArray);
			printArray(doubleArray);
			break;
		}
	}

	// Generic Bubble Sort: chỉ dùng được với các kiểu Number & Comparable
	static <T extends Number & Comparable<T>> void bubbleSort(T[] array) {
		int n = array.length;
		boolean swapped;
		for (int i = 0; i < n - 1; i++) {
			swapped = false;
			for (int j = 0; j < n - i - 1; j++) {
				if (array[j].compareTo(array[j + 1]) > 0) {
					T temp = array[j];
					array[j] = array[j + 1];
					array[j + 1] = temp;
					swapped = true;
				}
			}
			// Nếu không có hoán đổi nào, danh sách đã được sắp xếp
			if (!swapped)
				break;
		}
	}

	// In ra danh sách
	static <T> void printArray(T[] array) {
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i]);
			if (i < array.length - 1)
				System.out.print(" ");
		}
	}
}
