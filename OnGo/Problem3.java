/* 0~9까지의 숫자가 numbers에 들어가 랜덤으로 
 * 그 숫자가 가장 큰 숫자*/

package OnGo;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Problem3 {

	public static void main(String[] args) {
		int[] num = {5, 6, 2, 4, 8, 3, 6};
		
		int x = 1;
		int y = 5;
		int z = 2;
		int count = 0;
		int[] num2 = new int[(y-x)+1];

		for(int i = 0; i < num.length; i++) {
			if(x-1 <= i && i < y) {
				num2[count] = num[i];
				count++;
			}
		}
		Arrays.sort(num2);
		System.out.println(num2[z-1]);
	}


}




/*String[] str = {"5","9","3","1"};


Arrays.sort(str, Comparator.reverseOrder());


for(int i =0; i < str.length; i ++) {
	System.out.print(str[i]);

}*/