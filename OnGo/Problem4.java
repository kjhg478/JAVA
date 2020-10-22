// 문자열은 앞으로 정렬 숫자는 뒤로뺴서 합

package OnGo;

import java.util.Arrays;
import java.util.Scanner;

public class Problem4 {

	public static void main(String[] args) {
		//charAT() 
		Scanner sc = new Scanner(System.in);
		
		String a, b, c;
		a = sc.next();
		b = a.replaceAll("[^0-9]", "");
		c = a.replaceAll("[^A-Z]", ""); // split("") 이렇게면 글자 하나 단위로 나눠짐
		String[] d = new String[b.length()];
		String[] e = new String[c.length()];
		int count = 0;
		
		for ( int i = 0; i < d.length; i++) {
			d[i] = b.substring(i, i+1);	
			count = count + Integer.parseInt(d[i]);
		}
		for (int j = 0; j < e.length; j++) {
			e[j] = c.substring(j, j+1);
		}Arrays.sort(e);
		for (int z = 0; z < e.length; z++) {
			System.out.print(e[z]);
			
		}System.out.print(count);
			
	}

}


