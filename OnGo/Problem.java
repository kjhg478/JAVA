package OnGo;

import java.util.Scanner;

public class Problem {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int eggs = sc.nextInt();
		
		System.out.println((((eggs % 8)>=1)? 1:0) + (eggs / 8));
		
		while(true) {
			if(eggs % 8 == 0) {
				eggs = eggs / 8;
				break;
			}else if(eggs % 8 != 0) {
				eggs = eggs / 8 + 1;
				break;
			}
		}System.out.println(eggs);
		sc.close();
		
	}
}

/* 한 프라이팬에 4개 달걀 들어가는데 두개의 프라이팬이 있음
 * 손님이 주문했을 때 최소값으로 달걀이 완료되는 걸리는 시간 계산 
 * 달걀 하나를 다 익히는데는 1분 8개까지 1분  */

