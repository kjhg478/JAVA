/* Lucky Strike 7이 4번 이상이면 ex) 77532767
 * 뜨고 demage까지 계산 demage는 ( 77776532 )
 * 
 * */

package OnGo;

import java.util.Arrays;
import java.util.Scanner;

public class Problem7 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String a = sc.next();
		int count = 0;
		String[] b = new String[a.length()];
		
		for(int i = 0; i < a.length(); i ++) {
			if(a.charAt(i) == '7') {
				count++;
			}
		}
		if(count >= 4) {
			System.out.println("Lucky Strike !");
			for(int i=0; i < a.length(); i++) {
				b[i] = a.charAt(i) + "";
				
			}
			Arrays.sort(b);
			System.out.print("Damage : ");
			for(int i = a.length()-1; i >= 0; i--) {
				System.out.print(b[i]);
			}
			
			
		}else {
			System.out.println("UnLucky Strike !");
		}
		
		
	}

}
