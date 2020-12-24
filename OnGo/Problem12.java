import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num = 0;
		while(true) {
			System.out.print("숫자 입력(홀수) >> ");
			num = sc.nextInt();
			if(num%2 == 0) {
				System.out.println("홀수를 입력해주세요 ");
			}		
			if(num%2 == 1) break;
		}

		for (int i = num; i > 0; i-=2) {
			for (int j = (i-1)/2; j > 0; j--) {
				System.out.print(" ");
			}
			for (int j = num - (i-1); j > 0; j--) {
				System.out.print("*");
			}
			System.out.println();
		}
		for (int i = 2; i < num; i+=2) {
			for (int j = (i/2); j > 0; j--) {
				System.out.print(" ");
			}
			for (int j = num-i; j > 0; j--) {
				System.out.print("*");
			}
			System.out.println();
		}

	}

}


