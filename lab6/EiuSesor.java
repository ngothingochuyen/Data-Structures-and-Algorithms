package lab6;

import java.util.Scanner;

public class EiuSesor {

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
			selectionSort(intArray);
			printArray(intArray);
			break;

		case "long":
			Long[] longArray = new Long[N];
			for (int i = 0; i < N; i++) {
				longArray[i] = sc.nextLong();
			}
			selectionSort(longArray);
			printArray(longArray);
			break;

		case "float":
			Float[] floatArray = new Float[N];
			for (int i = 0; i < N; i++) {
				floatArray[i] = sc.nextFloat();
			}
			selectionSort(floatArray);
			printArray(floatArray);
			break;

		case "double":
			Double[] doubleArray = new Double[N];
			for (int i = 0; i < N; i++) {
				doubleArray[i] = sc.nextDouble();
			}
			selectionSort(doubleArray);
			printArray(doubleArray);
			break;

		default:
			System.out.println("Invalid data type");
			break;
		}

		sc.close();
	}

	// Giải thuật Selection Sort (Generic)
	static <T extends Number & Comparable<T>> void selectionSort(T[] array) {
		int n = array.length;
		for (int i = 0; i < n - 1; i++) {
			int minIndex = i;
			// Tìm phần tử nhỏ nhất trong phần chưa sắp xếp
			for (int j = i + 1; j < n; j++) {
				if (array[j].compareTo(array[minIndex]) < 0) {
					minIndex = j;
				}
			}
			// Hoán đổi phần tử nhỏ nhất với phần tử đầu của phần chưa sắp xếp
			if (minIndex != i) {
				T temp = array[i];
				array[i] = array[minIndex];
				array[minIndex] = temp;
			}
		}
	}

	// Hàm in ra danh sách
	static <T> void printArray(T[] array) {
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i]);
			if (i < array.length - 1)
				System.out.print(" ");
		}
	}
}