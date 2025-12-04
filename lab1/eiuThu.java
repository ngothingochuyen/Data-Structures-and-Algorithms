package lab1;

import java.util.Scanner;

public class eiuThu {
	//tính số chữ được ghép từ 2 dòng, bỏ qua từ trùng nhau
	static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {
		String a = sc.nextLine();
		String b = sc.nextLine();
		int lengthA = a.length();
		int lengthB = b.length();
		int minLength = lengthA+lengthB-overLaping(a,b); //độ dài cần tìm 
		System.out.println(minLength);

	}
	
	public static int overLaping(String a,String b) {
		int count = 0;
		int length = Math.min(a.length(),b.length());
		for(int i = 0;i<length;i++) {
			String subString = b.substring(0,i+1); //lấy các chữ đầu trong b, từ 0 đến i+1, giống tô đen và giữ lại chữ đó
			if(a.endsWith(subString)) //nếu cuối dãy a bằng với các chữ đầu dãy b vừa lấy thì count lên, nếu không thì tiếp tục tô đen đầu dãy b
				count=i+1; //đếm xem đã tô đen bao nhiêu số
		}
		return count;
	}
}
