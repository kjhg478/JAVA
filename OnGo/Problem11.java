package OnGo;

import java.util.Arrays;
import java.util.Scanner;

public class Problem11 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int a = Integer.parseInt(sc.nextLine());
		int count = 0;
		
		String[] str = new String[a+1];
		
		str[a] = "0"; 
		str = sc.nextLine().split(" ");
		Arrays.sort(str);
		for(int i = 0; i < a-1; i++) {
			if(str[i].equals(str[i+1])) {
				count++;			
			}
		}
		System.out.print(count);

	}

}
