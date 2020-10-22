// PROBLEM 4 다른버전

package OnGo;

import java.util.Arrays;
import java.util.Scanner;

public class Problem4_2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String a = sc.next();
		String[] arr = new String[a.length()];
		int sum = 0;
		
		for(int i = 0; i <arr.length; i++) {
			boolean flag = true;
			for(int j=0; j<10; j++) {
				if((a.charAt(i)+"").equals(j+"")) {
					sum += j;
					flag = false;
					break;
				}
			}
			if (flag) {
				arr[i] = a.charAt(i)+"";
			}
		}
	
		for(int i= 0; i <arr.length; i++) {
			if(arr[i]==null) {
				arr[i] = "";
			}
		}
		Arrays.sort(arr);
		
		for(int i = 0; i<arr.length; i++) {
			System.out.print(arr[i]);
		}System.out.print(sum);
	}

}
