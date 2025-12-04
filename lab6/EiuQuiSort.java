package lab6;

import java.io.*;
import java.util.*;

public class EiuQuiSort {
	static InputReader rd = new InputReader(System.in);
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) {
		int n = rd.nextInt();
		int[] a = new int[n];
		for (int i = 0; i < n; i++)
			a[i] = rd.nextInt();
		quickSort(a, 0, n - 1);
		for (int x : a)
			sb.append(x).append("\n");
		System.out.print(sb);
	}

	/**
	 * QuickSort tối ưu: - Median-of-3 chọn pivot - Partition kiểu Hoare (rất nhanh)
	 * - Giới hạn đoạn ngắn dùng insertion sort - Eliminate tail recursion (chỉ đệ
	 * quy trên đoạn nhỏ)
	 */
	static void quickSort(int[] a, int l, int r) {

		while (l < r) {

			// Nếu đoạn nhỏ (<16 phần tử) dùng insertionSort cho nhanh hơn
			if (r - l < 16) {
				insertionSort(a, l, r);
				return;
			}

			// Chọn pivot theo median-of-3 và đưa pivot vào vị trí r-1
			int pivot = median3(a, l, r);

			// Partition theo Hoare — trả về vị trí pivot đã đứng đúng
			int mid = partition(a, l, r, pivot);

			/**
			 * QuickSort nhánh nhỏ trước để giảm độ sâu đệ quy rồi cập nhật lại biên l/r để
			 * tiếp tục vòng while
			 */
			if (mid - l < r - mid) {
				// Nhánh trái nhỏ → sort trước
				quickSort(a, l, mid - 1);
				l = mid + 1; // tiếp tục sort nhánh phải bằng vòng while
			} else {
				// Nhánh phải nhỏ → sort trước
				quickSort(a, mid + 1, r);
				r = mid - 1;
			}
		}
	}

	/**
	 * median-of-3: Lấy median của a[l], a[middle], a[r] → đưa phần tử median vào vị
	 * trí r-1 (để làm pivot)
	 */
	static int median3(int[] a, int l, int r) {
		int m = (l + r) >>> 1;

		// Sắp xếp l, m, r theo thứ tự
		if (a[l] > a[m])
			swap(a, l, m);
		if (a[m] > a[r])
			swap(a, m, r);
		if (a[l] > a[m])
			swap(a, l, m);

		// Đưa median (a[m]) ra vị trí r-1 để partition
		swap(a, m, r - 1);

		return a[r - 1];
	}

	/**
	 * Partition kiểu Hoare (nhanh hơn Lomuto)
	 *
	 * mảng dạng: l ... < pivot ... > pivot ... r
	 *
	 * pivot đang ở a[r-1]
	 */
	static int partition(int[] a, int l, int r, int pivot) {

		int i = l;
		int j = r - 1;

		while (true) {

			// i tiến lên tới phần tử >= pivot
			while (a[++i] < pivot) {
			}

			// j lùi lại tới phần tử <= pivot
			while (a[--j] > pivot) {
			}

			// Hai con trỏ chạm nhau → kết thúc
			if (i >= j)
				break;

			// Hoán đổi phần tử sai phía
			swap(a, i, j);
		}

		// Đặt pivot về đúng vị trí cuối cùng của vùng < pivot
		swap(a, i, r - 1);

		return i; // trả về vị trí pivot
	}

	/**
	 * Insertion Sort cho đoạn nhỏ (rất hiệu quả khi đoạn < 16 phần tử)
	 */
	static void insertionSort(int[] a, int l, int r) {
		for (int i = l + 1; i <= r; i++) {
			int key = a[i];
			int j = i - 1;

			while (j >= l && a[j] > key) {
				a[j + 1] = a[j];
				j--;
			}

			a[j + 1] = key;
		}
	}

	// Swap 2 phần tử
	static void swap(int[] a, int i, int j) {
		int t = a[i];
		a[i] = a[j];
		a[j] = t;
	}

	// Fast input
	static class InputReader {
		StringTokenizer st;
		BufferedReader br;

		public InputReader(InputStream s) {
			br = new BufferedReader(new InputStreamReader(s));
		}

		public String next() {
			while (st == null || !st.hasMoreTokens()) {
				try {
					st = new StringTokenizer(br.readLine());
				} catch (IOException e) {
				}
			}
			return st.nextToken();
		}

		public int nextInt() {
			return Integer.parseInt(next());
		}
	}
}
