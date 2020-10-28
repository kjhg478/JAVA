/* 애견카페
 * 7층까지 있다 애견들만 탈 수 있는 엘리베이터
 * 최대 5마리 최대 100kg
 * 입력받은 애들이 스페이스바로 구분
 * 탈 수 있으면 possible : 7층입니다.
 * 못타면 impossible : 삐--
 * 
 * */


package OnGo;

import java.util.Scanner;

public class Problem6 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String a = sc.nextLine();
		String[][] str = {{"cat", "5"}, {"dog","8"}, {"pig","15"}, {"cow","90"}, {"bear","110"}, {"tiger", "70"}};
		
		String[] arr = new String[a.length()];
		arr = a.split(" ");
		int e = 0;
		
		if(arr.length > 6) {
			System.out.println("삐..");
		}else {
			for(int i=0; i<arr.length; i++) {
				for(int j=0; j<str.length; j++) {
					if(arr[i].equals(str[j][0])) {
						e += Integer.parseInt(str[j][1]);

					}
				}
			}
			if ( e <= 100) {
				System.out.println("7층입니다.");
			}else {
				System.out.println( "삐..");
			}
			sc.close();
		}
		
		

		
		
		
		
		
		

	}

}
