// 출석을 불렀을 때 짝수면 2로 나눔 , 홀수면 1을 뺌, 1이되면 종료


package OnGo;

import java.util.Scanner;

public class Loop {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int scr = sc.nextInt();
		int count = 0;
		
		while(true) {
			if(scr == 1) {
				count++;
				break;
			}
			if(scr % 2 == 0) {
				scr = scr / 2;
				count++;
			}else if (scr % 2 == 1) {
				scr = scr - 1;
				count++;
			}
		}System.out.println(count);
		
	}
}
