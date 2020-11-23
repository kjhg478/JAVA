package OnGo;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Problem10 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[][] stu = {{1,0,0,0,0},{2,0,0,0,0},{3,0,0,0,0}};
		int num = Integer.parseInt(sc.nextLine());
		String[][] str = new String[num][3];
		int total;
		int total2;
		int total3;
		
		for(int i = 0; i<str.length; i++) {
			str[i] = sc.nextLine().split(" ");
		}
		for(String[] i : str) {
			stu[0][Integer.parseInt(i[0])]++;
			stu[1][Integer.parseInt(i[1])]++;
			stu[2][Integer.parseInt(i[2])]++;
			stu[0][4] += Integer.parseInt(i[0]);
			stu[1][4] += Integer.parseInt(i[1]);
			stu[2][4] += Integer.parseInt(i[2]);
			
		}

		Arrays.sort(stu, new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				
				return (o2[4]) - (o1[4]);
			}
			
		});
		total = stu[0][4];
		int count = 0;
		for (int i = 0; i < 3; i++) {
			if (total==stu[i][4]) {
				count++;
			}
		}
		int[][] answer = new int[count][];
		count = 0;
		
		for (int[] i : stu) {
			if (total==i[4]) {
				answer[count] = i;
				count++;
			}
		}
		
		Arrays.sort(answer, new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				
				return o2[3] - o1[3];
			}
			
		});
		total2 = answer[0][3];
		int count2 = 0;
		for(int i = 0; i<answer.length; i++) {
			if(total2==answer[i][3]) {
				count2++;
			}
		}
		int[][] answer2 = new int[count2][];
		count2 = 0;
		
		for(int[] i : answer) {
			if(i[3]==total2) {
				answer2[count2] = i;
				count2++;
			}
		}
		
		Arrays.sort(answer2, new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				
				return o2[2] - o1[2];
			}
			
		});
		total3 = answer2[0][2];
		int count3 = 0;
		for(int i = 0; i<answer2.length; i++) {
			if(total3==answer2[i][2]) {
				count3++;
			}
		}
		int[][] answer3 = new int[count3][];
		count3 = 0;
		
		for(int[] i : answer2) {
			if(i[2]==total3) {
				answer3[count3] = i;
				count3++;
			}
		}
		if(answer3.length > 1) {
			System.out.println("0 " + answer3[0][4]);
		}else {
			System.out.println(answer3[0][0] +" "+ answer3[0][4]);
		}
	}
}
		
		
//		Arrays.sort(stu, new Comparator<int[]>() {
//
//			@Override
//			public int compare(int[] o1, int[] o2) {
//				
//				return (o1[1]) - (o2[1]);
//			}
//			
//		});
//		
//		Arrays.sort(stu, new Comparator<int[]>() {
//
//			@Override
//			public int compare(int[] o1, int[] o2) {
//				
//				return (o1[2]) - (o2[2]);
//			}
//			
//		});

//		
//		for(int[] i : answer3) {
//			for(int j : i) {
//				System.out.print(j + " ");
//			}
//			System.out.println();
//		}
		
		
		
	


