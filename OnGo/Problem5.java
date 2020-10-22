/* LUCKY(7) STRIKE 
 * 필살기 : 7이 4개 이상이면
 * LUCKY STRIKE !
 * UNLUCKY STRIKE !
*/
package OnGo;

import java.util.Scanner;

public class Problem5 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		boolean aa = true;
		
		while(aa) {
			System.out.print("숫자 입력 : ");
			String a = sc.next();
			String ch;
			int count = 0;
			for(int i = 0; i < a.length(); i++) {
				if(a.charAt(i) == '7') { // '' char타입
					count ++;			
				}
			}	
			if(count >= 4) {
				System.out.println("Lucky Strike !");
				aa = false;
			}else {
				System.out.println("\nUNLucky Strike ! \n");
			}
			
		}
	}

}
